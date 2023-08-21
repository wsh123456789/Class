package homework.practice03.wangzhe;
/*
* 完成王者模板
	定义一个王者类（WangZhe）
	属性：英雄姓名（name） 英雄价格（price）原皮颜色（color）
	行为：技能（JN）、平A（pA）、英雄简介（JS）
	要求，将属性进行封装，使用封装后的方式赋值和输出
*/

public class WangZheTest {
    public static void main(String[] args) {
        WangZhe wz = new WangZhe();
        wz.setName("老人与海");
        wz.setColor("化肥厂厂长");
        wz.setPrice(18888.0);
        System.out.println("英雄名称：" + wz.getName());
        System.out.println("英雄皮肤：" + wz.getColor());
        System.out.println("英雄价格：" + wz.getPrice());
        wz.JN();
        wz.pA();
        wz.JS();
    }
}