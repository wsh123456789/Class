package com.demo._thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 线程池
        // 提供指定线程数量的线程池
        // 不推荐这样创建，因为这样创建对线程的可控力度较低
        // ExecutorService service = Executors.newFixedThreadPool(10);
        // ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        // 设置线程池属性
        // service1.setMaximumPoolSize(50);

        // 执行指定线程的操作，需要提供实现Runnable接口或Callable接口的实现类的对象
        // service.execute(new MyRunnable());
        // Callable用service.submit(new MyCallable())方法

        // 关闭线程池
        // service.shutdown();

        // 推荐手动创建
        // 线程池7个参数
//        int corePoolSize          核心线程数
//        int maximumPoolSize       最大线程数
//        long keepAliveTime        最大空闲时间
//        TimeUnit unit             时间单位
//        BlockingQueue<Runnable> workQueue  阻塞队列
//        ThreadFactory threadFactory        线程工厂  用于定义线程名称，出错时能够确定出错线程进行处理
//        RejectedExecutionHandler handler   拒绝策略



    }
}
