package com.wsh.basics.common.model;

import lombok.Data;

@Data
public class PullDownVo {

    private Integer value;
    private String name;

    public PullDownVo() {
    }

    public PullDownVo(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
