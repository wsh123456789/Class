package com.example.mybatis_plus.user.service.impl;

import com.example.mybatis_plus.user.entity.User;
import com.example.mybatis_plus.user.mapper.UserMapper;
import com.example.mybatis_plus.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wsh
 * @since 2023-12-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
