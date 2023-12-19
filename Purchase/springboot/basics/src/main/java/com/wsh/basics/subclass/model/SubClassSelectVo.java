package com.wsh.basics.subclass.model;

import com.wsh.basics.util.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubClassSelectVo extends PageVo {
    @ApiModelProperty(value = "备件名称")
    private String name;
    @ApiModelProperty(value = "备件编码")
    private String code;
    @ApiModelProperty(value = "备件状态")
    private Boolean status;


}
