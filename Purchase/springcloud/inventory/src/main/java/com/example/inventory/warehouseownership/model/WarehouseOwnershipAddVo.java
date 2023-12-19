package com.example.inventory.warehouseownership.model;

import com.example.inventory.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class WarehouseOwnershipAddVo {
    @NotNull(message = ParamUtil.LEGAL_PERSON + ParamUtil.ID_NOTNULL)
    private Integer legalPersonId;
    private List<String> codeList;
}
