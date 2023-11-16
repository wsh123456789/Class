package com.wsh.springboot.warehouseownership.model;

import lombok.Data;

import java.util.Date;
@Data
public class WarehouseOwnershipVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private String statusName;
    private Boolean status;
    private String storageSectionName;
    private String storageSectionCode;
    private String storageSectionRemark;
    private String legalPersonName;
    private Integer legalPersonId;
    private String createName;
    private Date createTime;
    private String changeName;
    private Date changeTime;
    private int version;
}
