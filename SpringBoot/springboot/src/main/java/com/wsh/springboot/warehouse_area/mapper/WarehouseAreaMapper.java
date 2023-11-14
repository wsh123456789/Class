package com.wsh.springboot.warehouse_area.mapper;

import com.wsh.springboot.warehouse_area.model.WarehouseAreaSelectVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseAreaMapper {

    List<WarehouseAreaVo> queryData(WarehouseAreaSelectVo warehouseAreaSelectVo);

    int queryCount(WarehouseAreaSelectVo warehouseAreaSelectVo);
}
