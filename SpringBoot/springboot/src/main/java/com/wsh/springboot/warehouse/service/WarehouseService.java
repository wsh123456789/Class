package com.wsh.springboot.warehouse.service;

import com.wsh.springboot.warehouse.model.*;
import com.wsh.springboot.util.ResultVo;

public interface WarehouseService {

    ResultVo add(WarehouseAddVo warehouseAddVo);

    ResultVo update(WarehouseUpdateVo warehouseUpdateVo);

    ResultVo updateStatus(WarehouseUpdateStatusVo warehouseUpdateStatusVo);

    ResultVo queryPage(WarehouseSelectVo warehouseSelectVo);

    ResultVo queryWarehouseTagList();

    ResultVo getAreaData();

    ResultVo getNation(Integer parentId);

    ResultVo getProvince(Integer parentId);

    ResultVo getCity(Integer parentId);

    ResultVo getCounty(Integer parentId);
}
