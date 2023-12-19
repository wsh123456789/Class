package com.wsh.basics.subclass.model;

import com.wsh.basics.util.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubClassSelectVo extends PageVo {
    @ApiModelProperty(notes = "名称")
    private String name;
    @ApiModelProperty(notes = "编码")
    private String code;
    @ApiModelProperty(notes = "状态")
    private Boolean status;


}
