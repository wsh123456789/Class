package com.wsh.springboot.warehouseownership.service;

import com.wsh.springboot.storagesection.model.StorageSectionVo;
import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouseownership.model.QueryWarehouseSelectVo;
import com.wsh.springboot.warehouseownership.model.WarehouseOwnershipAddVo;
import com.wsh.springboot.warehouseownership.model.WarehouseOwnershipSelectVo;

import java.util.List;

public interface WarehouseOwnershipService {

    ResultVo queryPage(WarehouseOwnershipSelectVo warehouseOwnershipSelectVo);

    ResultVo queryWarehouse(QueryWarehouseSelectVo queryWarehouseSelectVo);


    ResultVo add(WarehouseOwnershipAddVo warehouseOwnershipAddVo);
}