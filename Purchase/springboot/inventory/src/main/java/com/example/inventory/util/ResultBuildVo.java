package com.example.inventory.util;

import lombok.Data;

@Data
public class ResultBuildVo<T> {
    public static<T> ResultVo success(T data){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        resultVo.setData(data);
        return resultVo;
    }
    public static<T> ResultVo success(){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        resultVo.setData(null);
        return resultVo;
    }
    public static ResultVo error(String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(false);
        resultVo.setErrorMessage(message);
        return resultVo;
    }
}
