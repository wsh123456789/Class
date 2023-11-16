package com.wsh.springboot.warehousetag.model;

import lombok.Data;

import java.util.Date;
@Data
public class WarehouseTagVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private String statusName;
    private Boolean status;
    private String createName;
    private Date createTime;
    private String changeName;
    private Date changeTime;
    private int version;
}
