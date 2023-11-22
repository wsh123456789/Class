package com.wsh.springboot.inquirysheet.service;

import com.wsh.springboot.inquirysheet.model.InquirySelectVo;
import com.wsh.springboot.inquirysheet.model.ShenHeVo;
import com.wsh.springboot.inquirysheet.model.ShenPiVo;
import com.wsh.springboot.util.ResultVo;

public interface InquiryAuditorService {
    ResultVo updateShenHe(ShenHeVo shenHeVo);

    ResultVo searchShenPi(ShenPiVo shenPiVo);
}
