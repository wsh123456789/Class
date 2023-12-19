package com.wsh.basics.forinquirysheet.controller;

import com.wsh.basics.forinquirysheet.model.CreateInquirySheetAddVo;
import com.wsh.basics.forinquirysheet.model.CreateInquirySheetSelectVo;
import com.wsh.basics.forinquirysheet.service.ForInquirySheetService;
import com.wsh.basics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feignForInquiry")
public class ForInquirySheetController {
    @Autowired
    private ForInquirySheetService forInquirySheetService;

    // 查询法人是否存在
    @PostMapping("/queryLegalCode")
    public ResultVo queryLegalCode(@RequestBody CreateInquirySheetAddVo createInquirySheetAddVo){
        return forInquirySheetService.queryLegalCode(createInquirySheetAddVo);
    }

    // 查询备件
    @PostMapping("/queryCodeList")
    public ResultVo queryCodeList(List<String> codeList) {
        return forInquirySheetService.queryCodeList(codeList);
    }

    // 查询供应商
    @PostMapping("/querySupplierCodeList")
    public ResultVo querySupplierCodeList(List<String> supplierList){
        return forInquirySheetService.querySupplierCodeList(supplierList);
    }

    @PostMapping("/querySpareForSupplier")
    public ResultVo querySpareForSupplier(List<String> codeList){
        return forInquirySheetService.querySpareForSupplier(codeList);
    }

    @PostMapping("/querySupplierForSpare")
    public ResultVo querySupplierForSpare(List<String> supplierList){
        return forInquirySheetService.querySupplierForSpare(supplierList);
    }


    @PostMapping("/selectMaterial")
    public ResultVo selectMaterial(@RequestBody CreateInquirySheetSelectVo createInquirySheetSelectVo){
        System.out.println(createInquirySheetSelectVo.getCode());
        return forInquirySheetService.selectMaterial(createInquirySheetSelectVo);
    }

    @PostMapping("/queryReplacementCount")
    public ResultVo queryReplacementCount(@RequestBody CreateInquirySheetSelectVo createInquirySheetSelectVo){
        System.out.println(createInquirySheetSelectVo.getCode());
        return forInquirySheetService.queryReplacementCount(createInquirySheetSelectVo);
    }
}
