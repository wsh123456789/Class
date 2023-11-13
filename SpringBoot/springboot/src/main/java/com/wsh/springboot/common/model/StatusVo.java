package com.wsh.springboot.common.model;

import lombok.Data;

@Data
public class StatusVo {

    private Integer value;
    private String label;

    public StatusVo() {
    }

    public StatusVo(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
}
