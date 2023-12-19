package com.example.inventory.warehousetag.service;

import com.example.inventory.util.ResultVo;
import com.example.inventory.warehousetag.model.WarehouseTagAddVo;
import com.example.inventory.warehousetag.model.WarehouseTagSelectVo;
import com.example.inventory.warehousetag.model.WarehouseTagUpdateStatusVo;
import com.example.inventory.warehousetag.model.WarehouseTagUpdateVo;

public interface WarehouseTagService {

    ResultVo add(WarehouseTagAddVo warehouseTagAddVo);

    ResultVo update(WarehouseTagUpdateVo warehouseTagUpdateVo);

    ResultVo updateStatus(WarehouseTagUpdateStatusVo warehouseTagUpdateStatusVo);

    ResultVo queryPage(WarehouseTagSelectVo warehouseTagSelectVo);
}
