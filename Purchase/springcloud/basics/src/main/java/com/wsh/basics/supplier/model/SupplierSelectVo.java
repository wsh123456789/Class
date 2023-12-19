package com.wsh.basics.supplier.model;

import com.wsh.basics.util.PageVo;
import lombok.Data;

@Data
public class SupplierSelectVo extends PageVo {
    // id
    private Integer id;
    // 供应商编码
    private String partnerCode;
    // 供应商名称
    private String partnerName;
}
