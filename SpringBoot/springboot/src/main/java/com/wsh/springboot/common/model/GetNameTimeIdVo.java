package com.wsh.springboot.common.model;

import lombok.Data;

import java.util.Date;

@Data
public class GetNameTimeIdVo {
    private String createName;
    private String requestForQuotationId;
    private Date createTime;
}
