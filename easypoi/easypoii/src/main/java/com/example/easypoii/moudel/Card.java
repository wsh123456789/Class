package com.example.easypoii.moudel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
@ExcelTarget("card")
@Data
public class Card implements Serializable {
    @Excel(name = "身份证号码",width = 20.0 ,orderNum = "6")
    private String cardNum;
    @Excel(name = "家庭住址",width = 20.0 ,orderNum = "7")
    private String address;
}
