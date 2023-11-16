package com.wsh.springboot.warehousetag.mapper;

import com.wsh.springboot.warehousetag.model.WarehouseTagSelectVo;
import com.wsh.springboot.warehousetag.model.WarehouseTagVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WarehouseTagMapper {

    @Select("select count(id) from warehousetag where name=#{name} and name!=name")
    int queryByName(String name);
    @Select("select count(id) from warehousetag where code=#{code}")
    int queryByCode(String code);
    @Insert("insert into warehousetag(name,code,remark,status,createName,createTime,changeName,changeTime) " +
            "values (#{name},#{code},#{remark},#{status},#{createName},#{createTime},#{changeName},#{changeTime})")
    void add(WarehouseTagVo warehouseTagVo);
    @Update(" update warehousetag set name=#{name},remark=#{remark},version=version+1 where id=#{id} and version=#{version}")
    int update(WarehouseTagVo warehouseTagVo);

    @Update("update warehousetag set status=#{status} where id=#{id}")
    void updateStatus(WarehouseTagVo warehouseTagVo);
    @Select("select * from warehousetag where id=#{id}")
    WarehouseTagVo queryById(Integer id);

    List<WarehouseTagVo> queryData(WarehouseTagSelectVo warehouseTagSelectVo);

    int queryCount(WarehouseTagSelectVo warehouseTagSelectVo);
}
