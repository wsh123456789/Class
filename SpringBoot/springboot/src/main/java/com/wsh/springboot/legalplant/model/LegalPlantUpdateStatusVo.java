package com.wsh.springboot.legalplant.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LegalPlantUpdateStatusVo {
    @NotNull(message = ParamUtil.LEGAL_PLANT + ParamUtil.ID_NOTNULL)
    private Integer id;
    @NotNull(message = ParamUtil.LEGAL_PLANT + ParamUtil.STATUS_NOTNULL)
    private Boolean enabled;
    @NotNull(message = ParamUtil.VERSION_NOTNULL)
    private Integer version;

}
