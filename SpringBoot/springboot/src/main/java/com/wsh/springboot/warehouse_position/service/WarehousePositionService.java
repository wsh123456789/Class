package com.wsh.springboot.warehouse_position.service;

import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionAddVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionSelectVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionUpdateStatusVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionUpdateVo;

public interface WarehousePositionService {

    ResultVo queryPage(WarehousePositionSelectVo warehousePositionSelectVo);

    ResultVo queryStorageBin(WarehousePositionSelectVo warehousePositionSelectVo);

    ResultVo add(WarehousePositionAddVo warehousePositionAddVo);

    ResultVo updateStatus(WarehousePositionUpdateStatusVo warehousePositionUpdateStatusVo);

    ResultVo update(WarehousePositionUpdateVo warehousePositionUpdateVo);
}
