package com.wsh.springboot;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

//    @Select("select * from user")
    List<UserVo> queryAll();
}
