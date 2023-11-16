package com.wsh.springboot.warehouseownership.model;

import com.wsh.springboot.util.PageVo;
import lombok.Data;


@Data
public class QueryWarehouseSelectVo extends PageVo {

    private String name;
    private String code;

}
