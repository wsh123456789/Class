package homework._thread;

public class classDemo {
    /*
     * 需求
     *有一个合唱团，A队演唱<喜羊羊>，B队演唱<隔壁泰山>要求 任务交替执行  121212121212...
     *
     *需求
     *有一个合唱团，A队演唱<喜羊羊>，B队演唱<隔壁泰山>，C队演唱<翠花>要求 任务交替执行  123123123123123123...
     */

    public static void main(String[] args) {

        Sing s = new Sing();

        new Thread("A队") {
            public void run() {
                while (true) {
                    try {
                        s.XYY();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }

            ;
        }.start();

        new Thread("B队") {
            public void run() {
                while (true) {
                    try {
                        s.GBTS();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }

            ;
        }.start();

        new Thread("C队") {
            public void run() {
                while (true) {
                    try {
                        s.CH();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }

            ;
        }.start();


    }

}

class Sing {

    int flag = 1;

    public synchronized void XYY() throws Exception {
        while (flag != 1) {
            this.wait();
        }
        System.out.print("喜");
        System.out.print("羊");
        System.out.print("羊");
        System.out.println();

        Thread.sleep(50);

        flag = 2;

//		this.notify();
        this.notifyAll();

    }

    public synchronized void GBTS() throws Exception {
        while (flag != 2) {
            this.wait();
        }

        System.out.print("隔");
        System.out.print("壁");
        System.out.print("泰");
        System.out.print("山");
        System.out.println();

        Thread.sleep(50);

        flag = 1;

//		this.notify();
        this.notifyAll();

    }

    public synchronized void CH() throws Exception {
        while (flag != 3) {
            this.wait();
        }

        System.out.print("翠");
        System.out.print("花");
        System.out.println();

        Thread.sleep(50);

        flag = 1;

//		this.notify();
        this.notifyAll();

    }

}
