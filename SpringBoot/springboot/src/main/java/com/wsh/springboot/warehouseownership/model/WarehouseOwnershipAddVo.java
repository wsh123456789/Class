package com.wsh.springboot.warehouseownership.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class WarehouseOwnershipAddVo {
    @NotNull(message = ParamUtil.LEGAL_PERSON + ParamUtil.ID_NOTNULL)
    private Integer legalPersonId;
    private List<String> codeList;
}
