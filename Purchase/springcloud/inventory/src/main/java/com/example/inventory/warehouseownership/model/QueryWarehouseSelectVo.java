package com.example.inventory.warehouseownership.model;

import com.example.inventory.util.PageVo;
import lombok.Data;


@Data
public class QueryWarehouseSelectVo extends PageVo {

    private String name;
    private String code;

}
