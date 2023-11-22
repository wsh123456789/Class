package com.wsh.springboot.supplier.service;

import com.wsh.springboot.supplier.model.SupplierSelectVo;
import com.wsh.springboot.util.ResultVo;

public interface SupplierService {
    // 查供应商
    ResultVo searchPartnerPage(SupplierSelectVo supplierSelectVo);

    ResultVo queryByLegalPerson(Integer legalPersonId);
}
