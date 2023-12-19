package com.example.inventory.storagesection.model;

import com.example.inventory.util.PageVo;
import lombok.Data;


@Data
public class StorageSectionSelectVo extends PageVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private Boolean status;

}
