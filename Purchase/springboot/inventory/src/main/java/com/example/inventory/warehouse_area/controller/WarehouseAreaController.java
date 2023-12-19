package com.example.inventory.warehouse_area.controller;

import com.example.inventory.util.ResultBuildVo;
import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouse_area.model.WarehouseAreaAddVo;
import com.example.inventory.warehouse_area.model.WarehouseAreaSelectVo;
import com.example.inventory.warehouse_area.model.WarehouseAreaUpdateStatusVo;
import com.example.inventory.warehouse_area.model.WarehouseAreaUpdateVo;
import com.example.inventory.warehouse_area.service.WarehouseAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("storageSection")
@CrossOrigin// 跨域
public class WarehouseAreaController {
    @Autowired
    private WarehouseAreaService warehouseAreaService;

    // 获取业务属性
    @GetMapping("queryBusinessAttribute")
    @ResponseBody
    public ResultVo queryBusinessAttribute() {
        return warehouseAreaService.queryBusinessAttribute();
    }

    // 分页查询
    @PostMapping("queryPage")
    @ResponseBody
    public ResultVo queryPage(@RequestBody WarehouseAreaSelectVo warehouseAreaSelectVo) {
        return warehouseAreaService.queryPage(warehouseAreaSelectVo);
    }

    // 新增库区
    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid WarehouseAreaAddVo warehouseAreaAddVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(warehouseAreaAddVo);
        return warehouseAreaService.add(warehouseAreaAddVo);
    }

    // 修改库区
    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid WarehouseAreaUpdateVo warehouseAreaUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return warehouseAreaService.update(warehouseAreaUpdateVo);
    }

    // 修复查看取值
    @GetMapping("queryStorageSectionById")
    @ResponseBody
    public ResultVo queryStorageSectionById(Integer id) {
        return warehouseAreaService.queryStorageSectionById(id);
    }

    @PostMapping("updateStatus")
    @ResponseBody
    public ResultVo updateStatus(@RequestBody @Valid WarehouseAreaUpdateStatusVo warehouseAreaUpdateStatusVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(warehouseAreaUpdateStatusVo);
        return warehouseAreaService.updateStatus(warehouseAreaUpdateStatusVo);
    }


}

//    @PostMapping("update")
//    public ResultVo update(@RequestBody @Valid SubClassUpdateVo subClassUpdateVo, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return subClassService.update(subClassUpdateVo);
//    }
//
//    @PostMapping("updateStatus")
//    public ResultVo updateStatus(@RequestBody @Valid SubClassUpdateStatusVo subClassUpdateStatusVo, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return subClassService.updateStatus(subClassUpdateStatusVo);
//    }


