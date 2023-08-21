package homework;


import java.util.Random;

public class Test {

    public static void main(String[] arg) {
        // 种子值相同的生成的随机数序列也相同
        Random r1 = new Random(1);
        for (int i = 0; i < 8; i++) {
            System.out.println(r1.nextInt(20));
        }
        System.out.println("----------------------------");
        Random r2 = new Random(1);
        for (int i = 0; i < 5; i++) {
            System.out.println(r2.nextInt(20));
        }
    }
}

