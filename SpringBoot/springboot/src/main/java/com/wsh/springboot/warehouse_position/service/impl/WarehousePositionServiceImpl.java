package com.wsh.springboot.warehouse_position.service.impl;

import com.wsh.springboot.util.AllRecordsVo;
import com.wsh.springboot.util.ParamUtil;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaVo;
import com.wsh.springboot.warehouse_position.mapper.WarehousePositionMapper;
import com.wsh.springboot.warehouse_position.model.*;
import com.wsh.springboot.warehouse_position.service.WarehousePositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class WarehousePositionServiceImpl implements WarehousePositionService {
    @Autowired
    private WarehousePositionMapper warehousePositionMapper;

    // 分页查询
    @Override
    public ResultVo queryPage(WarehousePositionSelectVo warehousePositionSelectVo) {
        //查询数据
        List<WarehousePositionVo> warehousePositionVos = warehousePositionMapper.queryData(warehousePositionSelectVo);
        for (WarehousePositionVo warehousePositionVo:warehousePositionVos){
            if (warehousePositionVo.getStatus()){
                warehousePositionVo.setStatusName(ParamUtil.OPEN);
            }
            if (!warehousePositionVo.getStatus()){
                warehousePositionVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        // 查询数量
        int count = warehousePositionMapper.queryCount(warehousePositionSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(warehousePositionSelectVo.getPageIndex());
        allRecordsVo.setPageSize(warehousePositionSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(warehousePositionVos);
        return ResultBuildVo.success(allRecordsVo);
    }

    @Override
    public ResultVo queryStorageBin(WarehousePositionSelectVo warehousePositionSelectVo) {
        //查询数据
        List<WarehousePositionVo> warehousePositionVos = warehousePositionMapper.queryDataBin(warehousePositionSelectVo);
        return ResultBuildVo.success(warehousePositionVos);
    }

    // 批量添加
    @Override
    public ResultVo add(WarehousePositionAddVo warehousePositionAddVo) {
        List<WarehousePositionVo> warehousePositionVos = new ArrayList<>();
        HashSet<String> codes = new HashSet<>();
        for (WarehousePositionAddVo wa : warehousePositionAddVo.getList()){
            codes.add(wa.getCode());
        }
        if (codes.size() < warehousePositionAddVo.getList().size()){
            return ResultBuildVo.error(ParamUtil.WAREHOUSE_POSITION + ParamUtil.CODE_REPEAT);
        }
        for (WarehousePositionAddVo wa : warehousePositionAddVo.getList()){
            //验证编码是唯一的
            WarehousePositionVo wp = warehousePositionMapper.queryByCode(wa.getCode());
            System.out.println(wp);
            if (wp!=null){
                // 编码不唯一需要存储法人id
                wa.setLegalPersonId(wp.getLegalPersonId());
                // 删除原有数据
                warehousePositionMapper.deleteByCode(wa.getCode());
            }
            //验证名称必须是唯一的
            int countName = warehousePositionMapper.queryByName(wa.getName());
            System.out.println(countName);
            if (countName!=0){
                return ResultBuildVo.error(ParamUtil.WAREHOUSE_POSITION + ParamUtil.NAME_REPEAT);
            }

            // 把基础信息添加到库区表
            Date now= new Date();
            WarehousePositionVo warehousePositionVo = new WarehousePositionVo();
            BeanUtils.copyProperties(wa,warehousePositionVo);
            warehousePositionVo.setCreateName(ParamUtil.CHANGE_MAN);
            warehousePositionVo.setCreateTime(now);
            warehousePositionVo.setChangeName(ParamUtil.CHANGE_MAN);
            warehousePositionVo.setChangeTime(now);
            warehousePositionVos.add(warehousePositionVo);
        }
        warehousePositionMapper.add(warehousePositionVos);

        return ResultBuildVo.success();
    }

    // 修改状态
    @Override
    public ResultVo updateStatus(WarehousePositionUpdateStatusVo warehousePositionUpdateStatusVo) {
        WarehousePositionVo warehousePositionVo1 =  warehousePositionMapper.queryById(warehousePositionUpdateStatusVo.getId());
        if (warehousePositionVo1==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        Date now= new Date();
        WarehousePositionVo warehousePositionVo = new WarehousePositionVo();
        BeanUtils.copyProperties(warehousePositionUpdateStatusVo,warehousePositionVo);
        warehousePositionVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehousePositionVo.setChangeTime(now);
        Integer version = warehousePositionMapper.updateStatus(warehousePositionVo);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }

    // 修改数据
    @Override
    public ResultVo update(WarehousePositionUpdateVo warehousePositionUpdateVo) {
        //修改内容在不在
        WarehousePositionVo warehousePositionVo1 =  warehousePositionMapper.queryById(warehousePositionUpdateVo.getId());
        if (warehousePositionVo1==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }

        // 名称不能重复
        int countName = warehousePositionMapper.queryByNameAndId(warehousePositionUpdateVo.getName(),warehousePositionUpdateVo.getId());
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        // 修改库区数据
        Date now= new Date();
        WarehousePositionVo warehousePositionVo = new WarehousePositionVo();
        BeanUtils.copyProperties(warehousePositionUpdateVo,warehousePositionVo);
        warehousePositionVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehousePositionVo.setChangeTime(now);
        Integer version = warehousePositionMapper.update(warehousePositionVo);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        //
        return ResultBuildVo.success();
    }
}
