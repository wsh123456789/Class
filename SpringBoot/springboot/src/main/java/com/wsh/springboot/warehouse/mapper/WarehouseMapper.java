package com.wsh.springboot.warehouse.mapper;

import com.wsh.springboot.util.ResultVo;
import com.wsh.springboot.warehouse.model.AddressVo;
import com.wsh.springboot.warehouse.model.WarehouseSelectVo;
import com.wsh.springboot.warehouse.model.WarehouseTagList;
import com.wsh.springboot.warehouse.model.WarehouseVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    @Select("select count(id) from warehouse where name=#{name} and name!=name")
    int queryByName(String name);
    @Select("select count(id) from warehouse where code=#{code}")
    int queryByCode(String code);
    @Insert("insert into warehouse(detailAddress,area,nation,province,city,county,name,code,remark,status,wareHouseTagCode,createName,createTime,changeName,changeTime) " +
            "values (#{detailAddress},#{area},#{nation},#{province},#{city},#{county},#{name},#{code},#{remark},#{status},#{wareHouseTagCode},#{createName},#{createTime},#{changeName},#{changeTime})")
    void add(WarehouseVo warehouseVo);
    @Update("update warehouse set name=#{name},remark=#{remark},area=#{area},nation=#{nation},province=#{province}," +
            "city=#{city},county=#{county},changeTime=#{changeTime},changeName=#{changeName},wareHouseTagCode=#{wareHouseTagCode},detailAddress=#{detailAddress} where id=#{id}")
    int update(WarehouseVo warehouseVo);

    @Update("update warehouse set status=#{status} where id=#{id}")
    void updateStatus(WarehouseVo warehouseVo);
    @Select("select * from warehouse where id=#{id}")
    WarehouseVo queryById(Integer id);

    List<WarehouseVo> queryData(WarehouseSelectVo warehouseSelectVo);

    int queryCount(WarehouseSelectVo warehouseSelectVo);
    @Select("select distinct code,remark from warehousetag")
    List<WarehouseTagList> queryWarehouseTagList();

    @Select("select area label,id value from area")
    List<AddressVo> getAreaData();

    @Select("select nation label,id value from nation where parentId=#{parentId}")
    List<AddressVo> getNation(Integer parentId);

    @Select("select province label,id value from province where parentId=#{parentId}")
    List<AddressVo> getProvince(Integer parentId);

    @Select("select city label,id value from city where parentId=#{parentId}")
    List<AddressVo> getCity(Integer parentId);

    @Select("select county label,id value from county where parentId=#{parentId}")
    List<AddressVo> getCounty(Integer parentId);
}
