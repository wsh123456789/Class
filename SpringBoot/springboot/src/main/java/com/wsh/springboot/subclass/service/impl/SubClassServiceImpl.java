package com.wsh.springboot.subclass.service.impl;

import com.wsh.springboot.subclass.mapper.SubClassMapper;
import com.wsh.springboot.subclass.model.*;
import com.wsh.springboot.subclass.service.SubClassService;
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
public class SubClassServiceImpl implements SubClassService {

    @Autowired
    private SubClassMapper subClassMapper;

    // 查询数据
    @Override
    public ResultVo queryPage(SubClassSelectVo subClassSelectVo) {
        //查询数据
        List<SubClassVo> subClassVoList = subClassMapper.queryData(subClassSelectVo);
        for (SubClassVo subClassVo:subClassVoList){
            if (subClassVo.getStatus()){
                subClassVo.setStatusName(ParamUtil.OPEN);
            }
            if (!subClassVo.getStatus()){
                subClassVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        //查询数量
        int count = subClassMapper.queryCount(subClassSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(subClassSelectVo.getPageIndex());
        allRecordsVo.setPageSize(subClassSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(subClassVoList);
        return ResultBuildVo.success(allRecordsVo);
    }

    @Override
    public ResultVo add(SubClassAddVo subClassAddVo) {
        //验证名称必须是唯一的
        int countName = subClassMapper.queryByName(subClassAddVo.getName(),null);
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.SUBCLASS + ParamUtil.NAME_REPEAT);
        }
        //验证编码是唯一的
        int countCode = subClassMapper.queryByCode(subClassAddVo.getCode(),null);
        if (countCode!=0){
            return ResultBuildVo.error(ParamUtil.SUBCLASS + ParamUtil.CODE_REPEAT);
        }
        Date now= new Date();
        SubClassVo subClassVo = new SubClassVo();
        BeanUtils.copyProperties(subClassAddVo,subClassVo);
        subClassVo.setCreateName(ParamUtil.CHANGE_MAN);
        subClassVo.setCreateTime(now);
        subClassVo.setUpdateName(ParamUtil.CHANGE_MAN);
        subClassVo.setUpdateTime(now);
        subClassMapper.add(subClassVo);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo update(SubClassUpdateVo subClassUpdateVo) {
        //修改内容在不在
        SubClassVo subClass =  subClassMapper.queryById(subClassUpdateVo.getId());
        if (subClass==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        //是不是禁用
        if (subClass.getStatus()){
            return ResultBuildVo.error(ParamUtil.UPDATE_DISABLED);
        }
        int countName = subClassMapper.queryByName(subClassUpdateVo.getName(),null);
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        Date now= new Date();
        SubClassVo subClassVo = new SubClassVo();
        BeanUtils.copyProperties(subClassUpdateVo,subClassVo);
        subClassVo.setUpdateName(ParamUtil.CHANGE_MAN);
        subClassVo.setUpdateTime(now);
        Integer version = subClassMapper.update(subClassVo);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo updateStatus(SubClassUpdateStatusVo subClassUpdateStatusVo) {
        SubClassVo subClass =  subClassMapper.queryById(subClassUpdateStatusVo.getId());
        if (subClass==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        Date now= new Date();
        SubClassVo subClassVo = new SubClassVo();
        BeanUtils.copyProperties(subClassUpdateStatusVo,subClassVo);
        subClassVo.setUpdateName(ParamUtil.CHANGE_MAN);
        subClassVo.setUpdateTime(now);
        Integer version =subClassMapper.updateStatus(subClassVo);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }

}
