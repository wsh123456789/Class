package homework._thread;

//模拟生产者与消费者,
//        * 例:控制台交替输出:生产康师傅方便面面,消费康师傅方便面,生产娃哈哈矿泉水,消费娃哈哈矿泉水,以此类推…
public class Demo02 {
    public static void main(String[] args) {
        new Thread(new Runnable(){

            @Override
            public void run() {
                while (true) {
                    System.out.println("生产康师傅方便面");
                    System.out.println("消费康师傅方便面");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){

            @Override
            public void run() {
                while (true) {
                    System.out.println("生产娃哈哈矿泉水");
                    System.out.println("消费娃哈哈矿泉水");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

}
