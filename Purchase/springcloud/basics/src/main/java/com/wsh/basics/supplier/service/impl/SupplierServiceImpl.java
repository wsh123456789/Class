package com.wsh.basics.supplier.service.impl;

import com.wsh.basics.supplier.mapper.SupplierMapper;
import com.wsh.basics.supplier.model.SupplierSelectVo;
import com.wsh.basics.supplier.model.SupplierVo;
import com.wsh.basics.supplier.service.SupplierService;
import com.wsh.basics.util.AllRecordsVo;
import com.wsh.basics.util.ResultBuildVo;
import com.wsh.basics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    // 查询供应商
    @Override
    public ResultVo searchPartnerPage(SupplierSelectVo supplierSelectVo) {
        List<SupplierVo> supplierVos = supplierMapper.searchPartnerPage(supplierSelectVo);

        int count = supplierMapper.queryCount(supplierSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(supplierSelectVo.getPageIndex());
        allRecordsVo.setPageSize(supplierSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(supplierVos);
        return ResultBuildVo.success(allRecordsVo);
    }

    // 供应商下拉框
    @Override
    public ResultVo queryByLegalPerson(Integer legalPersonId) {
        List<SupplierVo> supplierVoList = supplierMapper.queryByLegalPerson(legalPersonId);
        return ResultBuildVo.success(supplierVoList);
    }
}
