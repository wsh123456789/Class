package com.wsh.basics.forinquirysheet.service.impl;

import com.wsh.basics.forinquirysheet.mapper.ForInquirySheetMapper;
import com.wsh.basics.forinquirysheet.model.CreateInquirySheetAddVo;
import com.wsh.basics.forinquirysheet.model.CreateInquirySheetSelectVo;
import com.wsh.basics.forinquirysheet.model.CreateInquirySheetVo;
import com.wsh.basics.forinquirysheet.service.ForInquirySheetService;
import com.wsh.basics.util.ResultBuildVo;
import com.wsh.basics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForInquirySheetServiceImpl implements ForInquirySheetService {

    @Autowired
    private ForInquirySheetMapper forInquirySheetMapper;
    @Override
    public ResultVo queryLegalCode(CreateInquirySheetAddVo createInquirySheetAddVo) {
        Integer count = forInquirySheetMapper.queryLegalCode(createInquirySheetAddVo);
        return ResultBuildVo.success(count);
    }

    @Override
    public ResultVo queryCodeList(List<String> codeList) {
        List<String> list = forInquirySheetMapper.queryCodeList(codeList);
        return ResultBuildVo.success(list);
    }

    @Override
    public ResultVo querySupplierCodeList(List<String> supplierList) {
        List<String> list = forInquirySheetMapper.querySupplierCodeList(supplierList);
        return ResultBuildVo.success(list);
    }

    @Override
    public ResultVo querySpareForSupplier(List<String> codeList) {
        List<String> list = forInquirySheetMapper.querySpareForSupplier(codeList);
        return ResultBuildVo.success(list);
    }

    @Override
    public ResultVo querySupplierForSpare(List<String> supplierList) {
        List<String> list = forInquirySheetMapper.querySupplierForSpare(supplierList);
        return ResultBuildVo.success(list);
    }

    @Override
    public ResultVo selectMaterial(CreateInquirySheetSelectVo createInquirySheetSelectVo) {
        List<CreateInquirySheetVo> createInquirySheetVos = forInquirySheetMapper.selectMaterial(createInquirySheetSelectVo);
        return ResultBuildVo.success(createInquirySheetVos);
    }

    @Override
    public ResultVo queryReplacementCount(CreateInquirySheetSelectVo createInquirySheetSelectVo) {
        int i = forInquirySheetMapper.queryReplacementCount(createInquirySheetSelectVo);
        return ResultBuildVo.success(i);
    }
}
