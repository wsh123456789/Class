package homework._thread;

import java.util.Random;

public class Demo04 {
    /**
     * 公司组织出游活动,活动 有:"活动A","活动B","活动C","活动D",分为两个小队,飞虎队和凤凰队
     * 两个小队从活动中随机抽取2项活动,并在控制台中输出4次
     * 输出格式:xx小分队 选择 xx活动

     */
    public static void main(String[] args) {
        Activity activity = new Activity();
        new Thread() {
            @Override
            public void run() {
                try {
                    activity.fHD();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    activity.FhD();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }
}

class Activity{

    int flag = 1;
    String[] activities = {"活动A", "活动B", "活动C", "活动D"};
    Random r = new Random();

    public void fHD() throws InterruptedException {
        System.out.println("飞虎队选择 " + activities[r.nextInt(4)]);
        Thread.sleep(10);
        System.out.println("飞虎队选择 " + activities[r.nextInt(4)]);
    }
    public void FhD() throws InterruptedException {
        System.out.println("凤凰队选择 " + activities[r.nextInt(4)]);
        Thread.sleep(10);
        System.out.println("凤凰队选择 " + activities[r.nextInt(4)]);
    }

}
