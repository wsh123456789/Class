package com.wsh.springboot.warehousetag.controller;

import com.wsh.springboot.warehousetag.model.WarehouseTagAddVo;
import com.wsh.springboot.warehousetag.model.WarehouseTagSelectVo;
import com.wsh.springboot.warehousetag.model.WarehouseTagUpdateStatusVo;
import com.wsh.springboot.warehousetag.model.WarehouseTagUpdateVo;
import com.wsh.springboot.warehousetag.service.WarehouseTagService;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 备件小类功能
 */
@RestController
@RequestMapping("warehouseTag")
@CrossOrigin//支持跨域
public class WarehouseTagController {
    @Autowired
    private WarehouseTagService warehouseTagService;

    /**
     *分页
     */
    @PostMapping("queryPage")
    public ResultVo queryPage(@RequestBody WarehouseTagSelectVo warehouseTagSelectVo){
        ;
        return warehouseTagService.queryPage(warehouseTagSelectVo);
    }

    /**
     *新增
     */
    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid WarehouseTagAddVo warehouseTagAddVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return warehouseTagService.add(warehouseTagAddVo);
    }
    /**
     *修改
     */
    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid WarehouseTagUpdateVo warehouseTagUpdateVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return warehouseTagService.update(warehouseTagUpdateVo);
    }

    /**
     *修改状态
     */
    @PostMapping("updateStatus")
    public ResultVo updateStatus(@RequestBody @Valid WarehouseTagUpdateStatusVo warehouseTagUpdateStatusVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return warehouseTagService.updateStatus(warehouseTagUpdateStatusVo);
    }
}
