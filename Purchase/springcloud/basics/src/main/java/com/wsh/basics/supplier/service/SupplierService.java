package com.wsh.basics.supplier.service;


import com.wsh.basics.supplier.model.SupplierSelectVo;
import com.wsh.basics.util.ResultVo;

public interface SupplierService {
    // 查供应商
    ResultVo searchPartnerPage(SupplierSelectVo supplierSelectVo);

    ResultVo queryByLegalPerson(Integer legalPersonId);
}
