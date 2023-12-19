package com.example.inventory.warehouseownership.model;

import lombok.Data;

@Data
public class StorageBinVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private String statusName;
    private Boolean status;
    private Integer legalPersonId;
}
