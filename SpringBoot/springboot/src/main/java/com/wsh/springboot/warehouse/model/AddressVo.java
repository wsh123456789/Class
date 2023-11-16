package com.wsh.springboot.warehouse.model;

import lombok.Data;

@Data
public class AddressVo {
    // 地区名
    private String label;
    // 地区id
    private Integer value;
}
