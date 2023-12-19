package com.example.inventory.warehouse.model;

import com.example.inventory.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WarehouseUpdateVo {

    @NotNull(message = ParamUtil.WAREHOUSE + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotBlank(message = ParamUtil.WAREHOUSE + ParamUtil.NAME_NOTNULL)
    private String name;
    @NotNull(message = ParamUtil.WAREHOUSE + ParamUtil.STATUS_NOTNULL)
    private Boolean status;
    private String remark;
    private int version;
    private String wareHouseTagCode;
    private Integer area;
    private Integer nation;
    private Integer province;
    private Integer city;
    private Integer county;
    private String detailAddress;
}
