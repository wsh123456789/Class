package com.wsh.springboot.redis;

import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("testRedis")
    public ResultVo testRedis(){
        redisTemplate.opsForValue().set("wsh","hello 你好!");
        return ResultBuildVo.success();
    }

    @GetMapping("testRedis2")
    public ResultVo testRedis2(){
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setName("kunkun");
//        redisTemplate.opsForValue().set("wsh","hello redis!");
//        redisTemplate.hasKey("wsh");
        redisTemplate.opsForValue().set("wsh","hello redis!",10, TimeUnit.SECONDS);
        return ResultBuildVo.success();
    }


    @GetMapping("queryRedis")
    public ResultVo queryRedis(){
        String wsh = (String) redisTemplate.opsForValue().get("wsh");
        return ResultBuildVo.success(wsh);
    }

    @GetMapping("deleteRedis")
    public ResultVo deleteRedis(){
        redisTemplate.delete("wsh");
        return ResultBuildVo.success();
    }
}
