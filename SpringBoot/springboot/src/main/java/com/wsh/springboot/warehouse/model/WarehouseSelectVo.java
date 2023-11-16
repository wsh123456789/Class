package com.wsh.springboot.warehouse.model;

import com.wsh.springboot.util.PageVo;
import lombok.Data;


@Data
public class WarehouseSelectVo extends PageVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private Boolean status;

}
