package com.example.inventory.warehouse_position.service;

import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouse_position.model.WarehousePositionAddVo;
import com.example.inventory.warehouse_position.model.WarehousePositionSelectVo;
import com.example.inventory.warehouse_position.model.WarehousePositionUpdateStatusVo;
import com.example.inventory.warehouse_position.model.WarehousePositionUpdateVo;

public interface WarehousePositionService {

    ResultVo queryPage(WarehousePositionSelectVo warehousePositionSelectVo);

    ResultVo queryStorageBin(WarehousePositionSelectVo warehousePositionSelectVo);

    ResultVo add(WarehousePositionAddVo warehousePositionAddVo);

    ResultVo updateStatus(WarehousePositionUpdateStatusVo warehousePositionUpdateStatusVo);

    ResultVo update(WarehousePositionUpdateVo warehousePositionUpdateVo);
}
