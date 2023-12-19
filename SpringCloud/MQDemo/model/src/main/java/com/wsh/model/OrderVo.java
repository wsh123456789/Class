package com.wsh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {

    private String orderCode;

    private String purchaser;

    private String address;

    private String spareCode;

    private Integer count;

    private Integer status;

    private Integer inventory;

    private Integer occupyCount;

    private Date createTime;
}
