package com.example.inventory.warehouse.controller;

import com.example.inventory.util.ResultBuildVo;
import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouse.model.*;
import com.example.inventory.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 备件小类功能
 */
@RestController
@RequestMapping("warehouse")
@CrossOrigin//支持跨域
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    /**
     *分页
     */
    @PostMapping("queryPage")
    public ResultVo queryPage(@RequestBody WarehouseSelectVo warehouseSelectVo){
        return warehouseService.queryPage(warehouseSelectVo);
    }

    /**
     *新增
     */
    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid WarehouseAddVo warehouseAddVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return warehouseService.add(warehouseAddVo);
    }
    /**
     *修改
     */
    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid WarehouseUpdateVo warehouseUpdateVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(warehouseUpdateVo);
        return warehouseService.update(warehouseUpdateVo);
    }

    /**
     *修改状态
     */
    @PostMapping("updateStatus")
    public ResultVo updateStatus(@RequestBody @Valid WarehouseUpdateStatusVo warehouseUpdateStatusVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return warehouseService.updateStatus(warehouseUpdateStatusVo);
    }
    @GetMapping("queryWarehouseTagList")
    public ResultVo queryWarehouseTagList(){
        return warehouseService.queryWarehouseTagList();
    }

    @GetMapping("getAreaData")
    public ResultVo getAreaData(){
        return warehouseService.getAreaData();
    }


    @GetMapping("getNation")
    public ResultVo getNation(Integer parentId){
        return warehouseService.getNation(parentId);
    }

    @GetMapping("getProvince")
    public ResultVo getProvince(Integer parentId){
        return warehouseService.getProvince(parentId);
    }

    @GetMapping("getCity")
    public ResultVo getCity(Integer parentId){
        return warehouseService.getCity(parentId);
    }

    @GetMapping("getCounty")
    public ResultVo getCounty(Integer parentId){
        return warehouseService.getCounty(parentId);
    }


}
