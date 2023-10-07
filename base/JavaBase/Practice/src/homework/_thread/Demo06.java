package homework._thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo06 {
    public static void main(String[] args) {
        /**
         * 2.有100个限量版的水杯，但是只能通过实体店和官网才能进行购买，并且分别统计卖了多少。
         * 请用线程进行模拟并设置线程名称用来代表售出途径，再将信息打印出来。
         比如（实体店卖出第1个，总共剩余n个..）

         */
//        Cup t1 = new Cup();
//        t1.setName("实体店");
//        Cup t2 = new Cup();
//        t2.setName("官网");
//        t1.start();
//        t2.start();
        Cup cup = new Cup();
        Thread t1 = new Thread(cup,"实体店");
        Thread t2 = new Thread(cup,"官网");
        t1.start();
        t2.start();


    }
}

//class Cup extends Thread {
//    public static int count = 0;
//    public static int count1 = 0;
//    public static int count2 = 0;
//    public static ReentrantLock  lock =  new ReentrantLock();
//    @Override
//    public void run() {
//
//        while (true){
//            lock.lock();
//            if (count == 100) {
//                break;
//            }
//            count++;
//            System.out.println(Thread.currentThread().getName() + "卖出第" + count + "个杯子, 还剩余" + (100 - count) + "个杯子");
//            if (Thread.currentThread().getName().equals("实体店")){
//                count1++;
//            }else {
//                count2++;
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            lock.unlock();
//        }
//        System.out.println("实体店卖出了"+ count1 + "个杯子");
//        System.out.println("官网卖出了"+ count2 + "个杯子");
//
//    }
//}

class Cup implements Runnable {
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    ReentrantLock  lock =  new ReentrantLock();
    @Override
    public void run() {

        while (true){
            lock.lock();
            if (count == 100) {
                break;
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "卖出第" + count + "个杯子, 还剩余" + (100 - count) + "个杯子");
            if (Thread.currentThread().getName().equals("实体店")){
                count1++;
            }else {
                count2++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.unlock();
        }
        System.out.println("实体店卖出了"+ count1 + "个杯子");
        System.out.println("官网卖出了"+ count2 + "个杯子");

    }
}
