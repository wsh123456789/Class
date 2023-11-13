package com.wsh.springboot.subclass.controller;

import com.wsh.springboot.subclass.model.*;
import com.wsh.springboot.subclass.service.SubClassService;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("subClass")
@CrossOrigin// 跨域
public class SubClassController {

    @Autowired
    private SubClassService subClassService;

    @PostMapping("queryPage")
    public ResultVo queryPage(@RequestBody SubClassSelectVo subClassSelectVo){
        return subClassService.queryPage(subClassSelectVo);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid SubClassAddVo subClassAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return subClassService.add(subClassAddVo);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid SubClassUpdateVo subClassUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return subClassService.update(subClassUpdateVo);
    }

    @PostMapping("updateStatus")
    public ResultVo updateStatus(@RequestBody @Valid SubClassUpdateStatusVo subClassUpdateStatusVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return subClassService.updateStatus(subClassUpdateStatusVo);
    }

//    @PostMapping("add")
//    public ResultVo add(@RequestBody @Valid SpareAddVo subClassAddVo, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return subClassService.add(subClassAddVo);
//    }
//    @PostMapping("update")
//    public ResultVo update(@RequestBody @Valid SpareUpdateVo subClassUpdateVo, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return subClassService.update(subClassUpdateVo);
//    }
//    @PostMapping("updateStatus")
//    public ResultVo updateStatus(@RequestBody @Valid SpareUpdateStatusVo subClassUpdateStatusVo, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return subClassService.updateStatus(subClassUpdateStatusVo);
//    }
//

}
