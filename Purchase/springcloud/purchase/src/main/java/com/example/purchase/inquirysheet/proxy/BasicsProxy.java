package com.example.purchase.inquirysheet.proxy;

import com.example.purchase.inquirysheet.model.CreateInquirySheetAddVo;
import com.example.purchase.inquirysheet.model.CreateInquirySheetSelectVo;
import com.example.purchase.inquirysheet.model.CreateInquirySheetVo;
import com.example.purchase.util.ResultVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "basics")
public interface BasicsProxy {

    @PostMapping("feignForInquiry/queryLegalCode")
    ResultVo queryLegalCode(CreateInquirySheetAddVo createInquirySheetAddVo);

    @PostMapping("feignForInquiry/queryCodeList")
    ResultVo queryCodeList(@Param("codeList") List<String> codeList);

    @PostMapping("feignForInquiry/querySupplierCodeList")
    ResultVo querySupplierCodeList(@Param("supplierList") List<String> supplierList);

    @PostMapping("feignForInquiry/querySpareForSupplier")
    ResultVo querySpareForSupplier(@Param("codeList") List<String> codeList);

    @PostMapping("feignForInquiry/querySupplierForSpare")
    ResultVo querySupplierForSpare(@Param("supplierList")List<String> supplierList);

    @PostMapping("feignForInquiry/selectMaterial")
    ResultVo selectMaterial(@RequestBody CreateInquirySheetSelectVo createInquirySheetSelectVo);

    @PostMapping("feignForInquiry/queryReplacementCount")
    ResultVo queryReplacementCount(@RequestBody CreateInquirySheetSelectVo createInquirySheetSelectVo);
}
