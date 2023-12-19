package com.example.inventory.warehousetag.service.impl;

import com.example.inventory.util.AllRecordsVo;
import com.example.inventory.util.ParamUtil;
import com.example.inventory.util.ResultBuildVo;
import com.example.inventory.util.ResultVo;
import com.example.inventory.warehousetag.mapper.WarehouseTagMapper;
import com.example.inventory.warehousetag.model.*;
import com.example.inventory.warehousetag.service.WarehouseTagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WarehouseTagServiceImpl implements WarehouseTagService {
    @Autowired
    private WarehouseTagMapper warehouseTagMapper;

    @Override
    public ResultVo queryPage(WarehouseTagSelectVo warehouseTagSelectVo) {
        //查询数据
        List<WarehouseTagVo> warehouseTagVoList = warehouseTagMapper.queryData(warehouseTagSelectVo);
        for (WarehouseTagVo warehouseTagVo : warehouseTagVoList){
            if (warehouseTagVo.getStatus()){
                warehouseTagVo.setStatusName(ParamUtil.OPEN);
            }
            if (!warehouseTagVo.getStatus()){
                warehouseTagVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        //查询数量
        int count = warehouseTagMapper.queryCount(warehouseTagSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(warehouseTagSelectVo.getPageIndex());
        allRecordsVo.setPageSize(warehouseTagSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(warehouseTagVoList);
        return ResultBuildVo.success(allRecordsVo);
    }


    @Override
    public ResultVo add(WarehouseTagAddVo warehouseTagAddVo) {
        //验证名称是唯一的
        int countName = warehouseTagMapper.queryByName(warehouseTagAddVo.getName());
        if(countName != 0){
            return ResultBuildVo.error(ParamUtil.WAREHOUSE_TAG + ParamUtil.NAME_REPEAT);
        }
        //验证编码是唯一的
        int countCode = warehouseTagMapper.queryByCode(warehouseTagAddVo.getCode());
        if(countCode != 0){
            return ResultBuildVo.error(ParamUtil.WAREHOUSE_TAG + ParamUtil.CODE_REPEAT);
        }
        Date now = new Date();
        WarehouseTagVo warehouseTagVo = new WarehouseTagVo();
        BeanUtils.copyProperties(warehouseTagAddVo, warehouseTagVo);
        warehouseTagVo.setCreateName(ParamUtil.CHANGE_MAN);
        warehouseTagVo.setCreateTime(now);
        warehouseTagVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehouseTagVo.setChangeTime(now);
        warehouseTagMapper.add(warehouseTagVo);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo update(WarehouseTagUpdateVo warehouseTagUpdateVo) {
        //修改内容在不在
        WarehouseTagVo subClass =  warehouseTagMapper.queryById(warehouseTagUpdateVo.getId());
        if (subClass==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        //是不是禁用
        if (subClass.getStatus()){
            return ResultBuildVo.error(ParamUtil.UPDATE_DISABLED);
        }
        int countName = warehouseTagMapper.queryByName(warehouseTagUpdateVo.getName());
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        Date now = new Date();
        WarehouseTagVo warehouseTagVo = new WarehouseTagVo();
        BeanUtils.copyProperties(warehouseTagUpdateVo, warehouseTagVo);
        warehouseTagVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehouseTagVo.setChangeTime(now);
        int countVersion = warehouseTagMapper.update(warehouseTagVo);
        if(countVersion==0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }

        return ResultBuildVo.success();
    }

    @Override
    public ResultVo updateStatus(WarehouseTagUpdateStatusVo warehouseTagUpdateStatusVo) {
        WarehouseTagVo subClass =  warehouseTagMapper.queryById(warehouseTagUpdateStatusVo.getId());
        if (subClass==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        Date now= new Date();
        WarehouseTagVo warehouseTagVo = new WarehouseTagVo();
        BeanUtils.copyProperties(warehouseTagUpdateStatusVo, warehouseTagVo);
        warehouseTagVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehouseTagVo.setChangeTime(now);
        warehouseTagMapper.updateStatus(warehouseTagVo);
        return ResultBuildVo.success();
    }


}
