package com.wsh.basics.spare.model;

import com.wsh.basics.util.PageVo;
import lombok.Data;

@Data
public class SpareSelectVo extends PageVo {
    private String name;
    private String code;
    private Boolean status;

}
