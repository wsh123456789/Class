package com.wsh.basics.legalplant.service;

import com.wsh.basics.legalplant.model.LegalPlantAddVo;
import com.wsh.basics.legalplant.model.LegalPlantSelectVo;
import com.wsh.basics.legalplant.model.LegalPlantUpdateStatusVo;
import com.wsh.basics.legalplant.model.LegalPlantUpdateVo;
import com.wsh.basics.util.ResultVo;
import org.apache.ibatis.annotations.Insert;

public interface LegalPlantService {
    ResultVo queryPage(LegalPlantSelectVo legalPlantSelectVo);

    @Insert("insert into suppliers ")
    ResultVo add(LegalPlantAddVo legalPlantAddVo);

    ResultVo update(LegalPlantUpdateVo legalPlantUpdateVo);

    ResultVo updateStatus(LegalPlantUpdateStatusVo legalPlantUpdateStatusVo);
}
