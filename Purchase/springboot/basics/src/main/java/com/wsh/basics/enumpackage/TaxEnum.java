package com.wsh.basics.enumpackage;

import com.wsh.basics.util.ParamUtil;

public enum TaxEnum {
    TAX(ParamUtil.ZERO,ParamUtil.TAX),NULL_TAX(ParamUtil.ONE,ParamUtil.NULL_TAX);

    private Integer value;
    private String name;

    TaxEnum(Integer value, String name){
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
