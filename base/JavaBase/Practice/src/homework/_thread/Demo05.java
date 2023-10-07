package homework._thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo05 {
    public static void main(String[] args) {
        /**
         * 模拟四个窗口同时售票，打印剩余票数
         */
        MyTicket myTicket = new MyTicket();
        Thread t1 = new Thread(myTicket,"一号窗口");
        Thread t2 = new Thread(myTicket,"二号窗口");
        Thread t3 = new Thread(myTicket,"三号窗口");
        Thread t4 = new Thread(myTicket,"四号窗口");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("------------------------");

        /**
         * 2.一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
         要求:请用多线程模拟领票过程并打印剩余电影票的数量
         */
//        Ticket ticket = new Ticket();
//        Thread t2 = new Thread(ticket);
//        t2.start();

    }
}

class MyTicket implements Runnable {
    private int num = 0;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (num == 100) {
                break;
            }
            num++;
            if (num == 10){
                if (!Thread.currentThread().getName().equals("三号窗口")) {
                    num--;
                    lock.unlock();
                    continue;
                }else {
                    System.out.println(Thread.currentThread().getName() + "售票，" + " 票号为 " + num + "，剩余" + (100 - num) + "张票");
                }
            }else {
                System.out.println(Thread.currentThread().getName() + "售票，" + " 票号为 " + num + "，剩余" + (100 - num) + "张票");
            }

            lock.unlock();
        }
    }
}

class Ticket implements Runnable {
    private int num = 100;


    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println((int) (Math.random() * 2 + 1) + "号窗口售票，" + " 票号为 " + num + " 剩余票数为：" + (num - 1));
            num--;
        }
    }
}
