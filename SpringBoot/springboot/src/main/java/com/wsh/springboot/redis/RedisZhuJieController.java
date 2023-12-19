package com.wsh.springboot.redis;

import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zhujie")
public class RedisZhuJieController {

    @GetMapping("addRedis")
    @Cacheable(value = "user", key = "'user' + #id")
    public ResultVo addRedis(Integer id){
        System.out.println("添加操作数据库");
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setName("张三");
        return ResultBuildVo.success(userVo);
    }

    @GetMapping("updateRedis")
    @CachePut(value = "user", key = "'user' + #id")
    public ResultVo updateRedis(Integer id){
        System.out.println("修改操作数据库");
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setName("张三修改");
        return ResultBuildVo.success(userVo);
    }

    @GetMapping("deleteRedis")
    @CacheEvict(value = "user", key = "'user' + #id")
    public ResultVo deleteRedis(Integer id){
        System.out.println("修改操作数据库");
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setName("张三删除");
        return ResultBuildVo.success(userVo);
    }


}
