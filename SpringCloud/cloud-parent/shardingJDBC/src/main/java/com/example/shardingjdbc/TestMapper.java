package com.example.shardingjdbc;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Select("select * from user")
    List<UserVo> queryList();
   @Insert("insert into user(name) values(#{name})")
   int insertUser(UserVo userVo);
    @Insert("insert into customer(id,uid,name,age,addressName) values (#{id},#{uid},#{name},#{age},#{address})")
    void insertCustomer(CustomerVo customerVo);

    @Select("select * from customer")
    List<CustomerVo> queryCustomer();
}
