package com.wsh.springboot.warehouse.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WarehouseAddVo {
    @NotBlank(message = ParamUtil.WAREHOUSE + ParamUtil.NAME_NOTNULL)
    private String name;
    @NotBlank(message = ParamUtil.WAREHOUSE + ParamUtil.CODE_NOTNULL)
    private String code;
    private String remark;
    private Boolean status;
    private String wareHouseTagCode;
    private Integer area;
    private Integer nation;
    private Integer province;
    private Integer city;
    private Integer county;
    private String detailAddress;

}
