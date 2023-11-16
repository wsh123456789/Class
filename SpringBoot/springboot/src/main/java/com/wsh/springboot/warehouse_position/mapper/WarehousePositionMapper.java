package com.wsh.springboot.warehouse_position.mapper;

import com.wsh.springboot.warehouse_position.model.WarehousePositionSelectVo;
import com.wsh.springboot.warehouse_position.model.WarehousePositionVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WarehousePositionMapper {
    
    List<WarehousePositionVo> queryData(WarehousePositionSelectVo warehousePositionSelectVo);

    int queryCount(WarehousePositionSelectVo warehousePositionSelectVo);

    @Select("select id,code,name,legalPersonId from storagebin where storageSectionCode=#{storageSectionCode}")
    List<WarehousePositionVo> queryDataBin(WarehousePositionSelectVo warehousePositionSelectVo);

    @Select("select id,legalPersonId from storagebin where code=#{code}")
    WarehousePositionVo queryByCode(String code);

    @Delete("delete from storagebin where code=#{code}")
    void deleteByCode(String code);
    @Select("select count(id) from storagebin where name=#{name}")
    int queryByName(String name);

    void add(@Param("WarehousePositionVo") List<WarehousePositionVo> warehousePositionVos);

    @Select("select id from storagebin where id=#{id}")
    WarehousePositionVo queryById(Integer id);

    @Update("update storagebin set status=#{status} where id=#{id}")
    Integer updateStatus(WarehousePositionVo warehousePositionVo);
    @Select("select COUNT(id) from storagebin where id!=#{id} and name=#{name}")
    int queryByNameAndId(@Param("name") String name,@Param("id") Integer id);

    @Update("update storagebin set name=#{name} where id=#{id}")
    Integer update(WarehousePositionVo warehousePositionVo);
}
