package com.wsh.springboot.supplier.model;

import lombok.Data;

@Data
public class SupplierVo {
    // 询价表id
    private Integer id;
    // 供应商编码
    private String partnerCode;
    // 供应商名称
    private String partnerName;

}
