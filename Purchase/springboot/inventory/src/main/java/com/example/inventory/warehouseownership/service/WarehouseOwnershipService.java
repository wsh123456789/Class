package com.example.inventory.warehouseownership.service;

import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouseownership.model.QueryWarehouseSelectVo;
import com.example.inventory.warehouseownership.model.WarehouseOwnershipAddVo;
import com.example.inventory.warehouseownership.model.WarehouseOwnershipSelectVo;

public interface WarehouseOwnershipService {

    ResultVo queryPage(WarehouseOwnershipSelectVo warehouseOwnershipSelectVo);

    ResultVo queryWarehouse(QueryWarehouseSelectVo queryWarehouseSelectVo);


    ResultVo add(WarehouseOwnershipAddVo warehouseOwnershipAddVo);
}