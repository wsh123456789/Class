package com.wsh.springboot.replacement_threshold.service.impl;

import com.wsh.springboot.replacement_threshold.mapper.ReplacementThresholdMapper;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdAddVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdSelectVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdUpdateVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdVo;
import com.wsh.springboot.replacement_threshold.service.ReplacementThresholdService;
import com.wsh.springboot.util.AllRecordsVo;
import com.wsh.springboot.util.ParamUtil;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReplacementThresholdServiceImpl implements ReplacementThresholdService {
    @Autowired
    private ReplacementThresholdMapper replacementThresholdMapper;

    @Override
    public ResultVo queryPage(ReplacementThresholdSelectVo replacementThresholdSelectVo) {
        //查询数据
        List<ReplacementThresholdVo> replacementThresholdVoList = replacementThresholdMapper.queryData(replacementThresholdSelectVo);
        for (ReplacementThresholdVo replacementThresholdVo: replacementThresholdVoList){
            if (replacementThresholdVo.getStatus()){
                replacementThresholdVo.setIsStatus(ParamUtil.TRUE);
            }else{
                replacementThresholdVo.setIsStatus(ParamUtil.FALSE);
            }

            if (replacementThresholdVo.getBorrow()){
                replacementThresholdVo.setIsBorrow(ParamUtil.TRUE);
            }else {
                replacementThresholdVo.setIsBorrow(ParamUtil.FALSE);
            }

            if (replacementThresholdVo.getSale()){
                replacementThresholdVo.setIsSale(ParamUtil.TRUE);
            }else {
                replacementThresholdVo.setIsSale(ParamUtil.FALSE);
            }
        }
        // 查询数量
        int count = replacementThresholdMapper.queryCount(replacementThresholdSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(replacementThresholdSelectVo.getPageIndex());
        allRecordsVo.setPageSize(replacementThresholdSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(replacementThresholdVoList);
        return ResultBuildVo.success(allRecordsVo);
    }

    @Override
    public ResultVo add(ReplacementThresholdAddVo replacementThresholdAddVo) {
        //验证法人编码是否存在
        int legalCount = replacementThresholdMapper.queryLegalCode(replacementThresholdAddVo);
        if (legalCount!=0){
            return ResultBuildVo.error(ParamUtil.REPLACEMENT_REPEAT);
        }
        //验证备件编码是否存在
        int replacementCount = replacementThresholdMapper.queryReplacement(replacementThresholdAddVo);
        if (replacementCount!=0){
            return ResultBuildVo.error(ParamUtil.REPLACEMENT_REPEAT);
        }
        //验证备件唯一性
        int countName = replacementThresholdMapper.queryByCODES(replacementThresholdAddVo);
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.REPLACEMENT_REPEAT);
        }

        Date now= new Date();
        ReplacementThresholdVo replacementThresholdVo = new ReplacementThresholdVo();
        BeanUtils.copyProperties(replacementThresholdAddVo,replacementThresholdVo);
        replacementThresholdVo.setCreateName(ParamUtil.CHANGE_MAN);
        replacementThresholdVo.setCreateTime(now);
        replacementThresholdVo.setChangeName(ParamUtil.CHANGE_MAN);
        replacementThresholdVo.setChangeTime(now);
        replacementThresholdMapper.add(replacementThresholdVo);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo update(ReplacementThresholdUpdateVo replacementThresholdUpdateVo) {
        //修改内容在不在
        ReplacementThresholdVo replacementThresholdVo =  replacementThresholdMapper.queryById(replacementThresholdUpdateVo.getThresholdId());
        if (replacementThresholdVo == null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        // 添加修改时间
        Date now= new Date();
        ReplacementThresholdVo replacementThresholdVo1 = new ReplacementThresholdVo();
        BeanUtils.copyProperties(replacementThresholdUpdateVo,replacementThresholdVo1);
        replacementThresholdVo1.setChangeName(ParamUtil.CHANGE_MAN);
        replacementThresholdVo1.setChangeTime(now);
        Integer version = replacementThresholdMapper.update(replacementThresholdVo1);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }


}
