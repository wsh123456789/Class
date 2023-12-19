package com.wsh.basics.legalplant.model;

import com.wsh.basics.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LegalPlantUpdateVo {
    @NotNull(message = ParamUtil.LEGAL_PLANT + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotBlank(message = ParamUtil.LEGAL_PLANT + ParamUtil.REMARK_NOTNULL)
    private String legalPlantDec;
    @NotNull(message = ParamUtil.LEGAL_PLANT + ParamUtil.STATUS_NOTNULL)
    private Boolean enabled;
    @NotNull(message = ParamUtil.VERSION_NOTNULL)
    private Integer version;
}
