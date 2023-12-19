package com.example.inventory.warehouseownership.model;

import com.example.inventory.util.PageVo;
import lombok.Data;


@Data
public class WarehouseOwnershipSelectVo extends PageVo {
    private Integer legalPersonId;
    private String name;
    private String code;
    private String remark;
    private Boolean status;

}
