package com.wsh.basics.legalplant.model;


import lombok.Data;

import java.util.Date;

@Data
public class LegalPlantVo {

    // 工厂id
    private Integer id;
    // 工厂编码
    private String legalPlantCode;
    // 工厂描述
    private String legalPlantDec;
    // 法人编码
    private String legalPersonCode;
    // 法人名称
    private String legalPersonName;
    // 工厂状态
    private Boolean enabled;
    // 创建时间
    private Date createTime;
    // 创建人
    private String createName;
    // 修改时间
    private Date updateTime;
    // 修改人
    private String updateName;
    // 版本号
    private Integer version;

}
