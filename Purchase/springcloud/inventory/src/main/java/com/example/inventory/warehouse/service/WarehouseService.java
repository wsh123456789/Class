package com.example.inventory.warehouse.service;

import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouse.model.*;

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
