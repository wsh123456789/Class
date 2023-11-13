package com.wsh.springboot.util;

import lombok.Data;

@Data
public class ResultVo<T> {
    private Boolean success;
    private T data;
    private String errorMessage;
}