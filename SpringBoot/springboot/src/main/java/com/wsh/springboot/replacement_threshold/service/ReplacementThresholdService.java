package com.wsh.springboot.replacement_threshold.service;

import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdAddVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdSelectVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdUpdateVo;
import com.wsh.springboot.util.ResultVo;

public interface ReplacementThresholdService {

    ResultVo queryPage(ReplacementThresholdSelectVo replacementThresholdSelectVo);

    ResultVo add(ReplacementThresholdAddVo replacementThresholdAddVo);


    ResultVo update(ReplacementThresholdUpdateVo replacementThresholdUpdateVo);
}
