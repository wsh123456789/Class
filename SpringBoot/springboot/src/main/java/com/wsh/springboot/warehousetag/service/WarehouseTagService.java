package com.wsh.springboot.warehousetag.service;

import com.wsh.springboot.warehousetag.model.WarehouseTagAddVo;
import com.wsh.springboot.warehousetag.model.WarehouseTagSelectVo;
import com.wsh.springboot.warehousetag.model.WarehouseTagUpdateStatusVo;
import com.wsh.springboot.warehousetag.model.WarehouseTagUpdateVo;
import com.wsh.springboot.util.ResultVo;

public interface WarehouseTagService {

    ResultVo add(WarehouseTagAddVo warehouseTagAddVo);

    ResultVo update(WarehouseTagUpdateVo warehouseTagUpdateVo);

    ResultVo updateStatus(WarehouseTagUpdateStatusVo warehouseTagUpdateStatusVo);

    ResultVo queryPage(WarehouseTagSelectVo warehouseTagSelectVo);
}
