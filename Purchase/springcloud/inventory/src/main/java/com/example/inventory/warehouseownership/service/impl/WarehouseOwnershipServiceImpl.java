package com.example.inventory.warehouseownership.service.impl;

import com.example.inventory.util.AllRecordsVo;
import com.example.inventory.util.ParamUtil;
import com.example.inventory.util.ResultBuildVo;
import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouseownership.mapper.WarehouseOwnershipMapper;
import com.example.inventory.warehouseownership.model.*;
import com.example.inventory.warehouseownership.service.WarehouseOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseOwnershipServiceImpl implements WarehouseOwnershipService {
    @Autowired
    private WarehouseOwnershipMapper warehouseOwnershipMapper;

    @Override
    public ResultVo queryPage(WarehouseOwnershipSelectVo warehouseOwnershipSelectVo) {
        //查询数据
        List<WarehouseOwnershipVo> warehouseTagVoList = warehouseOwnershipMapper.queryData(warehouseOwnershipSelectVo);
        for (WarehouseOwnershipVo warehouseOwnershipVo : warehouseTagVoList){
            if (warehouseOwnershipVo.getStatus()){
                warehouseOwnershipVo.setStatusName(ParamUtil.OPEN);
            }
            if (!warehouseOwnershipVo.getStatus()){
                warehouseOwnershipVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        //查询数量
        int count = warehouseOwnershipMapper.queryCount(warehouseOwnershipSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(warehouseOwnershipSelectVo.getPageIndex());
        allRecordsVo.setPageSize(warehouseOwnershipSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(warehouseTagVoList);
        return ResultBuildVo.success(allRecordsVo);
    }

    @Override
    public ResultVo queryWarehouse(QueryWarehouseSelectVo queryWarehouseSelectVo) {
        List<WarehouseOwnershipVo> warehouseVoList = warehouseOwnershipMapper.queryWarehouse(queryWarehouseSelectVo);
        for (WarehouseOwnershipVo warehouseOwnershipVo : warehouseVoList){
            if (warehouseOwnershipVo.getStatus()){
                warehouseOwnershipVo.setStatusName(ParamUtil.OPEN);
            }
            if (!warehouseOwnershipVo.getStatus()){
                warehouseOwnershipVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        return ResultBuildVo.success(warehouseVoList);

    }

    @Override
    public ResultVo add(WarehouseOwnershipAddVo warehouseOwnershipAddVo) {
        int countLegalPersonId = warehouseOwnershipMapper.queryByLegalPersonId(warehouseOwnershipAddVo.getLegalPersonId());
        if(countLegalPersonId == 0){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        warehouseOwnershipMapper.delete(warehouseOwnershipAddVo);
        warehouseOwnershipMapper.add(warehouseOwnershipAddVo);
        return ResultBuildVo.success();

    }


}
