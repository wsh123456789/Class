package com.wsh.springboot.warehouse_area.model;

import lombok.Data;

@Data
public class BusinessAttributeVo {
    // 业务属性id
    private Integer id;
    // 业务属性编码
    private String code;
    // 业务属性名称
    private String name;
}
