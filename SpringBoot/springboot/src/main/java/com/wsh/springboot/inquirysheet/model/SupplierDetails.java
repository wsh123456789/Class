package com.wsh.springboot.inquirysheet.model;

import lombok.Data;

@Data
public class SupplierDetails {
    // 供应商id
    private Integer vendorId;
    // 供应商编码
    private String vendorCode;
    // 供应商名称
    private String vendor;
}
