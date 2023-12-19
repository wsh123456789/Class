package com.example.inventory.warehouse_area.service;

import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouse_area.model.WarehouseAreaAddVo;
import com.example.inventory.warehouse_area.model.WarehouseAreaSelectVo;
import com.example.inventory.warehouse_area.model.WarehouseAreaUpdateStatusVo;
import com.example.inventory.warehouse_area.model.WarehouseAreaUpdateVo;

public interface WarehouseAreaService {

    ResultVo queryPage(WarehouseAreaSelectVo warehouseAreaSelectVo);

    ResultVo queryBusinessAttribute();

    ResultVo add(WarehouseAreaAddVo warehouseAreaAddVo);

    ResultVo update(WarehouseAreaUpdateVo warehouseAreaUpdateVo);

    ResultVo queryStorageSectionById(Integer id);

    ResultVo updateStatus(WarehouseAreaUpdateStatusVo warehouseAreaUpdateStatusVo);

}
