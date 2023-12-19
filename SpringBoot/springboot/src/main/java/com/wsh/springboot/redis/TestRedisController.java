package com.wsh.springboot.redis;

import com.wsh.springboot.subclass.mapper.SubClassMapper;
import com.wsh.springboot.subclass.model.SubClassVo;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("testR")
public class TestRedisController {

    @Autowired
    private SubClassMapper subClassMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("queryById")
    public ResultVo queryById(Integer id) {
        String key = "subclass" + id;
        if (redisTemplate.hasKey(key)) {
            System.out.println("缓存查询");
            SubClassVo subClassVo = (SubClassVo) redisTemplate.opsForValue().get(key);
            return ResultBuildVo.success(subClassVo);
        }
        System.out.println("数据库查询");
        // 根据id查询数据库
        SubClassVo subClassVo = subClassMapper.queryById(id);
        redisTemplate.opsForValue().set(key, subClassVo);
        return ResultBuildVo.success(subClassVo);
    }

    @PostMapping("updateById")
    public ResultVo queryById(@RequestBody SubClassVo subClassVo) {
        String key = "subclass" + subClassVo.getId();
        // 修改数据
        subClassMapper.update(subClassVo);
        System.out.println("数据库查询");
        // 根据id查询数据库
        SubClassVo subClassVo2 = subClassMapper.queryById(subClassVo.getId());
        redisTemplate.opsForValue().set(key, subClassVo2);
        return ResultBuildVo.success(subClassVo2);
    }

    @GetMapping("queryUser3")
    public ResultVo queryUser3(Integer id) {
        String key = "user" + id;
        SubClassVo userVoList = (SubClassVo) redisTemplate.opsForValue().get(key);
        if (userVoList == null) {
            synchronized (this) {
                userVoList = (SubClassVo) redisTemplate.opsForValue().get(key);
                if (userVoList == null) {
                    //操作数据库
                    System.out.println("操作数据库了！");
                    userVoList = subClassMapper.queryById(id);
                    redisTemplate.opsForValue().set(key, userVoList);
                }
            }
        }
        return ResultBuildVo.success(userVoList);
    }

    @GetMapping("pointLogin1")
    public ResultVo pointLogin1(@Param("name") String name,@Param("password") String password, HttpServletResponse resp) {
        String key = "user" + name;
        UserVo userVo = new UserVo(name,password);
        System.out.println(userVo.getName() + userVo.getPassword());
        //验证用户名和密码是否正确
        if (userVo.getName().equals("angus") && userVo.getPassword().equals("aaa")){
            System.out.println("密码正确");
            redisTemplate.opsForValue().set(key, userVo);
            Cookie cookie = new Cookie(userVo.getName(), key);
            resp.addCookie(cookie);
            return ResultBuildVo.success("登录成功");
        }
        return ResultBuildVo.error("登录失败");
    }

    @GetMapping("pointLogin2")
    public ResultVo pointLogin2(@Param("name") String name,@Param("password") String password, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        UserVo userVo = new UserVo(name,password);
        UserVo key = null;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(userVo.getName())) {
                    key = (UserVo) redisTemplate.opsForValue().get(cookie.getValue());
                }
            }
        }
        if (key == null){
            return ResultBuildVo.error("用户未登录，请重新登录");
        }else {
            return ResultBuildVo.success(key);
        }
    }

}
