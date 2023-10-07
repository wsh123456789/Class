package com.demo._thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread demoThread = new Thread("测试");
        myThread.setName("线程1");
        Thread thread = new Thread(new MyRunnable(),"线程2");

        myThread.start();
        thread.start();

        // 通过匿名函数实现多线程
        // 继承方式的匿名
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "---->" + i);
                }
            }
        }.start();

        // 实现接口方式的匿名
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "---->" + i);
                }
            }
        }).start();

        // start(): ①启用线程 ②调用线程的run();
        // run() : 将线程要执行的操作，声明在run()中
        // currentThread() : 获取当前执行代码对应的线程
        // getName()/setName() : 获取或设置线程名
        // sleep(long millis): 静态方法，调用时可以使得当前线程睡眠指定的毫秒数
        // yield() : 静态方法，一旦执行此方法， 就释放CPU执行权
        // join() : 在线程a中通过线程b调用join(), 意味着a进入阻塞状态，知道线程b执行结束，线程a才结束阻塞状态，继续执行
        // isAlive() : 判断当前线程是否存活
        // getPriority() : 获取当前优先级
        // setPriority() : 设置优先级(1 - 10)
        // MAX_PRIORITY(10): 最高级
        // MIN_PRIORITY(1) : 最低级
        // NORM_PRIORITY(5) : 普通优先级，默认情况下main线程具有普通优先级
        // wait() : 让程序等待，可传参设置等待时间
        // notify() : 唤醒当前等待线程
        // notifyAll() : 唤醒所有等待线程
        // 创建锁对象
        // ReentrantLock lock = new ReentrantLock();
        // lock.lock(); 上锁
        // 中间为执行代码
        // lock.unlock(); 解锁


    }
}

// 通过继承Thread实现多线程
class MyThread extends Thread{
    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
          System.out.println(Thread.currentThread().getName() + "---->" + i);
      }
    }
}


// 通过实现接口实现多线程
class MyRunnable implements Runnable {

    @Override
    public void run() {
        // 实现同步的第一种方法 (同步代码块)    synchronized (this) this代表锁 ，锁相同的代码同步执行
        // 第二种方法： 对执行方法用 synchronized修饰  public synchronized void run() 默认锁为this类
        // 第三种方法： 对执行方法用 static synchronized修饰  public static synchronized void run() 默认锁为字节码对象class文件（运行时类）
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "---->" + i);
            }
        }

    }
}
