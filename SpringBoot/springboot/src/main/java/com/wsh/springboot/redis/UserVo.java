package com.wsh.springboot.redis;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    private Integer id;
    private String name;
    private String password;

    public UserVo() {

    }

    public UserVo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
