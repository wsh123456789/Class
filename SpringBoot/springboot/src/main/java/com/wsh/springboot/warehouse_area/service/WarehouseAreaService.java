package com.wsh.springboot.warehouse_area.service;

import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaSelectVo;

public interface WarehouseAreaService {

    ResultVo queryPage(WarehouseAreaSelectVo warehouseAreaSelectVo);
}
