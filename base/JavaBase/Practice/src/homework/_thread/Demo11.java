package homework._thread;

public class Demo11 {
    public static void main(String[] args) {
        /**
         * 写一个线程类MyThread，该线程实现了Runnable接口，写一个main方法，
         用for循环创建5个线程对象。需求如下：
         ① 利用线程类的构造函数输出："创建线程4"。
         （备注：当创建一个线程的时候，标记为1，再次创建一个线程的时候，标记为2，
         所以输出的"创建线程4"就是创建的第四个线程）
         ② 在run方法中输出：“线程X ：计数Y”，当执行次数达到6次的时候，退出。
         （备注：其中“线程X”为第X个线程，“计数Y”为该线程的run方法执行了多少次）
         */
        for (int i = 1; i < 6; i++) {
            new Thread(new MyThread1(),"线程" + i).start();
        }
    }
}

class MyThread1 implements Runnable {
    int count = 1;

    @Override
    public void run() {
        while (count < 6) {
            System.out.println(Thread.currentThread().getName() + " : 计数" + count);
            count++;
        }
    }
}
