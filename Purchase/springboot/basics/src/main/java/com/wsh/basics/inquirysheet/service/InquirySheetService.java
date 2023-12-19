package com.wsh.basics.inquirysheet.service;


import com.wsh.basics.inquirysheet.model.CreateInquirySheetAddVo;
import com.wsh.basics.inquirysheet.model.CreateInquirySheetSelectVo;
import com.wsh.basics.inquirysheet.model.InquirySelectVo;
import com.wsh.basics.inquirysheet.model.ModifyState;
import com.wsh.basics.util.ResultVo;

public interface InquirySheetService {
    // 查询备件
    ResultVo selectMaterial(CreateInquirySheetSelectVo createInquirySheetSelectVo);

    ResultVo search(InquirySelectVo inquirySelectVo);

    ResultVo modifyState(ModifyState modifyState);

    ResultVo add(CreateInquirySheetAddVo createInquirySheetAddVo);

    ResultVo see(String requestForQuotationId);

    ResultVo update(CreateInquirySheetAddVo createInquirySheetAddVo);
}
