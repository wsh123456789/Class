package com.wsh.springboot.common.service.impl;

import com.wsh.springboot.common.mapper.CommonMapper;
import com.wsh.springboot.common.model.LegalPersonVo;
import com.wsh.springboot.common.model.ReplacementVo;
import com.wsh.springboot.common.model.StatusVo;
import com.wsh.springboot.common.model.SubclassVo;
import com.wsh.springboot.common.service.CommonService;
import com.wsh.springboot.enumpackage.CurrencyEnum;
import com.wsh.springboot.enumpackage.StatusEnum;
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
        List<StatusVo> statusVoList = new ArrayList<>();
        for (StatusEnum statusEnum : StatusEnum.values()){
            StatusVo statusVo = new StatusVo(statusEnum.getValue(), statusEnum.getStatusName());
            statusVoList.add(statusVo);
        }
        listMap.put("status",statusVoList);
        List<StatusVo> statusVoList2 = new ArrayList<>();
        for (CurrencyEnum currencyEnum: CurrencyEnum.values()){
            StatusVo statusVo = new StatusVo(currencyEnum.getValue(),currencyEnum.getName());
            statusVoList2.add(statusVo);
        }
        listMap.put("currency",statusVoList2);
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
}
