package com.example.purchase.inquirysheet.service;


import com.example.purchase.inquirysheet.model.CreateInquirySheetAddVo;
import com.example.purchase.inquirysheet.model.CreateInquirySheetSelectVo;
import com.example.purchase.inquirysheet.model.InquirySelectVo;
import com.example.purchase.inquirysheet.model.ModifyState;
import com.example.purchase.util.ResultVo;

public interface InquirySheetService {
    // 查询备件
    ResultVo selectMaterial(CreateInquirySheetSelectVo createInquirySheetSelectVo);

    ResultVo search(InquirySelectVo inquirySelectVo);

    ResultVo modifyState(ModifyState modifyState);

    ResultVo add(CreateInquirySheetAddVo createInquirySheetAddVo);

    ResultVo see(String requestForQuotationId);

    ResultVo update(CreateInquirySheetAddVo createInquirySheetAddVo);
}
