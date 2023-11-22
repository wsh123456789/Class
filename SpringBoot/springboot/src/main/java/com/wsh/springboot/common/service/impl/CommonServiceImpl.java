package com.wsh.springboot.common.service.impl;

import com.wsh.springboot.common.mapper.CommonMapper;
import com.wsh.springboot.common.model.*;
import com.wsh.springboot.common.service.CommonService;
import com.wsh.springboot.enumpackage.*;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private CommonMapper commonMapper;


    @Override
    public ResultVo queryLegalPersonListById(Integer id) {
        List<LegalPersonVo> legalPersonVos = commonMapper.queryLegalPersonListById(id);
        return ResultBuildVo.success(legalPersonVos);
    }

    @Override
    public ResultVo getPullDownList(List<String> keyList) {
        Map<String,List<StatusVo>> listMap = new HashMap<>();
        // 状态列表
        List<StatusVo> statusVoList = new ArrayList<>();
        for (StatusEnum statusEnum : StatusEnum.values()){
            StatusVo statusVo = new StatusVo(statusEnum.getValue(), statusEnum.getStatusName());
            statusVoList.add(statusVo);
        }
        listMap.put("status",statusVoList);
        // 询价币别列表
        List<StatusVo> currencyVoList = new ArrayList<>();
        for (CurrencyEnum currencyEnum: CurrencyEnum.values()){
            StatusVo statusVo = new StatusVo(currencyEnum.getValue(),currencyEnum.getName());
            currencyVoList.add(statusVo);
        }
        listMap.put("currencyCode",currencyVoList);
        // 询价类型列表
        List<StatusVo> typeVoList = new ArrayList<>();
        for (TypeEnum typeEnum: TypeEnum.values()){
            StatusVo statusVo = new StatusVo(typeEnum.getValue(),typeEnum.getName());
            typeVoList.add(statusVo);
        }
        listMap.put("type",typeVoList);
        // 是否税收列表
        List<StatusVo> isTaxVoList = new ArrayList<>();
        for (TaxEnum taxEnum: TaxEnum.values()){
            StatusVo statusVo = new StatusVo(taxEnum.getValue(),taxEnum.getName());
            isTaxVoList.add(statusVo);
        }
        listMap.put("isTax",isTaxVoList);
        // 询价状态列表
        List<StatusVo> inquiryStatusList = new ArrayList<>();
        for (InquiryStatusEnum inquiryStatusEnum: InquiryStatusEnum.values()){
            StatusVo statusVo = new StatusVo(inquiryStatusEnum.getValue(),inquiryStatusEnum.getName());
            inquiryStatusList.add(statusVo);
        }
        listMap.put("inquiryStatus",inquiryStatusList);

        Map<String,List<StatusVo>> listMapNew = new HashMap<>();
        for (String key:keyList) {
            List<StatusVo> statusVoList1 = listMap.get(key);
            listMapNew.put(key,statusVoList1);
        }


        return ResultBuildVo.success(listMapNew);
    }

    @Override
    public ResultVo getReplacementListByCode(String legalPersonCode) {
        List<ReplacementVo> replacementVoList = commonMapper.getReplacementListByCode(legalPersonCode);
        return ResultBuildVo.success(replacementVoList);
    }

    @Override
    public ResultVo getSubclassListByCode(String replacementCode) {
        List<SubclassVo> subclassVoList = commonMapper.getSubclassListByCode(replacementCode);
        return ResultBuildVo.success(subclassVoList);
    }

    // 获取库房编码下拉框
    @Override
    public ResultVo queryWareHouse() {
        List<WareHouseVo> wareHouseVos = commonMapper.queryWareHouse();
        return ResultBuildVo.success(wareHouseVos);
    }

    // 获取库区编码下拉框
    @Override
    public ResultVo queryStorageSection(String code) {
        List<WareHouseAreaVo> wareHouseAreaVos = commonMapper.queryStorageSection(code);
        return ResultBuildVo.success(wareHouseAreaVos);
    }
}
