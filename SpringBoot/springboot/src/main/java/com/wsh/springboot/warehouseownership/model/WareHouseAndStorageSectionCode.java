package com.wsh.springboot.warehouseownership.model;

import lombok.Data;

import java.util.List;

@Data
public class WareHouseAndStorageSectionCode {
    private List<String> warehouseCodeList;
    private List<String> storageSectionCodeList;
    private Integer legalPersonId;
}
