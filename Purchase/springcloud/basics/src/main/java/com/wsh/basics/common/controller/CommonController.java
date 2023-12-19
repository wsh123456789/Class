package com.wsh.basics.common.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wsh.basics.common.model.GetNameTimeIdVo;
import com.wsh.basics.common.model.LegalPersonVo;
import com.wsh.basics.common.service.CommonService;
import com.wsh.basics.util.ResultBuildVo;
import com.wsh.basics.util.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
@Api(value = "SubClassController", description = "公共功能")
@DefaultProperties(defaultFallback = "morenJiangJi")
public class CommonController {

    public ResultVo morenJiangJi() throws Exception {
        return ResultBuildVo.error("当前网络开小差了，请刷新后重试！！！");
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CommonService commonService;

    // 状态下拉框
    @ResponseBody
    @PostMapping("metadata/getPullDownList")
    @ApiOperation(value = "状态下拉框")
    public ResultVo getPullDownList(@RequestBody List<String> keyList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return commonService.getPullDownList(keyList);
    }


    // 法人名称下拉框
    @ApiOperation(value = "法人名称下拉框")
    @GetMapping("legalPerson/ofCurrentUser")
//    @HystrixCommand
    public ResultVo<List<LegalPersonVo>> getLegalPersonDropDown() {
        // 从Session中获取用户id
        Integer id = 1;
        String key = "legalPersonPullDownList" + id;
        List<LegalPersonVo> list = (List<LegalPersonVo>) redisTemplate.opsForValue().get(key);
        if (list == null) {
            synchronized (this) {
                List<LegalPersonVo> list2 = (List<LegalPersonVo>) redisTemplate.opsForValue().get(key);
                if (list2 == null) {
                    //操作数据库
                    System.out.println("操作数据库！");
                    ResultVo resultVo = commonService.queryLegalPersonListById(id);
                    redisTemplate.opsForValue().set(key,resultVo.getData());
                    return resultVo;
                }
            }
        }

        System.out.println("操作redis");
        return ResultBuildVo.success(list);
    }

    // 备件下拉框
    @ApiOperation(value = "备件下拉框")
    @GetMapping("replacement/ofLegalPerson")
    public ResultVo getReplacementDropDown(String legalPersonCode) {

        return commonService.getReplacementListByCode(legalPersonCode);
    }

    // 备件小类下拉框
    @ApiOperation(value = "备件小类下拉框")
    @GetMapping("subclass/getPullDownList")
    public ResultVo getSubclassDropDown(String replacementCode) {
        return commonService.getSubclassListByCode(replacementCode);
    }

    // 库房编码下拉框
    @ApiOperation(value = "库房编码下拉框")
    @GetMapping("storageSection/queryWareHouse")
    public ResultVo queryWareHouse() {
        return commonService.queryWareHouse();
    }

    // 库房库区编码下拉框
    @ApiOperation(value = "库房库区编码下拉框")
    @GetMapping("StorageBin/queryStorageSection")
    @ResponseBody
    public ResultVo queryStorageSection(String code) {
        return commonService.queryStorageSection(code);
    }

    // 询价人员回显
    @ApiOperation(value = "询价人员回显")
    @GetMapping("plan/getUser")
    public ResultVo getUser() {
        GetNameTimeIdVo nameTimeIdVo = new GetNameTimeIdVo();
        nameTimeIdVo.setCreateName("张三");
        nameTimeIdVo.setCreateTime(new Date());

        return ResultBuildVo.success(nameTimeIdVo);
    }

}
