package com.wsh.basics.inquirysheet.service;


import com.wsh.basics.inquirysheet.model.ShenHeVo;
import com.wsh.basics.inquirysheet.model.ShenPiVo;
import com.wsh.basics.util.ResultVo;

public interface InquiryAuditorService {
    ResultVo updateShenHe(ShenHeVo shenHeVo);

    ResultVo searchShenPi(ShenPiVo shenPiVo);
}
