package com.wsh.springboot.subclass.model;

import lombok.Data;

import java.util.Date;

@Data
public class SubClassVo {
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
    private int version;
}
