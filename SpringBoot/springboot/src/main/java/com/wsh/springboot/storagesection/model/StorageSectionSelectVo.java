package com.wsh.springboot.storagesection.model;

import com.wsh.springboot.util.PageVo;
import lombok.Data;


@Data
public class StorageSectionSelectVo extends PageVo {
    private Integer id;
    private String name;
    private String code;
    private String remark;
    private Boolean status;

}
