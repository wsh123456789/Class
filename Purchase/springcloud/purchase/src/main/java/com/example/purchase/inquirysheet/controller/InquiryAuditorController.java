package com.example.purchase.inquirysheet.controller;

import com.example.purchase.inquirysheet.model.ShenHeVo;
import com.example.purchase.inquirysheet.model.ShenPiVo;
import com.example.purchase.inquirysheet.service.InquiryAuditorService;
import com.example.purchase.util.ResultBuildVo;
import com.example.purchase.util.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wsh.basics.common.model.LegalPersonVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin// 跨域
@Api(value = "SubClassController",description = "询价审核审批功能")
@DefaultProperties(defaultFallback = "morenJiangJi")
public class InquiryAuditorController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("inquiryList/getRedisValue")
    public List<LegalPersonVo> getRedisValue(){
        List<LegalPersonVo> list = (List<LegalPersonVo>) redisTemplate.opsForValue().get("legalPersonPullDownList1");
        return list;
    }

    public ResultVo morenJiangJi()throws Exception{
        return ResultBuildVo.error("当前网络开小差了，请刷新后重试！！！");
    }

    @Autowired
    private InquiryAuditorService inquiryAuditorService;
    //  审核
    @PostMapping("inquiryAuditor/update")
    @HystrixCommand
    @ApiOperation(value = "询价审核")
    public ResultVo updateShenHe(@RequestBody ShenHeVo shenHeVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return inquiryAuditorService.updateShenHe(shenHeVo);
    }
    // 审批
    @PostMapping("inquiryApprover/update")
    @HystrixCommand
    @ApiOperation(value = "询价审批")
    public ResultVo searchShenPi(@RequestBody ShenPiVo shenPiVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
//        System.out.println(shenPiVo);
        return inquiryAuditorService.searchShenPi(shenPiVo);
//        return null;
    }
}
