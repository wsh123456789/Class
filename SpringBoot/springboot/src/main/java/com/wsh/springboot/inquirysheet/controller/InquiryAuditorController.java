package com.wsh.springboot.inquirysheet.controller;

import com.wsh.springboot.inquirysheet.model.InquirySelectVo;
import com.wsh.springboot.inquirysheet.model.ShenHeVo;
import com.wsh.springboot.inquirysheet.model.ShenPiVo;
import com.wsh.springboot.inquirysheet.service.InquiryAuditorService;
import com.wsh.springboot.util.PageVo;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InquiryAuditorController {
    @Autowired
    private InquiryAuditorService inquiryAuditorService;
    //  审核
    @PostMapping("inquiryAuditor/update")
    public ResultVo updateShenHe(@RequestBody ShenHeVo shenHeVo,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return inquiryAuditorService.updateShenHe(shenHeVo);
    }
    // 审批
    @PostMapping("inquiryApprover/update")
    public ResultVo searchShenPi(@RequestBody ShenPiVo shenPiVo,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
//        System.out.println(shenPiVo);
        return inquiryAuditorService.searchShenPi(shenPiVo);
//        return null;
    }
}
