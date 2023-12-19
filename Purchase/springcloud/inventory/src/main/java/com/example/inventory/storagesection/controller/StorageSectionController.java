package com.example.inventory.storagesection.controller;

import com.example.inventory.storagesection.model.StorageSectionAddVo;
import com.example.inventory.storagesection.model.StorageSectionSelectVo;
import com.example.inventory.storagesection.model.StorageSectionUpdateStatusVo;
import com.example.inventory.storagesection.model.StorageSectionUpdateVo;
import com.example.inventory.storagesection.service.StorageSectionService;
import com.example.inventory.util.ResultBuildVo;
import com.example.inventory.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 备件小类功能
 */
@RestController
@RequestMapping("pickingArea")
@CrossOrigin//支持跨域
public class StorageSectionController {
    @Autowired
    private StorageSectionService storageSectionService;

    /**
     *分页
     */
    @PostMapping("queryPage")
    public ResultVo queryPage(@RequestBody StorageSectionSelectVo storageSectionSelectVo){
        ;
        return storageSectionService.queryPage(storageSectionSelectVo);
    }

    /**
     *新增
     */
    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid StorageSectionAddVo storageSectionAddVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return storageSectionService.add(storageSectionAddVo);
    }
    /**
     *修改
     */
    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid StorageSectionUpdateVo storageSectionUpdateVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return storageSectionService.update(storageSectionUpdateVo);
    }

    /**
     *修改状态
     */
    @PostMapping("updateStatus")
    public ResultVo updateStatus(@RequestBody @Valid StorageSectionUpdateStatusVo storageSectionUpdateStatusVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return storageSectionService.updateStatus(storageSectionUpdateStatusVo);
    }
}
