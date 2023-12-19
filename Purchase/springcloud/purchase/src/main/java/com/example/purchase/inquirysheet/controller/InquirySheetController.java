package com.example.purchase.inquirysheet.controller;

import com.example.purchase.inquirysheet.model.CreateInquirySheetAddVo;
import com.example.purchase.inquirysheet.model.CreateInquirySheetSelectVo;
import com.example.purchase.inquirysheet.model.InquirySelectVo;
import com.example.purchase.inquirysheet.model.ModifyState;
import com.example.purchase.inquirysheet.service.InquirySheetService;
import com.example.purchase.util.ResultBuildVo;
import com.example.purchase.util.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("inquiryList")
@CrossOrigin// 跨域
@Api(value = "SubClassController",description = "询价基础功能")
@DefaultProperties(defaultFallback = "morenJiangJi")
public class InquirySheetController {

    public ResultVo morenJiangJi()throws Exception{
        return ResultBuildVo.error("当前网络开小差了，请刷新后重试！！！");
    }

    @Autowired
    private InquirySheetService inquirySheetService;

    /**
     * 主界面查询
     * */
    @PostMapping("search")
    @HystrixCommand
    @ApiOperation(value = "询价主界面查询")
    public ResultVo search(@RequestBody InquirySelectVo inquirySelectVo){
        System.out.println("search");
        return inquirySheetService.search(inquirySelectVo);
    }
    /**
     * 备件查询查询
     * */
    @PostMapping("selectMaterial")
    @ResponseBody
    @HystrixCommand
    @ApiOperation(value = "询价备件查询")
    public ResultVo selectMaterial(@RequestBody CreateInquirySheetSelectVo createInquirySheetSelectVo){
        return inquirySheetService.selectMaterial(createInquirySheetSelectVo);
    }

    /**
     * 新增询价单
    * */
    @PostMapping("add")
    @HystrixCommand
    @ApiOperation(value = "询价 新增询价单")
    public ResultVo add(@RequestBody @Valid CreateInquirySheetAddVo createInquirySheetAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return inquirySheetService.add(createInquirySheetAddVo);
    }

    /**
     * 询价单作废
     * */
    @PostMapping("modifyState")
    @HystrixCommand
    @ApiOperation(value = "询价 询价单作废")
    public ResultVo modifyState(@RequestBody @Valid ModifyState modifyState, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return inquirySheetService.modifyState(modifyState);
    }

    @PostMapping("see")
    @HystrixCommand
    @ApiOperation(value = "询价 询价单查看")
    public ResultVo see(@RequestBody InquirySelectVo inquirySelectVo){
        return inquirySheetService.see(inquirySelectVo.getRequestForQuotationId());
    }

    @PostMapping("update")
    @HystrixCommand
    @ApiOperation(value = "询价 询价单修改")
    public ResultVo update(@RequestBody @Valid CreateInquirySheetAddVo createInquirySheetAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return inquirySheetService.update(createInquirySheetAddVo);
    }


}
