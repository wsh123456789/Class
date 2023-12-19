package com.wsh.springboot.jwt;

import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @GetMapping("login11")
    public ResultVo login11(){
        Integer userId = 5;
        String token = JwtUtils.createToken(userId)+"ADJFLjd*&@dslfjljslf";
        return   ResultBuildVo.success(token);
    }

    @GetMapping("login22")
    public ResultVo login22(String token){
        Integer user = JwtUtils.getUser(token);
        System.out.println(user);
        return ResultBuildVo.success(user);
    }
}
