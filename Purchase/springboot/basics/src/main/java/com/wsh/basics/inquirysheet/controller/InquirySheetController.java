package com.wsh.basics.inquirysheet.controller;

import com.wsh.basics.inquirysheet.model.CreateInquirySheetAddVo;
import com.wsh.basics.inquirysheet.model.CreateInquirySheetSelectVo;
import com.wsh.basics.inquirysheet.model.InquirySelectVo;
import com.wsh.basics.inquirysheet.model.ModifyState;
import com.wsh.basics.inquirysheet.service.InquirySheetService;
import com.wsh.basics.util.ResultBuildVo;
import com.wsh.basics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("inquiryList")
@CrossOrigin
public class InquirySheetController {

    @Autowired
    private InquirySheetService inquirySheetService;

    /**
     * 主界面查询
     * */
    @PostMapping("search")
    public ResultVo search(@RequestBody InquirySelectVo inquirySelectVo){
        return inquirySheetService.search(inquirySelectVo);
    }
    /**
     * 备件查询查询
     * */
    @PostMapping("selectMaterial")
    @ResponseBody
    public ResultVo selectMaterial(@RequestBody CreateInquirySheetSelectVo createInquirySheetSelectVo){
        return inquirySheetService.selectMaterial(createInquirySheetSelectVo);
    }

    /**
     * 新增询价单
    * */
    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid CreateInquirySheetAddVo createInquirySheetAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return inquirySheetService.add(createInquirySheetAddVo);
//        System.out.println(createInquirySheetAddVo.getInquiryStatus());
//        return null;
    }

    /**
     * 询价单作废
     * */
    @PostMapping("modifyState")
    public ResultVo modifyState(@RequestBody @Valid ModifyState modifyState, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return inquirySheetService.modifyState(modifyState);
    }

    @PostMapping("see")
    public ResultVo see(@RequestBody InquirySelectVo inquirySelectVo){
        return inquirySheetService.see(inquirySelectVo.getRequestForQuotationId());
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid CreateInquirySheetAddVo createInquirySheetAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return inquirySheetService.update(createInquirySheetAddVo);
    }


}
