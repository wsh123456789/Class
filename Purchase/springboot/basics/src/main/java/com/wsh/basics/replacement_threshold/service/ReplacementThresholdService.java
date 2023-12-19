package com.wsh.basics.replacement_threshold.service;


import com.wsh.basics.replacement_threshold.model.ReplacementThresholdAddVo;
import com.wsh.basics.replacement_threshold.model.ReplacementThresholdSelectVo;
import com.wsh.basics.replacement_threshold.model.ReplacementThresholdUpdateVo;
import com.wsh.basics.util.ResultVo;

public interface ReplacementThresholdService {

    ResultVo queryPage(ReplacementThresholdSelectVo replacementThresholdSelectVo);

    ResultVo add(ReplacementThresholdAddVo replacementThresholdAddVo);


    ResultVo update(ReplacementThresholdUpdateVo replacementThresholdUpdateVo);
}
