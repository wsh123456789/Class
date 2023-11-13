package com.wsh.springboot.legalplant.service.impl;

import com.wsh.springboot.legalplant.mapper.LegalPlantMapper;
import com.wsh.springboot.legalplant.model.*;
import com.wsh.springboot.legalplant.service.LegalPlantService;
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
public class LegalPlantServiceImpl implements LegalPlantService {

    @Autowired
    private LegalPlantMapper legalPlantMapper;

    // 分页查询
    @Override
    public ResultVo queryPage(LegalPlantSelectVo legalPlantSelectVo) {

        // 把session中的id赋值给对象
        legalPlantSelectVo.setUserId(ParamUtil.ONE);
        //查询数据
        List<LegalPlantVo> legalPlantVoList = legalPlantMapper.queryData(legalPlantSelectVo);

        //查询数量
        int count = legalPlantMapper.queryCount(legalPlantSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(legalPlantSelectVo.getPageIndex());
        allRecordsVo.setPageSize(legalPlantSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(legalPlantVoList);
        return ResultBuildVo.success(allRecordsVo);
    }

    // 添加
    @Override
    public ResultVo add(LegalPlantAddVo legalPlantAddVo) {

        //验证工厂编码必须是唯一的
        int legalPlantCod = legalPlantMapper.queryByCode(legalPlantAddVo.getLegalPlantCode());
        if (legalPlantCod != 0) {
            return ResultBuildVo.error(ParamUtil.LEGAL_PLANT + ParamUtil.CODE_REPEAT);
        }
        // 获取当前时间与修改人
        Date now = new Date();
        LegalPlantVo legalPlantVo = new LegalPlantVo();
        BeanUtils.copyProperties(legalPlantAddVo, legalPlantVo);
        legalPlantVo.setCreateName(ParamUtil.CHANGE_MAN);
        legalPlantVo.setCreateTime(now);
        legalPlantVo.setUpdateName(ParamUtil.CHANGE_MAN);
        legalPlantVo.setUpdateTime(now);
        legalPlantMapper.add(legalPlantVo);
        return ResultBuildVo.success();
    }

    // 修改
    @Override
    public ResultVo update(LegalPlantUpdateVo legalPlantUpdateVo) {
        //修改内容在不在
        LegalPlantVo legalPlantVo = legalPlantMapper.queryById(legalPlantUpdateVo.getId());
        if (legalPlantVo == null) {
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        //是不是禁用
        if (legalPlantVo.getEnabled()) {
            return ResultBuildVo.error(ParamUtil.UPDATE_DISABLED);
        }
        // 获取当前时间与修改人
        Date now = new Date();
        LegalPlantVo legalPlantVo1 = new LegalPlantVo();
        BeanUtils.copyProperties(legalPlantUpdateVo, legalPlantVo1);
        legalPlantVo1.setUpdateName(ParamUtil.CHANGE_MAN);
        legalPlantVo1.setUpdateTime(now);
        int version = legalPlantMapper.update(legalPlantVo1);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }

    // 修改状态
    @Override
    public ResultVo updateStatus(LegalPlantUpdateStatusVo legalPlantUpdateStatusVo) {
        //修改内容在不在
        LegalPlantVo legalPlantVo = legalPlantMapper.queryById(legalPlantUpdateStatusVo.getId());
        if (legalPlantVo == null) {
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        // 获取当前时间与修改人
        Date now = new Date();
        LegalPlantVo legalPlantVo1 = new LegalPlantVo();
        BeanUtils.copyProperties(legalPlantUpdateStatusVo, legalPlantVo1);
        legalPlantVo1.setUpdateName(ParamUtil.CHANGE_MAN);
        legalPlantVo1.setUpdateTime(now);
        int version = legalPlantMapper.updateStatus(legalPlantVo1);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }
}
