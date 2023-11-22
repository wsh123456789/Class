package com.wsh.springboot.common.controller;

import com.wsh.springboot.common.model.GetNameTimeIdVo;
import com.wsh.springboot.common.service.CommonService;

import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
@CrossOrigin
public class CommonController {

    @Autowired
    private CommonService commonService;
    // 状态下拉框
    @PostMapping("metadata/getPullDownList")
    public ResultVo getPullDownList(@RequestBody List<String> keyList, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return commonService.getPullDownList(keyList);
    }
    // 法人名称下拉框
    @GetMapping("legalPerson/ofCurrentUser")
    public ResultVo getLegalPersonDropDown(){
        // 从Session中获取用户id
        Integer id = 1;
        return commonService.queryLegalPersonListById(id);
    }

    // 备件下拉框
    @GetMapping("replacement/ofLegalPerson")
    public ResultVo getReplacementDropDown(String legalPersonCode){

        return commonService.getReplacementListByCode(legalPersonCode);
    }

    // 备件小类下拉框
    @GetMapping("subclass/getPullDownList")
    public ResultVo getSubclassDropDown(String replacementCode){
        return commonService.getSubclassListByCode(replacementCode);
    }

    // 库房编码下拉框
    @GetMapping("storageSection/queryWareHouse")
    public ResultVo queryWareHouse(){
        return commonService.queryWareHouse();
    }

    // 库房库区编码下拉框
    @GetMapping("StorageBin/queryStorageSection")
    @ResponseBody
    public ResultVo queryStorageSection(String code) {
        return commonService.queryStorageSection(code);
    }

    // 询价人员回显
    @GetMapping("plan/getUser")
    public ResultVo getUser(){
        GetNameTimeIdVo nameTimeIdVo = new GetNameTimeIdVo();
        nameTimeIdVo.setCreateName("张三");
        nameTimeIdVo.setCreateTime(new Date());

        return ResultBuildVo.success(nameTimeIdVo);
    }

}
