package com.demo._thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) {
        // 优点 call()方法更灵活可以抛出异常，有返回值
        // callable 使用了泛型参数，可以指明call()的返回值类型
        // 缺点 如果主线程需要获取返回值，在支线程执行完之前主线程会进入阻塞状态
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();

        try{
            Object sum = futureTask.get();
            System.out.println("总和为" + sum);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}
