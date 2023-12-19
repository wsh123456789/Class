package com.example.easypoii.moudel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@ExcelTarget("orders")
@Data
public class Orders implements Serializable {
    @Excel(name = "订单编号" ,orderNum = "8",width = 20.0)
    private String buyId;
    @Excel(name = "订单名称" ,orderNum = "8",width = 20.0)
    private String name;


    public Orders(String buyId, String name) {
        this.buyId = buyId;
        this.name = name;
    }
}
