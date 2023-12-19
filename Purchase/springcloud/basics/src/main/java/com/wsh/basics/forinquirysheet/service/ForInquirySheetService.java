package com.wsh.basics.forinquirysheet.service;

import com.wsh.basics.forinquirysheet.model.CreateInquirySheetAddVo;
import com.wsh.basics.forinquirysheet.model.CreateInquirySheetSelectVo;
import com.wsh.basics.forinquirysheet.model.CreateInquirySheetVo;
import com.wsh.basics.qianduan.ResultVO;
import com.wsh.basics.util.ResultVo;

import java.util.List;

public interface ForInquirySheetService {
    ResultVo queryLegalCode(CreateInquirySheetAddVo createInquirySheetAddVo);

    ResultVo queryCodeList(List<String> codeList);

    ResultVo querySupplierCodeList(List<String> supplierList);

    ResultVo querySpareForSupplier(List<String> codeList);

    ResultVo querySupplierForSpare(List<String> supplierList);

    ResultVo selectMaterial(CreateInquirySheetSelectVo createInquirySheetSelectVo);

    ResultVo queryReplacementCount(CreateInquirySheetSelectVo createInquirySheetSelectVo);
}
