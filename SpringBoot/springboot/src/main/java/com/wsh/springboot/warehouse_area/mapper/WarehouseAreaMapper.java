package com.wsh.springboot.warehouse_area.mapper;

import com.wsh.springboot.warehouse_area.model.BusinessAttributeVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaAddVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaSelectVo;
import com.wsh.springboot.warehouse_area.model.WarehouseAreaVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WarehouseAreaMapper {


    int queryCount(WarehouseAreaSelectVo warehouseAreaSelectVo);

    @Select("select id,code,name from warehouseattribute where status = 1;")
    List<BusinessAttributeVo> queryBusinessAttribute();

    List<WarehouseAreaVo> queryData(WarehouseAreaSelectVo warehouseAreaSelectVo);

    @Select("select count(id) from storagesection where name = #{name}")
    int queryByName(@Param("name")String name);

    @Select("select count(id) from storagesection where code = #{code}")
    int queryByCode(@Param("code")String code);


    void add(WarehouseAreaVo warehouseAreaVo);

    void addBusinessAttribute(WarehouseAreaAddVo warehouseAreaAddVo);

    @Delete("delete from area_attribute where storageSectionCode = #{code}")
    void deleteBusinessAttribute(String code);

    @Delete("delete from storagesection where code = #{code}")
    void deleteEWarehouseArea(WarehouseAreaAddVo warehouseAreaAddVo);

    @Select("select count(id) from storagesection where name = #{name} and id != #{id}")
    int queryByNameAndId(@Param("name")String name, @Param("id")Integer id);

    Integer update(WarehouseAreaVo warehouseAreaVo1);

    @Select("select id,code,name,status from storagesection where id=#{id}")
    WarehouseAreaVo queryById(Integer id);

    WarehouseAreaVo queryStorageSectionById(Integer id);

    @Select("select attributeCode from area_attribute where storageSectionCode=#{code}")
    List<String> queryBusinessAttributeByCode(String code);

    @Update("update storagesection set status=#{status} where id=#{id}")
    Integer updateStatus(WarehouseAreaVo warehouseAreaVo1);
}
