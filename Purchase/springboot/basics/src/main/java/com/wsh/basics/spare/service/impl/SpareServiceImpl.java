package com.wsh.basics.spare.service.impl;

import com.wsh.basics.spare.mapper.SpareMapper;
import com.wsh.basics.spare.model.*;
import com.wsh.basics.spare.service.SpareService;
import com.wsh.basics.util.AllRecordsVo;
import com.wsh.basics.util.ParamUtil;
import com.wsh.basics.util.ResultBuildVo;
import com.wsh.basics.util.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SpareServiceImpl implements SpareService {

    @Autowired
    private SpareMapper spareMapper;

    // 查询数据
    @Override
    public ResultVo queryPage(SpareSelectVo spareSelectVo) {
        //查询数据
        List<SpareVo> spareVoList = spareMapper.queryData(spareSelectVo);
        for (SpareVo spareVo:spareVoList){
            if (spareVo.getStatus()){
                spareVo.setStatusName(ParamUtil.OPEN);
            }
            if (!spareVo.getStatus()){
                spareVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        //查询数量
        int count = spareMapper.queryCount(spareSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(spareSelectVo.getPageIndex());
        allRecordsVo.setPageSize(spareSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(spareVoList);
        return ResultBuildVo.success(allRecordsVo);
    }

    @Override
    public ResultVo add(SpareAddVo spareAddVo) {
        //验证名称必须是唯一的
        int countName = spareMapper.queryByName(spareAddVo.getName(),null);
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.SPARE + ParamUtil.NAME_REPEAT);
        }
        //验证编码是唯一的
        int countCode = spareMapper.queryByCode(spareAddVo.getCode(),null);
        if (countCode!=0){
            return ResultBuildVo.error(ParamUtil.SPARE + ParamUtil.CODE_REPEAT);
        }
        Date now= new Date();
        SpareVo spareVo = new SpareVo();
        BeanUtils.copyProperties(spareAddVo,spareVo);
        spareVo.setCreateName(ParamUtil.CHANGE_MAN);
        spareVo.setCreateTime(now);
        spareVo.setUpdateName(ParamUtil.CHANGE_MAN);
        spareVo.setUpdateTime(now);
        spareMapper.add(spareVo);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo update(SpareUpdateVo spareUpdateVo) {
        //修改内容在不在
        SpareVo spare =  spareMapper.queryById(spareUpdateVo.getId());
        if (spare==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        //是不是禁用
        if (spare.getStatus()){
            return ResultBuildVo.error(ParamUtil.UPDATE_DISABLED);
        }
        int countName = spareMapper.queryByName(spareUpdateVo.getName(),null);
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        Date now= new Date();
        SpareVo spareVo = new SpareVo();
        BeanUtils.copyProperties(spareUpdateVo,spareVo);
        spareVo.setUpdateName(ParamUtil.CHANGE_MAN);
        spareVo.setUpdateTime(now);
        int version = spareMapper.update(spareVo);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo updateStatus(SpareUpdateStatusVo spareUpdateStatusVo) {
        SpareVo spare =  spareMapper.queryById(spareUpdateStatusVo.getId());
        if (spare==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        Date now= new Date();
        SpareVo spareVo = new SpareVo();
        BeanUtils.copyProperties(spareUpdateStatusVo,spareVo);
        spareVo.setUpdateName(ParamUtil.CHANGE_MAN);
        spareVo.setUpdateTime(now);
        int version = spareMapper.updateStatus(spareVo);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }

//    /*
//     * 计划大类分页查询
//     * */
//    @Override
//    public PageVo queryPageVo(SpareVo spareVo, Integer currentPage) {
//        // 获取当前页
//        PageVo pageVo = new PageVo();
//        if (currentPage == null) {
//            currentPage = 1;
//        }
//        // 获取要查询的数据量
//        Integer totalSize = spareMapper.queryTotalSize(spareVo);
//        // 计算总页数
//        Integer totalPage = totalSize % ParamUtil.PAGE_COUNT == ParamUtil.ZERO ? totalSize / ParamUtil.PAGE_COUNT : totalSize / ParamUtil.PAGE_COUNT + ParamUtil.ONE;
//        // 分页查询数据
//        List<SpareVo> spareVoList = spareMapper.querySparePage((currentPage - ParamUtil.ONE) * ParamUtil.PAGE_COUNT, ParamUtil.PAGE_COUNT,spareVo);
//        // 赋值给pageVo对象
//        pageVo.setCurrentPage(currentPage);
//        pageVo.setTotalSize(totalSize);
//        pageVo.setTotalPage(totalPage);
//        pageVo.setSpareVoList(spareVoList);
//        return pageVo;
//    }
//
//    /*
//    * 计划大类添加功能
//    * */
//    @Override
//    public ResultVo add(SpareAddVo spareAddVo) {
//        // 验证编码是唯一的
//        int countCode = spareMapper.queryByCode(spareAddVo.getCode(),null);
//        if (countCode != 0){
//            return ResultBuildVo.error("编码已存在");
//        }
//        // 验证名称必须唯一的
//        int countName = spareMapper.queryByName(spareAddVo.getName(),null);
//        if (countName != 0){
//            return ResultBuildVo.error("名称已存在");
//        }
//        // 设置默认的创建和修改时间以及创建和修改人
//        Date now = new Date();
//        SpareVo spareVo = new SpareVo();
//        BeanUtils.copyProperties(spareAddVo,spareVo);
//        spareVo.setCreateName("张三");
//        spareVo.setCreateTime(now);
//        spareVo.setUpdateName("张三");
//        spareVo.setUpdateTime(now);
//        spareMapper.add(spareVo);
//        return ResultBuildVo.success();
//    }
//
//    /*
//    * 获取修改计划大类页面的回显数据
//    * */
//    @Override
//    public ResultVo showUpdate(Integer id) {
//        SpareUpdateVo spareUpdateVo = spareMapper.queryById(id);
//        return ResultBuildVo.success(spareUpdateVo);
//    }
//
//    /*
//    * 修改计划大类数据
//    *
//    * */
//    @Override
//    public ResultVo update(SpareUpdateVo spareUpdateVo) {
//        SpareUpdateVo spareUpdateVo1 = spareMapper.queryById(spareUpdateVo.getId());
//        if (spareUpdateVo1 == null){
//            return ResultBuildVo.error("查询结果为空");
//        }
//        // 查询状态是否为禁止
//        if (spareUpdateVo1.getStatus() != false){
//            return ResultBuildVo.error("状态为禁止才可修改");
//        }
//        // 验证编码是唯一的
//        int countCode = spareMapper.queryByCode(spareUpdateVo1.getCode(),spareUpdateVo1.getId());
//        if (countCode != 0){
//            return ResultBuildVo.error("编码已存在");
//        }
//        // 验证名称必须唯一的
//        int countName = spareMapper.queryByName(spareUpdateVo1.getName(),spareUpdateVo1.getId());
//        if (countName != 0){
//            return ResultBuildVo.error("名称已存在");
//        }
//        Date now = new Date();
//        SpareVo spareVo = new SpareVo();
//        BeanUtils.copyProperties(spareUpdateVo1,spareVo);
//        spareVo.setUpdateName("李四");
//        spareVo.setUpdateTime(now);
//        spareMapper.update(spareVo);
//        return ResultBuildVo.success();
//    }
//
//
//    /*
//    * 修改计划大类状态
//    * */
//    @Override
//    public ResultVo updateStatusById(SpareStatusVo spareStatusVo) {
//        spareMapper.updateStatusById(spareStatusVo);
//        return ResultBuildVo.success();
//    }



}
