package com.wsh.basics.replacement_threshold.model;

import lombok.Data;

import java.util.Date;

@Data
public class ReplacementThresholdVo {

    // 备件id
    private Integer thresholdId;
    // 备件编码
    private String replacementCode;
    // 备件名称
    private String replacementName;
    // 计量单位
    private String unit;
    // 备件小类
    private String subclassName;
    // 备件数量阈值
    private Integer threshold;
    // 是否启用
    private Boolean status;
    // 是否可借用
    private Boolean borrow;
    // 是否可注销
    private Boolean sale;
    // 是否启用
    private String isStatus;
    // 是否可借用
    private String isBorrow;
    // 是否可注销
    private String isSale;
    // 备注
    private String remark;

    // 法人名称
    private String legalPersonName;
    // 法人编码
    private String legalPersonCode;
    // 创建人员
    private String createName;
    // 创建时间
    private Date createTime;
    // 最后修改人
    private String changeName;
    // 最后修改时间
    private Date changeTime;
    // 版本号
    private Integer version;
}
