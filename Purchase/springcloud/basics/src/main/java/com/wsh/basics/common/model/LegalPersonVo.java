package com.wsh.basics.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LegalPersonVo {

    @ApiModelProperty(value = "法人id")
    private Integer legalPersonId;
    @ApiModelProperty(value = "法人名称")
    private String legalPersonName;
    @ApiModelProperty(value = "法人编码")
    private String legalPersonCode;

}
