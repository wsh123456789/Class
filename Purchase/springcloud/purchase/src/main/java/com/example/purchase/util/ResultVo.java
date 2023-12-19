package com.example.purchase.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVo<T> implements Serializable {
    private Boolean success;
    private T data;
    private String errorMessage;
}