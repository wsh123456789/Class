package homework._thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo07 {
    public static void main(String[] args) {

        /**
         * 2.有一辆班车除司机外只能承载80个人，假设前中后三个车门都能上车，如果坐满则不能再上车。
         * 请用线程模拟上车过程并且在控制台打印出是从哪个车门上车以及剩下的座位数。比如:（前门上车---还剩N个座...）

         */
        Bus bus = new Bus();
        Thread t1 = new Thread(bus, "前门");
        Thread t2 = new Thread(bus, "中门");
        Thread t3 = new Thread(bus, "后门");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Bus implements Runnable{
    int count = 1;
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            if (count == 80) {
                break;
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "上车坐在第" + count + "个座位, 还剩余" + (80 - count) + "个座位");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.unlock();
        }
    }
}
