package com.example.nacosprovider;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProviderMapper {
    @Select("select * from user")
    List<UserVo> queryUser();
}
