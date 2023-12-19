package com.example.mybatis_plus.user.mapper;

import com.example.mybatis_plus.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wsh
 * @since 2023-12-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
