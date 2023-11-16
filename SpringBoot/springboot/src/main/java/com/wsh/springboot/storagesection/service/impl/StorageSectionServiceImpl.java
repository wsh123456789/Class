package com.wsh.springboot.storagesection.service.impl;

import com.wsh.springboot.storagesection.mapper.StorageSectionMapper;
import com.wsh.springboot.storagesection.model.*;
import com.wsh.springboot.storagesection.service.StorageSectionService;
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
public class StorageSectionServiceImpl implements StorageSectionService {
    @Autowired
    private StorageSectionMapper storageSectionMapper;

    @Override
    public ResultVo queryPage(StorageSectionSelectVo storageSectionSelectVo) {
        //查询数据
        List<StorageSectionVo> storageSectionVoList = storageSectionMapper.queryData(storageSectionSelectVo);
        for (StorageSectionVo storageSectionVo : storageSectionVoList){
            if (storageSectionVo.getStatus()){
                storageSectionVo.setStatusName(ParamUtil.OPEN);
            }
            if (!storageSectionVo.getStatus()){
                storageSectionVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        //查询数量
        int count = storageSectionMapper.queryCount(storageSectionSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(storageSectionSelectVo.getPageIndex());
        allRecordsVo.setPageSize(storageSectionSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(storageSectionVoList);
        return ResultBuildVo.success(allRecordsVo);
    }


    @Override
    public ResultVo add(StorageSectionAddVo storageSectionAddVo) {
        //验证名称是唯一的
        int countName = storageSectionMapper.queryByName(storageSectionAddVo.getName());
        if(countName != 0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        //验证编码是唯一的
        int countCode = storageSectionMapper.queryByCode(storageSectionAddVo.getCode());
        if(countCode != 0){
            return ResultBuildVo.error(ParamUtil.CODE_REPEAT);
        }
        Date now = new Date();
        StorageSectionVo storageSectionVo = new StorageSectionVo();
        BeanUtils.copyProperties(storageSectionAddVo, storageSectionVo);
        storageSectionVo.setCreateName(ParamUtil.CHANGE_MAN);
        storageSectionVo.setCreateTime(now);
        storageSectionVo.setChangeName(ParamUtil.CHANGE_MAN);
        storageSectionVo.setChangeTime(now);
        storageSectionMapper.add(storageSectionVo);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo update(StorageSectionUpdateVo storageSectionUpdateVo) {
        //修改内容在不在
        StorageSectionVo subClass =  storageSectionMapper.queryById(storageSectionUpdateVo.getId());
        if (subClass==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        //是不是禁用
        if (subClass.getStatus()){
            return ResultBuildVo.error(ParamUtil.UPDATE_DISABLED);
        }
        int countName = storageSectionMapper.queryByName(storageSectionUpdateVo.getName());
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        Date now = new Date();
        StorageSectionVo storageSectionVo = new StorageSectionVo();
        BeanUtils.copyProperties(storageSectionUpdateVo, storageSectionVo);
        storageSectionVo.setChangeName(ParamUtil.CHANGE_MAN);
        storageSectionVo.setChangeTime(now);
        int countVersion = storageSectionMapper.update(storageSectionVo);
        if(countVersion==0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }

        return ResultBuildVo.success();
    }

    @Override
    public ResultVo updateStatus(StorageSectionUpdateStatusVo storageSectionUpdateStatusVo) {
        StorageSectionVo subClass =  storageSectionMapper.queryById(storageSectionUpdateStatusVo.getId());
        if (subClass==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        Date now= new Date();
        StorageSectionVo storageSectionVo = new StorageSectionVo();
        BeanUtils.copyProperties(storageSectionUpdateStatusVo, storageSectionVo);
        storageSectionVo.setChangeName(ParamUtil.CHANGE_MAN);
        storageSectionVo.setChangeTime(now);
        storageSectionMapper.updateStatus(storageSectionVo);
        return ResultBuildVo.success();
    }


}
