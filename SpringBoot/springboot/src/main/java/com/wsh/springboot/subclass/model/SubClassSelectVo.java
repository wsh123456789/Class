package com.wsh.springboot.subclass.model;

import com.wsh.springboot.util.PageVo;
import lombok.Data;

@Data
public class SubClassSelectVo extends PageVo {
    private String name;
    private String code;
    private Boolean status;


}
