package com.wsh.springboot.warehouseownership.controller;

import com.wsh.springboot.storagesection.model.StorageSectionVo;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse.model.WarehouseVo;
import com.wsh.springboot.warehouseownership.mapper.WarehouseOwnershipMapper;
import com.wsh.springboot.warehouseownership.model.*;
import com.wsh.springboot.warehouseownership.service.WarehouseOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * 备件小类功能
 */
@RestController
@RequestMapping("CompanyStorage")
@CrossOrigin//支持跨域
public class WarehouseOwnershipController {
    @Autowired
    private WarehouseOwnershipService warehouseOwnershipService;
    @Autowired
    private WarehouseOwnershipMapper warehouseOwnershipMapper;

    /**
     *分页
     */
    @PostMapping("queryPage")
    public ResultVo queryPage(@RequestBody WarehouseOwnershipSelectVo warehouseOwnershipSelectVo){

        return warehouseOwnershipService.queryPage(warehouseOwnershipSelectVo);
    }
    /**
     * 新增 库房明细列表 无法人
     */
    @PostMapping("queryWarehouse")
    public ResultVo queryWarehouse(@RequestBody QueryWarehouseSelectVo queryWarehouseSelectVo){

        return warehouseOwnershipService.queryWarehouse(queryWarehouseSelectVo);
    }
    /**
     * 查询选中库房下的库区明细列表
     */
    @PostMapping("queryStorageSection")
    public ResultVo queryStorageSection(@RequestBody WareHouseCodeAndStorageSectionName wareHouseCodeAndStorageSectionName){
        List<StorageSectionVo> storageSectionVoList = warehouseOwnershipMapper.queryStorageSection(wareHouseCodeAndStorageSectionName);
        System.out.println(storageSectionVoList);
        return ResultBuildVo.success(storageSectionVoList);
    }
    /**
     *查询库位明细列表
     */
    @PostMapping("WareHouseAndStorageSectionCode")
    public ResultVo queryStorageBinByWareHouseAndStorageSectionCode(@RequestBody WareHouseAndStorageSectionCode wareHouseAndStorageSectionCode){
        System.out.println(wareHouseAndStorageSectionCode.getStorageSectionCodeList());
        List<StorageBinVo> storageBinVosList = warehouseOwnershipMapper.queryStorageBinByWareHouseAndStorageSectionCode(wareHouseAndStorageSectionCode);
        System.out.println(storageBinVosList);
        return ResultBuildVo.success(storageBinVosList);
    }
    /**
     *根据法人id查询信息
     */
    @PostMapping("queryByLegalPersonId")
    public ResultVo queryByLegalPersonId(@RequestBody WareHouseAndStorageSectionCode wareHouseAndStorageSectionCode){
        System.out.println(wareHouseAndStorageSectionCode.getLegalPersonId());
        List<WarehouseVo> warehouseVoList = warehouseOwnershipMapper.queryWarehouseByLegalPersonId(wareHouseAndStorageSectionCode.getLegalPersonId());
        List<StorageSectionVo> storageSectionVoList = warehouseOwnershipMapper.queryStorageSectionByLegalPersonId(wareHouseAndStorageSectionCode.getLegalPersonId());
        List<StorageBinVo> storageBinVoList = warehouseOwnershipMapper.queryStorageBinByLegalPersonId(wareHouseAndStorageSectionCode.getLegalPersonId());
        List allList = new ArrayList();
        allList.add(warehouseVoList);
        allList.add(storageSectionVoList);
        allList.add(storageBinVoList);

        return ResultBuildVo.success(allList);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody WarehouseOwnershipAddVo warehouseOwnershipAddVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return warehouseOwnershipService.add(warehouseOwnershipAddVo);


    }

}
