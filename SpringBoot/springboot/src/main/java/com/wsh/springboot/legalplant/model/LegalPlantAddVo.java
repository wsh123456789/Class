package com.wsh.springboot.legalplant.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LegalPlantAddVo {

    // 法人编码
    @NotBlank(message = ParamUtil.LEGAL_PERSON + ParamUtil.CODE_NOTNULL)
    private String legalPersonCode;
    // 工厂编码
    @NotBlank(message = ParamUtil.LEGAL_PLANT + ParamUtil.CODE_NOTNULL)
    private String legalPlantCode;
    // 工厂描述
    @NotBlank(message = ParamUtil.LEGAL_PLANT + ParamUtil.REMARK_NOTNULL)
    private String legalPlantDec;
    // 工厂状态
    @NotNull(message = ParamUtil.LEGAL_PLANT + ParamUtil.STATUS_NOTNULL)
    private Boolean enabled;

}
