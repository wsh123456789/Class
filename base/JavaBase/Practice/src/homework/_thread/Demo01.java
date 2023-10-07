package homework._thread;

//需求
//        *有一个合唱团，A队演唱<喜羊羊>，B队演唱<隔壁泰山>，C队演唱<翠花>要求 任务交替执行  123123123123123123...
public class Demo01 {
    public static void main(String[] args) {
        new Thread(new Runnable(){

            @Override
            public void run() {
                while (true) {
                    System.out.println("喜羊羊");
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
                    System.out.println("隔壁泰山");
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