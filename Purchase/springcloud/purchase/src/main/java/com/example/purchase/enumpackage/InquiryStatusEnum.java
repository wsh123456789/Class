package com.example.purchase.enumpackage;

import com.example.purchase.util.ParamUtil;


public enum InquiryStatusEnum {

    VOIDED(ParamUtil.ZERO, ParamUtil.VOIDED),
    SAVED(ParamUtil.ONE,ParamUtil.SAVED),
    SUBMITTED(ParamUtil.TWO,ParamUtil.SUBMITTED),
    AUDITED(ParamUtil.THREE,ParamUtil.AUDITED),
    NOT_QUOTE(ParamUtil.FOUR,ParamUtil.NOT_QUOTE);

    private final Integer value;

    private final String name;

    InquiryStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
