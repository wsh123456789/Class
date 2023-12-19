package com.wsh.basics.common.service;


import com.wsh.basics.util.ResultVo;

import java.util.List;

public interface CommonService {


    ResultVo queryLegalPersonListById(Integer id);

    ResultVo getPullDownList(List<String> keyList);

    ResultVo getReplacementListByCode(String legalPersonCode);

    ResultVo getSubclassListByCode(String replacementCode);

    ResultVo queryWareHouse();

    ResultVo queryStorageSection(String code);
}
