package com.chen.user.mapper;

import com.chen.user.entiy.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select id,name,password from user ")
    List<User> queryUsrInfo();
    @Select("select name,password from user where id=#{id}")
    List<User> queryUsrInfoById(int id);
}
