package homework._thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo08 {
    public static void main(String[] args) {
        /**
         * 同时开启两个线程，共同输出1-100之间的所有数字，并且将输出奇数的线程名称打印出来

         */
        CountNum c = new CountNum();
        Thread t1 = new Thread(c,"线程1");
        Thread t2 = new Thread(c,"线程2");
        t1.start();
        t2.start();
    }
}

class CountNum implements Runnable {

    int i = 1;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (i % 2 != 0)
            {
                System.out.print(Thread.currentThread().getName());
            }
                System.out.println(i);
            if (i == 100){
                break;
            }
            i++;
            lock.unlock();
        }
    }
}