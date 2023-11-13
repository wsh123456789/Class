package com.wsh.springboot.spare.model;

import com.wsh.springboot.util.PageVo;
import lombok.Data;

@Data
public class SpareSelectVo extends PageVo {
    private String name;
    private String code;
    private Boolean status;

}
