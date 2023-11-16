package com.wsh.springboot.warehouse_position.model;

import com.wsh.springboot.util.ParamUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class WarehousePositionAddVo {
    // 库位编码
    @NotBlank(message = ParamUtil.WAREHOUSE_POSITION + ParamUtil.CODE_NOTNULL)
    private String code;
    // 库位名称
    @NotBlank(message = ParamUtil.WAREHOUSE_POSITION + ParamUtil.NAME_NOTNULL)
    private String name;
    // 法人id
    private Integer legalPersonId;
    // 库区编码
    @NotBlank(message = ParamUtil.WAREHOUSE_AREA + ParamUtil.CODE_NOTNULL)
    private String storageSectionCode;
    // 新增的数据列表
    List<WarehousePositionAddVo> list;
}
