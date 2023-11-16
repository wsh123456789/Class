package com.wsh.springboot.warehouse_area.service;

import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaAddVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaSelectVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaUpdateStatusVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaUpdateVo;

public interface WarehouseAreaService {

    ResultVo queryPage(WarehouseAreaSelectVo warehouseAreaSelectVo);

    ResultVo queryBusinessAttribute();

    ResultVo add(WarehouseAreaAddVo warehouseAreaAddVo);

    ResultVo update(WarehouseAreaUpdateVo warehouseAreaUpdateVo);

    ResultVo queryStorageSectionById(Integer id);

    ResultVo updateStatus(WarehouseAreaUpdateStatusVo warehouseAreaUpdateStatusVo);

}
