package homework.practice06;

import homework.practice03.flower.Rose;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * 定义一个功能  随机产生红号(1-35 选6个 不能重复)  蓝号(1-15  选1) 蓝号可以与红号重复
 * 一等奖   6红  + 1蓝
 * 二等奖   6红/5红  + 1蓝
 * 三等奖   4红  +  1蓝
 * 四等奖  5红
 * 五等奖 3红 + 1蓝
 * 六等奖  1蓝
 * 未中奖
 */
public class Lottery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        HashSet<Integer> redNum = createNumber();
        System.out.println(redNum);
        int blueNum = r.nextInt(15 + 1);
        int redCount = userPutRedNumber(redNum);
        System.out.println("请输入一个预期蓝号号码（1-15）");
        int blueGuess = sc.nextInt();
        int blueCount = 0;
        if (blueGuess == blueNum) {
            blueCount++;
        }
//         * 一等奖   6红  + 1蓝
//                * 二等奖   6红/5红  + 1蓝
//                * 三等奖   4红  +  1蓝
//                * 四等奖  5红
//                * 五等奖 3红 + 1蓝
//                * 六等奖  1蓝
//                * 未中奖
        System.out.println("红号中奖号码为：" + redNum);
        System.out.println("蓝号中奖号码为：" + blueNum);
        System.out.println("-------------------------");
        System.out.println("你的红号个数为：" + redCount);
        System.out.println("你的蓝号个数为：" + blueCount);
        System.out.println("-------------------------");
        System.out.println("中奖规则如下");
        System.out.println("一等奖  6红 + 1蓝\n" +
                "二等奖  6红/ 5红 + 1蓝\n" +
                "三等奖  4红 + 1蓝\n" +
                "四等奖  5红\n" +
                "五等奖  3红 + 1蓝\n" +
                "六等奖  1蓝\n" +
                "未中奖");
        System.out.println("-------------------------");
        if (redCount == 6 && blueCount == 1) {
            System.out.println("恭喜您获得一等奖");
        } else if (redCount == 0 && blueCount == 1) {
            System.out.println("恭喜您获得六等奖");
        }else if (redCount == 3 && blueCount == 1) {
            System.out.println("恭喜您获得五等奖");
        }else if (redCount == 5 && blueCount == 0) {
            System.out.println("恭喜您获得四等奖");
        }else if (redCount == 4 && blueCount == 1) {
            System.out.println("恭喜您获得三等奖");
        }else if (redCount == 6 || (redCount == 5 && blueCount == 1)){
            System.out.println("恭喜您获得二等奖");
        }else {
            System.out.println("很遗憾您中奖，谢谢参与");
        }

    }

    public static HashSet<Integer> createNumber() {
        HashSet<Integer> set = new HashSet<>();
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int redNumber = r.nextInt(35) + 1;
            if (!isRepeat(set, redNumber)) {
                set.add(redNumber);
                i++;
            }
        }
        return set;
    }

    public static int userPutRedNumber(HashSet<Integer> redSet) {
        System.out.println("请输入六个不同的预期红号号码（1-35）");
        int count = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            if (isRepeat(redSet, sc.nextInt())) {
                count++;
            }
        }
        return count;
    }

    public static boolean isRepeat(HashSet<Integer> arr, int a) {
        for (int i : arr
        ) {
            if (i == a) {
                return true;
            }
        }
        return false;
    }
}
