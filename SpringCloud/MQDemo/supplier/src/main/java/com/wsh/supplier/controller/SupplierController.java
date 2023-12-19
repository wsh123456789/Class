package com.wsh.supplier.controller;

import com.wsh.model.AddVo;
import com.wsh.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("hasInventory")
    @ResponseBody
    public Map<String,Integer> hasInventory(@RequestBody AddVo addVo){
        return supplierService.hasInventory(addVo);
    }
}
