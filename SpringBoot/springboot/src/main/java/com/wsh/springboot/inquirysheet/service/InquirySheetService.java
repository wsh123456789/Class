package com.wsh.springboot.inquirysheet.service;

import com.wsh.springboot.inquirysheet.model.CreateInquirySheetAddVo;
import com.wsh.springboot.inquirysheet.model.CreateInquirySheetSelectVo;
import com.wsh.springboot.inquirysheet.model.InquirySelectVo;
import com.wsh.springboot.inquirysheet.model.ModifyState;
import com.wsh.springboot.util.ResultVo;

public interface InquirySheetService {
    // 查询备件
    ResultVo selectMaterial(CreateInquirySheetSelectVo createInquirySheetSelectVo);

    ResultVo search(InquirySelectVo inquirySelectVo);

    ResultVo modifyState(ModifyState modifyState);

    ResultVo add(CreateInquirySheetAddVo createInquirySheetAddVo);

    ResultVo see(String requestForQuotationId);

    ResultVo update(CreateInquirySheetAddVo createInquirySheetAddVo);
}
