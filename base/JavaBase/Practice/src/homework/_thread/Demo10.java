package homework._thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo10 {
    public static void main(String[] args) {

        /**
         * 有100个包,网店和实体店同时卖,输出格式xx店,卖出第**个,还剩**个

         */
        Bag bag = new Bag();
        Thread t1 = new Thread(bag,"实体店");
        Thread t2 = new Thread(bag,"网店");
        t1.start();
        t2.start();

    }
}
class Bag implements Runnable {
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    ReentrantLock lock =  new ReentrantLock();
    @Override
    public void run() {

        while (true){
            lock.lock();
            if (count == 100) {
                break;
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "卖出第" + count + "个包, 还剩余" + (100 - count) + "个包");
            if (Thread.currentThread().getName().equals("网店")){
                count1++;
                Thread.yield();
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
        System.out.println("网店卖出了"+ count1 + "个杯子");
        System.out.println("实体店卖出了"+ count2 + "个杯子");

    }
}
