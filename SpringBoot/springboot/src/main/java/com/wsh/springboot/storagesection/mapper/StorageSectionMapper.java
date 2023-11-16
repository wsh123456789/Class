package com.wsh.springboot.storagesection.mapper;

import com.wsh.springboot.storagesection.model.StorageSectionSelectVo;
import com.wsh.springboot.storagesection.model.StorageSectionVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StorageSectionMapper {

    @Select("select count(id) from warehouseattribute where name=#{name} and name!=name")
    int queryByName(String name);
    @Select("select count(id) from warehouseattribute where code=#{code}")
    int queryByCode(String code);
    @Insert("insert into warehouseattribute(name,code,remark,status,createName,createTime,changeName,changeTime) " +
            "values (#{name},#{code},#{remark},#{status},#{createName},#{createTime},#{changeName},#{changeTime})")
    void add(StorageSectionVo storageSectionVo);
    @Update(" update warehouseattribute set name=#{name},remark=#{remark},version=version+1 where id=#{id} and version=#{version}")
    int update(StorageSectionVo storageSectionVo);

    @Update("update warehouseattribute set status=#{status} where id=#{id}")
    void updateStatus(StorageSectionVo storageSectionVo);
    @Select("select * from warehouseattribute where id=#{id}")
    StorageSectionVo queryById(Integer id);

    List<StorageSectionVo> queryData(StorageSectionSelectVo storageSectionSelectVo);

    int queryCount(StorageSectionSelectVo storageSectionSelectVo);
}
