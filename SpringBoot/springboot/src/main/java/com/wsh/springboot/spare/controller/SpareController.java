package com.wsh.springboot.spare.controller;

import com.wsh.springboot.spare.service.SpareService;
import com.wsh.springboot.spare.model.SpareAddVo;
import com.wsh.springboot.spare.model.SpareSelectVo;
import com.wsh.springboot.spare.model.SpareUpdateStatusVo;
import com.wsh.springboot.spare.model.SpareUpdateVo;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("planCategory")
@CrossOrigin
public class SpareController {

    @Autowired
    private SpareService spareService;

    @PostMapping("queryPage")
    public ResultVo queryPage(@RequestBody SpareSelectVo spareSelectVo){
        return spareService.queryPage(spareSelectVo);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid SpareAddVo spareAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return spareService.add(spareAddVo);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid SpareUpdateVo spareUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return spareService.update(spareUpdateVo);
    }

    @PostMapping("updateStatus")
    public ResultVo updateStatus(@RequestBody @Valid SpareUpdateStatusVo spareUpdateStatusVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return spareService.updateStatus(spareUpdateStatusVo);
    }

//    @PostMapping("/queryPageVo")
//    @ResponseBody
//    public PageVo queryPageVo(@RequestBody SpareVo spareVo,Integer currentPage){
//        return spareService.queryPageVo(spareVo,currentPage);
//    }
//
//    @PostMapping("/add")
//    @ResponseBody
//    public ResultVo add(@RequestBody @Valid SpareAddVo SpareAddVo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return spareService.add(SpareAddVo);
//    }
//
//    @GetMapping("/showUpdate")
//    @ResponseBody
//    public ResultVo showUpdate(Integer id) {
//        return spareService.showUpdate(id);
//    }
//
//    @PostMapping("/update")
//    @ResponseBody
//    public ResultVo update(@RequestBody @Valid SpareUpdateVo spareUpdateVo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return spareService.update(spareUpdateVo);
//    }
//
//    @PostMapping("/updateStatus")
//    @ResponseBody
//    public ResultVo updateStatus(@RequestBody SpareStatusVo spareStatusVo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return spareService.updateStatusById(spareStatusVo);
//    }
}
