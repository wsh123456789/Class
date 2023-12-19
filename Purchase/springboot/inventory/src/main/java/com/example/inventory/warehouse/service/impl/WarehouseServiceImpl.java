package com.example.inventory.warehouse.service.impl;

import com.example.inventory.util.AllRecordsVo;
import com.example.inventory.util.ParamUtil;
import com.example.inventory.util.ResultBuildVo;
import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouse.mapper.WarehouseMapper;
import com.example.inventory.warehouse.model.*;
import com.example.inventory.warehouse.service.WarehouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    // 获取地区下拉框
    @Override
    public ResultVo getAreaData() {
        List<AddressVo> addressVos = warehouseMapper.getAreaData();
        return ResultBuildVo.success(addressVos);
    }

    // 国家下拉框
    @Override
    public ResultVo getNation(Integer parentId) {
        List<AddressVo> addressVos = warehouseMapper.getNation(parentId);
        return ResultBuildVo.success(addressVos);
    }

    // 省下拉框
    @Override
    public ResultVo getProvince(Integer parentId) {
        List<AddressVo> addressVos = warehouseMapper.getProvince(parentId);
        return ResultBuildVo.success(addressVos);
    }

    // 市下拉框
    @Override
    public ResultVo getCity(Integer parentId) {
        List<AddressVo> addressVos = warehouseMapper.getCity(parentId);
        return ResultBuildVo.success(addressVos);
    }

    // 县区下拉框
    @Override
    public ResultVo getCounty(Integer parentId) {
        List<AddressVo> addressVos = warehouseMapper.getCounty(parentId);
        return ResultBuildVo.success(addressVos);
    }


    @Override
    public ResultVo queryPage(WarehouseSelectVo warehouseSelectVo) {
        //查询数据
        List<WarehouseVo> warehouseVoList = warehouseMapper.queryData(warehouseSelectVo);
        for (WarehouseVo warehouseVo : warehouseVoList){
            if (warehouseVo.getStatus()){
                warehouseVo.setStatusName(ParamUtil.OPEN);
            }
            if (!warehouseVo.getStatus()){
                warehouseVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        //查询数量
        int count = warehouseMapper.queryCount(warehouseSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(warehouseSelectVo.getPageIndex());
        allRecordsVo.setPageSize(warehouseSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(warehouseVoList);
        return ResultBuildVo.success(allRecordsVo);
    }

    @Override
    public ResultVo queryWarehouseTagList() {
        List<WarehouseTagList> warehouseTagLists = warehouseMapper.queryWarehouseTagList();
        return ResultBuildVo.success(warehouseTagLists);
    }



    @Override
    public ResultVo add(WarehouseAddVo warehouseAddVo) {
        //验证名称是唯一的
        int countName = warehouseMapper.queryByName(warehouseAddVo.getName());
        if(countName != 0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        //验证编码是唯一的
        int countCode = warehouseMapper.queryByCode(warehouseAddVo.getCode());
        if(countCode != 0){
            return ResultBuildVo.error(ParamUtil.CODE_REPEAT);
        }
        Date now = new Date();
        WarehouseVo warehouseVo = new WarehouseVo();
        BeanUtils.copyProperties(warehouseAddVo, warehouseVo);
        warehouseVo.setCreateName(ParamUtil.CHANGE_MAN);
        warehouseVo.setCreateTime(now);
        warehouseVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehouseVo.setChangeTime(now);
        warehouseMapper.add(warehouseVo);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo update(WarehouseUpdateVo warehouseUpdateVo) {
        //修改内容在不在
        WarehouseVo subClass =  warehouseMapper.queryById(warehouseUpdateVo.getId());
        if (subClass==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        //是不是禁用
        if (subClass.getStatus()){
            return ResultBuildVo.error(ParamUtil.UPDATE_DISABLED);
        }
        int countName = warehouseMapper.queryByName(warehouseUpdateVo.getName());
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        Date now = new Date();
        WarehouseVo warehouseVo = new WarehouseVo();
        BeanUtils.copyProperties(warehouseUpdateVo, warehouseVo);
        warehouseVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehouseVo.setChangeTime(now);
        int countVersion = warehouseMapper.update(warehouseVo);
        if(countVersion==0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }

        return ResultBuildVo.success();
    }

    @Override
    public ResultVo updateStatus(WarehouseUpdateStatusVo warehouseUpdateStatusVo) {
        WarehouseVo subClass =  warehouseMapper.queryById(warehouseUpdateStatusVo.getId());
        if (subClass==null){
            return ResultBuildVo.error("修改信息不存在！");
        }
        Date now= new Date();
        WarehouseVo warehouseVo = new WarehouseVo();
        BeanUtils.copyProperties(warehouseUpdateStatusVo, warehouseVo);
        warehouseVo.setChangeName("zhagnsan");
        warehouseVo.setChangeTime(now);
        warehouseMapper.updateStatus(warehouseVo);
        return ResultBuildVo.success();
    }


}
