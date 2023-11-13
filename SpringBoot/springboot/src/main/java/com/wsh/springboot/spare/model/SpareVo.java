package com.wsh.springboot.spare.model;

import lombok.Data;

import java.util.Date;

@Data
public class SpareVo {
    private Integer id;
    private String name;
    private String code;
    private String statusName;
    private Boolean status;
    private String remark;
    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;
    private Integer version;
}
