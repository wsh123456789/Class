package com.wsh.springboot.warehouseownership.model;

import lombok.Data;

import java.util.List;

@Data
public class WareHouseCodeAndStorageSectionName {
    private String storageSectionName;
    private List<String> warehouseCodeList;
    private Integer legalPersonId;
}
