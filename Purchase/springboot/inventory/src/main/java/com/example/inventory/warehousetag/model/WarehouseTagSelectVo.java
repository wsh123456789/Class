package com.example.inventory.warehousetag.model;

import com.example.inventory.util.PageVo;
import lombok.Data;


@Data
public class WarehouseTagSelectVo extends PageVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private Boolean status;

}
