package com.wsh.springboot.warehouse_position.controller;

import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;

import com.wsh.springboot.warehouse_area.model.WarehouseAreaUpdateStatusVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionAddVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionSelectVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionUpdateStatusVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionUpdateVo;
import com.wsh.springboot.warehouse_position.service.WarehousePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("StorageBin")
@CrossOrigin// 跨域
public class WarehousePositionController {
    @Autowired
    private WarehousePositionService warehousePositionService;

    @PostMapping("queryPage")
    @ResponseBody
    public ResultVo queryPage(@RequestBody WarehousePositionSelectVo warehousePositionSelectVo) {
        return warehousePositionService.queryPage(warehousePositionSelectVo);
    }

    @PostMapping("queryStorageBin")
    @ResponseBody
    public ResultVo queryStorageBin(@RequestBody WarehousePositionSelectVo warehousePositionSelectVo) {
        return warehousePositionService.queryStorageBin(warehousePositionSelectVo);
    }

    @PostMapping("add")
    @ResponseBody
    public ResultVo add(@RequestBody WarehousePositionAddVo warehousePositionAddVo) {
        return warehousePositionService.add(warehousePositionAddVo);
    }

    @PostMapping("updateStatus")
    @ResponseBody
    public ResultVo updateStatus(@RequestBody @Valid WarehousePositionUpdateStatusVo warehousePositionUpdateStatusVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return warehousePositionService.updateStatus(warehousePositionUpdateStatusVo);
    }

    @PostMapping("update")
    @ResponseBody
    public ResultVo update(@RequestBody @Valid WarehousePositionUpdateVo warehousePositionUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return warehousePositionService.update(warehousePositionUpdateVo);
    }
}
