package com.wsh.springboot.subclass.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SubClassVo implements Serializable {
    @ApiModelProperty(value = "备件id")
    private Integer id;
    @ApiModelProperty(value = "备件姓名")
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
