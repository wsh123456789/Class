package com.example.easypoii.moudel;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
导入依赖包
导出的对象必须实现序列化接口
实体类
    @ExcelTarget(value)    用在实体类上可以表名这个实体类是easypoi导入导出的实体类 value没有实际意义只是一个标识
属性
    @Excel(name = “每一列的名字”) 每一个属性作为excel的每一列
        orderNum 第几列
        suffix后缀
        width宽度
        format日期格式化
        replace将某个对应的值替换 替换后的_原值
        @ExcelIgnore

 */
@Data
@ExcelTarget("emps")
public class Useremps implements Serializable {
    //编号
    @Excel(name="编号")
//    @ExcelIgnore
    private String id;
    //姓名
    @Excel(name="姓名")
    private String name;
    //年龄
    @Excel(name="年龄" ,orderNum = "4",suffix = "岁" ,replace = {"100_10"})
    private Integer age;
    //生日
    @Excel(name="生日",width = 35.0,format = "yyyy-MM-dd HH:mm:ss", orderNum = "3")
    private Date bir;
    //状态
    @Excel(name="状态" ,replace = {"启用_1","禁用_0"})
    private Integer status;

//    @ExcelIgnore
    @Excel(name="爱好",width = 30.0)
    private String habbys;

    //type 默认类型为 1 是文本类型  2 图片类型
    @Excel(name = "歌手",width = 60,height = 60,type = 2,savePath = "C:/Users/Lenovo/Desktop/picture")
    private String photo;
}
