package homework._thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(7);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setMaximumPoolSize(50);
        for (int i = 0; i < 10; i++){
            service.execute(new MyThread());
            Thread.sleep(1000);
        }
        service.shutdown();

    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        Date date = new Date();
        long time = date.getTime();
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        System.out.println(Thread.currentThread().getName() + "-->" +sfd.format(time));

    }
}