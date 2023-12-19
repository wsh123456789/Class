package com.example.inventory.warehouse.model;

import lombok.Data;

import java.util.Date;
@Data
public class WarehouseVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private String statusName;
    private Boolean status;
    private String wareHouseTagRemark;
    private String wareHouseTagCode;
    private Integer area;
    private Integer nation;
    private Integer province;
    private Integer city;
    private Integer county;
    private String areaName;
    private String nationName;
    private String provinceName;
    private String cityName;
    private String countyName;
    private String detailAddress;
    private String createName;
    private Date createTime;
    private String changeName;
    private Date changeTime;
    private int version;
}
