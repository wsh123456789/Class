package com.wsh;

import lombok.Data;

import java.io.Serializable;

// 序列化必须 包名一致，对象名一致，参数名一致
@Data
public class OrderVo implements Serializable {
    private Integer id;
    private String code;
    private Integer count;
}
