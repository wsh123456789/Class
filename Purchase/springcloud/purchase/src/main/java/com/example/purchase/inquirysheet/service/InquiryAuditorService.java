package com.example.purchase.inquirysheet.service;


import com.example.purchase.inquirysheet.model.ShenHeVo;
import com.example.purchase.inquirysheet.model.ShenPiVo;
import com.example.purchase.util.ResultVo;

public interface InquiryAuditorService {
    ResultVo updateShenHe(ShenHeVo shenHeVo);

    ResultVo searchShenPi(ShenPiVo shenPiVo);
}
