package homework._thread;

public class Demo03 {
    /**
     * 模拟生产者与消费者,
     * 例:控制台交替输出:生产康师傅方便面面,消费康师傅方便面,生产娃哈哈矿泉水,消费娃哈哈矿泉水,以此类推…
     *
     * @param args
     */


    public static void main(String[] args) {
        Goods goods = new Goods();
        new Thread() {
            public void run() {
                for (int i = 0; ; i++) {
                    if (i % 2 == 0)
                        goods.product("康师傅", "方便面");
                    else
                        goods.product("娃哈哈", "矿泉水");
                }
            }
        }.start();
        new Thread() {
            public void run() {
                while (true)
                    goods.consume();
            }
        }.start();
    }

}


class Goods {
    private int lock = 1;
    private String brand;
    private String name;

    public void product(String brand, String name) {
        synchronized (this) {
            if (lock != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.brand = brand;
            this.name = name;
            System.out.println("生产" + this.brand + this.name);

            lock = 2;
            this.notify();
        }
    }

    public void consume() {
        synchronized (this) {
            if (lock != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("消费" + this.brand + this.name);

            lock = 1;
            this.notify();
        }
    }
}
