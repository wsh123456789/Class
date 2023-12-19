package com.wsh.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class SpareVo implements Serializable {
    @NotBlank(message = ParamUtil.SPARE_CODE + ParamUtil.NOTNULL)
    private String spareCode;
    @NotNull(message = ParamUtil.COUNT + ParamUtil.NOTNULL)
    @Min(value = 1,message = ParamUtil.COUNT + ParamUtil.MIN_COUNT)
    private Integer count;
    private Integer occupyCount;
    private Integer totalCount;
    private Date createTime;
}
