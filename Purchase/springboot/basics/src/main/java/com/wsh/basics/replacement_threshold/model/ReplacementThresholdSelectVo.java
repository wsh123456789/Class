package com.wsh.basics.replacement_threshold.model;

import com.wsh.basics.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class ReplacementThresholdSelectVo extends PageVo {

    // 用户id
    private Integer userId;
    // 法人编码
    private String legalPersonCode;
    // 备件编码
    private String replacementCode;
    // 备件编码
    private String replacementName;
    // 备类小件
    private String subclassName;
    // 备件数量阀值起始范围
    private Integer thresholdBegin;
    // 备件数量阀值结束范围
    private Integer thresholdEnd;
    // 修改人
    private String changeName;
    // 修改时间起始范围
    private Date changeTimeBegin;
    // 修改时间结束范围
    private Date changeTimeEnd;

}
