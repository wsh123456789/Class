package com.wsh.basics.supplier.controller;


import com.wsh.basics.supplier.model.SupplierSelectVo;
import com.wsh.basics.supplier.service.SupplierService;
import com.wsh.basics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("partner")
@CrossOrigin
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("searchPartnerPage")
    @ResponseBody
    public ResultVo searchPartnerPage(@RequestBody SupplierSelectVo supplierSelectVo){
        return supplierService.searchPartnerPage(supplierSelectVo);
    }

    @GetMapping("queryByLegalPerson")
    public ResultVo queryByLegalPerson(Integer legalPersonId){
        return supplierService.queryByLegalPerson(legalPersonId);
    }
}
