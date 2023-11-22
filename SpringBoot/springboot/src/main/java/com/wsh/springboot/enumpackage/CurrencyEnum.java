package com.wsh.springboot.enumpackage;

import com.wsh.springboot.util.ParamUtil;

public enum CurrencyEnum {
    RMB(ParamUtil.ZERO,ParamUtil.RMB),DOLLAR(ParamUtil.ONE,ParamUtil.DOLLAR),POUND(ParamUtil.TWO,ParamUtil.POUND);

    private Integer value;
    private String name;

    CurrencyEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public Integer getValue(){
        return value;
    }
}
