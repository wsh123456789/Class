package com.wsh.springboot.warehouse_area.service.impl;

import com.wsh.springboot.subclass.model.SubClassVo;
import com.wsh.springboot.util.AllRecordsVo;
import com.wsh.springboot.util.ParamUtil;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse_area.mapper.WarehouseAreaMapper;
import com.wsh.springboot.warehouse_area.model.*;
import com.wsh.springboot.warehouse_area.service.WarehouseAreaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WarehouseAreaServiceImpl implements WarehouseAreaService {

    @Autowired
    private WarehouseAreaMapper warehouseAreaMapper;

    @Override
    public ResultVo queryPage(WarehouseAreaSelectVo warehouseAreaSelectVo) {
        //查询数据
        List<WarehouseAreaVo> warehouseAreaVoList = warehouseAreaMapper.queryData(warehouseAreaSelectVo);
        // 查询数量
        int count = warehouseAreaMapper.queryCount(warehouseAreaSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(warehouseAreaSelectVo.getPageIndex());
        allRecordsVo.setPageSize(warehouseAreaSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(warehouseAreaVoList);
        return ResultBuildVo.success(allRecordsVo);
    }

    // 获取业务属性
    @Override
    public ResultVo queryBusinessAttribute() {
        List<BusinessAttributeVo> businessAttributeVos = warehouseAreaMapper.queryBusinessAttribute();
        return ResultBuildVo.success(businessAttributeVos);
    }

    @Override
    public ResultVo add(WarehouseAreaAddVo warehouseAreaAddVo) {
        //验证编码是唯一的
        int countCode = warehouseAreaMapper.queryByCode(warehouseAreaAddVo.getCode());
        if (countCode!=0){
            return ResultBuildVo.error(ParamUtil.WAREHOUSE_AREA + ParamUtil.CODE_REPEAT);
        }
        //验证名称必须是唯一的
        int countName = warehouseAreaMapper.queryByName(warehouseAreaAddVo.getName());
        System.out.println(countName);
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.WAREHOUSE_AREA + ParamUtil.NAME_REPEAT);
        }
        // 把基础信息添加到库区表
        Date now= new Date();
        WarehouseAreaVo warehouseAreaVo = new WarehouseAreaVo();
        BeanUtils.copyProperties(warehouseAreaAddVo,warehouseAreaVo);
        warehouseAreaVo.setCreateName(ParamUtil.CHANGE_MAN);
        warehouseAreaVo.setCreateTime(now);
        warehouseAreaVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehouseAreaVo.setChangeTime(now);
        warehouseAreaMapper.add(warehouseAreaVo);
        // 删除库区原有的业务属性
        warehouseAreaMapper.deleteBusinessAttribute(warehouseAreaAddVo.getCode());
        // 把业务属性添加到连接表;
        warehouseAreaMapper.addBusinessAttribute(warehouseAreaAddVo);
        return ResultBuildVo.success();
    }

    // 修改内容
    @Override
    public ResultVo update(WarehouseAreaUpdateVo warehouseAreaUpdateVo) {
        //修改内容在不在
        WarehouseAreaVo warehouseAreaVo =  warehouseAreaMapper.queryById(warehouseAreaUpdateVo.getId());
        if (warehouseAreaVo==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        //是不是禁用
        if (warehouseAreaVo.getStatus()){
            return ResultBuildVo.error(ParamUtil.UPDATE_DISABLED);
        }
        int countName = warehouseAreaMapper.queryByNameAndId(warehouseAreaUpdateVo.getName(),warehouseAreaUpdateVo.getId());
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        // 修改库区数据
        Date now= new Date();
        WarehouseAreaVo warehouseAreaVo1 = new WarehouseAreaVo();
        BeanUtils.copyProperties(warehouseAreaUpdateVo,warehouseAreaVo1);
        warehouseAreaVo1.setChangeName(ParamUtil.CHANGE_MAN);
        warehouseAreaVo1.setChangeTime(now);
        Integer version = warehouseAreaMapper.update(warehouseAreaVo1);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        // 删除库区原有的业务属性
        warehouseAreaMapper.deleteBusinessAttribute(warehouseAreaUpdateVo.getCode());
        // 把业务属性添加到连接表;
        warehouseAreaMapper.updateBusinessAttribute(warehouseAreaUpdateVo);

        return ResultBuildVo.success();
    }

    // 修改查看
    @Override
    public ResultVo queryStorageSectionById(Integer id) {
        // 查询基础属性
        WarehouseAreaVo warehouseAreaVo = warehouseAreaMapper.queryStorageSectionById(id);
        // 查询属性列表
        List<String> businessAttributeVos = warehouseAreaMapper.queryBusinessAttributeByCode(warehouseAreaVo.getCode());
        // 把属性列表赋值给返回类
        warehouseAreaVo.setBusinessAttribute(businessAttributeVos);
        return ResultBuildVo.success(warehouseAreaVo);
    }

    // 修改状态
    @Override
    public ResultVo updateStatus(WarehouseAreaUpdateStatusVo warehouseAreaUpdateStatusVo) {
        WarehouseAreaVo warehouseAreaVo =  warehouseAreaMapper.queryById(warehouseAreaUpdateStatusVo.getId());
        if (warehouseAreaVo==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        Date now= new Date();
        WarehouseAreaVo warehouseAreaVo1 = new WarehouseAreaVo();
        BeanUtils.copyProperties(warehouseAreaUpdateStatusVo,warehouseAreaVo1);
        warehouseAreaVo1.setChangeName(ParamUtil.CHANGE_MAN);
        warehouseAreaVo1.setChangeTime(now);
        Integer version = warehouseAreaMapper.updateStatus(warehouseAreaVo1);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }


}
