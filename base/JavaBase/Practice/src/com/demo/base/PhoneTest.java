package com.demo.base;

import java.util.Scanner;

public class PhoneTest {
    public static void main(String[] args) {
        // 创建phone 对象
        Phone p1 = new Phone();
        p1.call();
        p1.sendMessage("你好");
        p1.playGame();
        p1.name = "iPhone";
        p1.price = 10999;
        System.out.println("name = " + p1.name + ", price = " + p1.price);
        p1.setDate(2023);
        int date = p1.getDate();
        System.out.println(date);

    }


}
