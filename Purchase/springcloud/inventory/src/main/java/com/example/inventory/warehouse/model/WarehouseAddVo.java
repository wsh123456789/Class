package com.example.inventory.warehouse.model;

import com.example.inventory.util.ParamUtil;
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
    @NotBlank(message = ParamUtil.WAREHOUSE_TAG + ParamUtil.CODE_NOTNULL)
    private String wareHouseTagCode;
    @NotBlank(message = ParamUtil.AREA + ParamUtil.NOTNULL)
    private Integer area;
    @NotBlank(message = ParamUtil.NATION + ParamUtil.NOTNULL)
    private Integer nation;
    @NotBlank(message = ParamUtil.PROVINCE + ParamUtil.NOTNULL)
    private Integer province;
    @NotBlank(message = ParamUtil.CITY + ParamUtil.NOTNULL)
    private Integer city;
    @NotBlank(message = ParamUtil.COUNTY + ParamUtil.NOTNULL)
    private Integer county;
    @NotBlank(message = ParamUtil.ADDRESS + ParamUtil.NOTNULL)
    private String detailAddress;

}
