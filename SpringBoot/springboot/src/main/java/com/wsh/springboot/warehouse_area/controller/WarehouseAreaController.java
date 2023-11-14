package com.wsh.springboot.warehouse_area.controller;

import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaSelectVo;
import com.wsh.springboot.warehouse_area.service.WarehouseAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("storageSection")
@CrossOrigin// 跨域
public class WarehouseAreaController {
    @Autowired
    private WarehouseAreaService warehouseAreaService;

    // 分页查询
    @PostMapping("queryPage")
    @ResponseBody
    public ResultVo queryPage(@RequestBody WarehouseAreaSelectVo warehouseAreaSelectVo){

        return warehouseAreaService.queryPage(warehouseAreaSelectVo);
    }

    // 修改
}

