package com.wsh.springboot.enumpackage;

import com.wsh.springboot.util.ParamUtil;

public enum TypeEnum {

    PROCUREMENT(ParamUtil.ZERO,ParamUtil.PROCUREMENT),DISPOSE(ParamUtil.ONE,ParamUtil.DISPOSE),SCRAP(ParamUtil.TWO,ParamUtil.SCRAP);

    private Integer value;
    private String name;

    TypeEnum(Integer value, String name){
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
