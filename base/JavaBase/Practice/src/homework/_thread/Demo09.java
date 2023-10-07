package homework._thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Demo09 {
    public static void main(String[] args) {

        /**
         *3.有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
         创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:


         抽奖箱1 又产生了一个 10 元大奖
         抽奖箱2 又产生了一个 100 元大奖
         */
        Lottery lottery = new Lottery();
        Thread t1 = new Thread(lottery, "抽奖箱1");
        Thread t2 = new Thread(lottery, "抽奖箱2");
        t1.start();
        t2.start();

    }
}

class Lottery implements Runnable {
    int[] arr = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300};
    int count = 0;
    ReentrantLock lock = new ReentrantLock();
    Random r = new Random();

    @Override
    public void run() {
        while (count <= arr.length) {
            lock.lock();
            int i = r.nextInt(arr.length);
            if (arr[i] != 0) {
                count++;
                System.out.println(Thread.currentThread().getName() + " 又产生了一个 " + arr[i] + " 元大奖");
                arr[i] = 0;
            }
            lock.unlock();
        }
    }
}
