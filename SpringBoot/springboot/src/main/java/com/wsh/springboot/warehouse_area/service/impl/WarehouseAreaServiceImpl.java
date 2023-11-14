package com.wsh.springboot.warehouse_area.service.impl;

import com.wsh.springboot.util.AllRecordsVo;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse_area.mapper.WarehouseAreaMapper;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaSelectVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaVo;
import com.wsh.springboot.warehouse_area.service.WarehouseAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseAreaServiceImpl implements WarehouseAreaService {

    @Autowired
    private WarehouseAreaMapper warehouseAreaMapper;

    @Override
    public ResultVo queryPage(WarehouseAreaSelectVo warehouseAreaSelectVo) {
        //查询数据
        List<WarehouseAreaVo> warehouseAreaVoList = warehouseAreaMapper.queryData(warehouseAreaSelectVo);
        System.out.println(warehouseAreaVoList);
        // 查询数量
        int count = warehouseAreaMapper.queryCount(warehouseAreaSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(warehouseAreaSelectVo.getPageIndex());
        allRecordsVo.setPageSize(warehouseAreaSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(warehouseAreaVoList);
        return ResultBuildVo.success(allRecordsVo);
//        return ResultBuildVo.success();
    }
}
