package com.example.inventory.warehouse_position.service.impl;

import com.example.inventory.util.AllRecordsVo;
import com.example.inventory.util.ParamUtil;
import com.example.inventory.util.ResultBuildVo;
import com.example.inventory.util.ResultVo;
import com.example.inventory.warehouse_position.mapper.WarehousePositionMapper;
import com.example.inventory.warehouse_position.model.*;
import com.example.inventory.warehouse_position.service.WarehousePositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class WarehousePositionServiceImpl implements WarehousePositionService {
    @Autowired
    private WarehousePositionMapper warehousePositionMapper;

    // 分页查询
    @Override
    public ResultVo queryPage(WarehousePositionSelectVo warehousePositionSelectVo) {
        //查询数据
        List<WarehousePositionVo> warehousePositionVos = warehousePositionMapper.queryData(warehousePositionSelectVo);
        for (WarehousePositionVo warehousePositionVo:warehousePositionVos){
            if (warehousePositionVo.getStatus()){
                warehousePositionVo.setStatusName(ParamUtil.OPEN);
            }
            if (!warehousePositionVo.getStatus()){
                warehousePositionVo.setStatusName(ParamUtil.CLOSE);
            }
        }
        // 查询数量
        int count = warehousePositionMapper.queryCount(warehousePositionSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(warehousePositionSelectVo.getPageIndex());
        allRecordsVo.setPageSize(warehousePositionSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(warehousePositionVos);
        return ResultBuildVo.success(allRecordsVo);
    }

    @Override
    public ResultVo queryStorageBin(WarehousePositionSelectVo warehousePositionSelectVo) {
        //查询数据
        List<WarehousePositionVo> warehousePositionVos = warehousePositionMapper.queryDataBin(warehousePositionSelectVo);
        return ResultBuildVo.success(warehousePositionVos);
    }

    // 批量添加
    @Override
    @Transactional
    public ResultVo add(WarehousePositionAddVo warehousePositionAddVo) {
        // 验证前端传来的数据是否有重复
        HashSet<String> codes = new HashSet<>();
        HashSet<String> names = new HashSet<>();
        for (WarehousePositionAddVo wa : warehousePositionAddVo.getList()) {
            codes.add(wa.getCode());
            names.add(wa.getName());
        }
        // 验证前端传来的编码和名字是否自己有重复
        if (codes.size() < warehousePositionAddVo.getList().size()) {
            return ResultBuildVo.error(ParamUtil.WAREHOUSE_POSITION + ParamUtil.CODE_REPEAT);
        }
        if (names.size() < warehousePositionAddVo.getList().size()) {
            return ResultBuildVo.error(ParamUtil.WAREHOUSE_POSITION + ParamUtil.NAME_REPEAT);
        }

        // 取出所有code对应的数据
        List<WarehousePositionVo> warehousePositionVos = warehousePositionMapper.queryByCodeList(codes);
        // 删除所有库区对应的库位
        warehousePositionMapper.deleteByCode(warehousePositionAddVo.getStorageSectionCode());
        // 验证编码是否存在
        List<String> repeatCodes = warehousePositionMapper.queryRepeatCodes(codes);
        if (repeatCodes.size() > 0) {
            return ResultBuildVo.error(repeatCodes + ParamUtil.WAREHOUSE_POSITION + ParamUtil.CODE_REPEAT);
        }
        // 验证名称是否存在
        List<String> repeatNames = warehousePositionMapper.queryRepeatNames(names);
        if (repeatNames.size() > 0) {
            return ResultBuildVo.error(repeatNames + ParamUtil.WAREHOUSE_POSITION + ParamUtil.NAME_REPEAT);
        }

        // 给新列表赋值
        List<WarehousePositionVo> newList = getWarehousePositionVos(warehousePositionAddVo, warehousePositionVos);

        // 批量添加数据
        warehousePositionMapper.add(newList);

        return ResultBuildVo.success();
    }
    // 数据处理，如果数据一样直接添加进列表，如果不一样进行覆盖添加进列表，并返回新列表
    private static List<WarehousePositionVo> getWarehousePositionVos(WarehousePositionAddVo warehousePositionAddVo, List<WarehousePositionVo> warehousePositionVos) {
        List<WarehousePositionVo> newList = new ArrayList<>();
        for (WarehousePositionAddVo w : warehousePositionAddVo.getList()) {
            WarehousePositionVo wap = new WarehousePositionVo();
            // 判断之前从数据库中拿的数据是否为空，为空说明全是新数据直接赋值给新列表，否则就要比对是否修改了值
            if (warehousePositionVos.size() > 0) {
                // 给一个迭代器对象，让程序可以在比对成功后删除list里比对的对象
                Iterator<WarehousePositionVo> iterator = warehousePositionVos.iterator();
                while (iterator.hasNext()) {
                    WarehousePositionVo wa = iterator.next();
                    if (w.getCode().equals(wa.getCode())) {
                        // 比对成功的数据从列表中删除，下一次就不再比对
                        warehousePositionVos.remove(wa);
                        // 编码相同名字不同，更新名称并更改修改时间
                        if (!w.getName().equals(wa.getName())) {
                            wa.setName(w.getName());
                            Date now = new Date();
                            wa.setChangeName(ParamUtil.CHANGE_MAN);
                            wa.setChangeTime(now);
                        }
                        wap = wa;
                        break;
                    }
                }
            } else {
                BeanUtils.copyProperties(w, wap);
                // 编码不同就给数据添加创建时间和创建人以及修改时间和修改人
                Date now = new Date();
                wap.setCreateName(ParamUtil.CHANGE_MAN);
                wap.setCreateTime(now);
                wap.setChangeName(ParamUtil.CHANGE_MAN);
                wap.setChangeTime(now);
            }
            newList.add(wap);
        }
        return newList;
    }

    // 修改状态
    @Override
    public ResultVo updateStatus(WarehousePositionUpdateStatusVo warehousePositionUpdateStatusVo) {
        WarehousePositionVo warehousePositionVo1 =  warehousePositionMapper.queryById(warehousePositionUpdateStatusVo.getId());
        if (warehousePositionVo1==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        Date now= new Date();
        WarehousePositionVo warehousePositionVo = new WarehousePositionVo();
        BeanUtils.copyProperties(warehousePositionUpdateStatusVo,warehousePositionVo);
        warehousePositionVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehousePositionVo.setChangeTime(now);
        Integer version = warehousePositionMapper.updateStatus(warehousePositionVo);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        return ResultBuildVo.success();
    }

    // 修改数据
    @Override
    public ResultVo update(WarehousePositionUpdateVo warehousePositionUpdateVo) {
        //修改内容在不在
        WarehousePositionVo warehousePositionVo1 =  warehousePositionMapper.queryById(warehousePositionUpdateVo.getId());
        if (warehousePositionVo1==null){
            return ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }

        // 名称不能重复
        int countName = warehousePositionMapper.queryByNameAndId(warehousePositionUpdateVo.getName(),warehousePositionUpdateVo.getId());
        if (countName!=0){
            return ResultBuildVo.error(ParamUtil.NAME_REPEAT);
        }
        // 修改库区数据
        Date now= new Date();
        WarehousePositionVo warehousePositionVo = new WarehousePositionVo();
        BeanUtils.copyProperties(warehousePositionUpdateVo,warehousePositionVo);
        warehousePositionVo.setChangeName(ParamUtil.CHANGE_MAN);
        warehousePositionVo.setChangeTime(now);
        Integer version = warehousePositionMapper.update(warehousePositionVo);
        if (version == 0){
            return ResultBuildVo.error(ParamUtil.MESSAGE_IS_UPDATED);
        }
        //
        return ResultBuildVo.success();
    }

}
