package com.wsh.supplier.service;

import com.wsh.model.AddVo;

import java.util.Map;

public interface SupplierService {
    Map<String,Integer> hasInventory(AddVo addVo);

    void add(AddVo addVo);
}
