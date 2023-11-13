package com.wsh.springboot.enumpackage;

import com.wsh.springboot.util.ParamUtil;

public enum CurrencyEnum {
    QIYONG(ParamUtil.ONE,"人民币"),JINYONG(ParamUtil.ZERO,"美元"),QUANBU(3,"英镑");

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
