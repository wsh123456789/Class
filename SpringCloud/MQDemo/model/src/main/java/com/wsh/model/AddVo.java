package com.wsh.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class AddVo implements Serializable {
    // 订单号
    @NotBlank(message = ParamUtil.ORDER_CODE + ParamUtil.NOTNULL)
    private String orderCode;
    // 采购方名称
    @NotBlank(message = ParamUtil.PURCHASER + ParamUtil.NOTNULL)
    private String purchaser;
    // 收货地址
    @NotBlank(message = ParamUtil.ADDRESS + ParamUtil.NOTNULL)
    private String address;
    // 备件信息
    @Valid
    @NotEmpty(message = ParamUtil.SPARE_LIST + ParamUtil.NOTNULL)
    private List<SpareVo> spareList;
    // 订单状态
    @NotNull(message = ParamUtil.ORDER_STATUS + ParamUtil.NOTNULL)
    private Integer status;
    private Date createTime;
}
