package com.wsh.basics.legalplant.controller;

import com.wsh.basics.legalplant.model.LegalPlantAddVo;
import com.wsh.basics.legalplant.model.LegalPlantSelectVo;
import com.wsh.basics.legalplant.model.LegalPlantUpdateStatusVo;
import com.wsh.basics.legalplant.model.LegalPlantUpdateVo;
import com.wsh.basics.legalplant.service.LegalPlantService;
import com.wsh.basics.util.ResultBuildVo;
import com.wsh.basics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("legalPlant")
@CrossOrigin
public class LegalPlantController {

    @Autowired
    private LegalPlantService legalPlantService;

    @PostMapping("query")
    @ResponseBody
    public ResultVo queryPage(@RequestBody LegalPlantSelectVo legalPlantSelectVo){
        return legalPlantService.queryPage(legalPlantSelectVo);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid LegalPlantAddVo legalPlantAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return legalPlantService.add(legalPlantAddVo);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid LegalPlantUpdateVo legalPlantUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return legalPlantService.update(legalPlantUpdateVo);
    }

    @PostMapping("updateStatus")
    public ResultVo updateStatus(@RequestBody @Valid LegalPlantUpdateStatusVo legalPlantUpdateStatusVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return legalPlantService.updateStatus(legalPlantUpdateStatusVo);
    }

}
