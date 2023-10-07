package homework._thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        int N = 3;
        CountDownLatch countDownLatch = new CountDownLatch(N);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D 等待执行中...");
                try {
                    countDownLatch.await();
                    System.out.println("D 开始执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + " 正在执行");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + " 执行完毕");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
