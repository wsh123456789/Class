package com.wsh.springboot.legalplant.service;

import com.wsh.springboot.legalplant.model.LegalPlantAddVo;
import com.wsh.springboot.legalplant.model.LegalPlantSelectVo;
import com.wsh.springboot.legalplant.model.LegalPlantUpdateStatusVo;
import com.wsh.springboot.legalplant.model.LegalPlantUpdateVo;
import com.wsh.springboot.util.ResultVo;
import org.apache.ibatis.annotations.Insert;

public interface LegalPlantService {
    ResultVo queryPage(LegalPlantSelectVo legalPlantSelectVo);

    @Insert("insert into suppliers ")
    ResultVo add(LegalPlantAddVo legalPlantAddVo);

    ResultVo update(LegalPlantUpdateVo legalPlantUpdateVo);

    ResultVo updateStatus(LegalPlantUpdateStatusVo legalPlantUpdateStatusVo);
}
