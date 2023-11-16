package com.wsh.springboot.warehouseownership.model;

import com.wsh.springboot.util.PageVo;
import lombok.Data;


@Data
public class WarehouseOwnershipSelectVo extends PageVo {
    private Integer legalPersonId;
    private String name;
    private String code;
    private String remark;
    private Boolean status;

}
