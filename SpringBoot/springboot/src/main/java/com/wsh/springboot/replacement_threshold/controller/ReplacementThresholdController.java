package com.wsh.springboot.replacement_threshold.controller;

import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdAddVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdSelectVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdUpdateVo;
import com.wsh.springboot.replacement_threshold.service.ReplacementThresholdService;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("replacementThreshold")
@CrossOrigin
public class ReplacementThresholdController {
    @Autowired
    private ReplacementThresholdService replacementThresholdService;

    @PostMapping("query")
    @ResponseBody
    public ResultVo queryPage(@RequestBody ReplacementThresholdSelectVo replacementThresholdSelectVo,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return replacementThresholdService.queryPage(replacementThresholdSelectVo);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid ReplacementThresholdAddVo replacementThresholdAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return replacementThresholdService.add(replacementThresholdAddVo);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid ReplacementThresholdUpdateVo replacementThresholdUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return replacementThresholdService.update(replacementThresholdUpdateVo);
    }


}
