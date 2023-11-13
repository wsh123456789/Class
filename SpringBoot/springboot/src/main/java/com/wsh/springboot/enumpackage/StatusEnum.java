package com.wsh.springboot.enumpackage;

import com.wsh.springboot.util.ParamUtil;

public enum StatusEnum {

    OPEN(ParamUtil.ONE, ParamUtil.OPEN),
    CLOSE(ParamUtil.ZERO,ParamUtil.CLOSE);

    private final Integer value;

    private final String statusName;

    StatusEnum(Integer value, String statusName) {
        this.value = value;
        this.statusName = statusName;
    }

    public Integer getValue() {
        return value;
    }

    public String getStatusName() {
        return statusName;
    }
}
