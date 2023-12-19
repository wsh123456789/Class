package com.example.consumer;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {
        System.out.println("程序启动");
        Timer timer = new Timer();
        // schedule()方法是"安排"的意思
        // 给定时器一个任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行定时器任务");
            }
        },3000,1000);
    }
}
