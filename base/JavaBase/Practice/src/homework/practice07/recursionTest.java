package homework.practice07;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;


public class recursionTest {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        1.需求:从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.txt文件名
//        2.* 需求:从键盘接收一个文件夹路径,统计该文件夹下所有文件的大小
//        File file = new File("src/homework/practice07");
//        File[] list = file.listFiles();
//        for (File f : list) {
//            if (f.isFile() && f.getName().endsWith(".txt")) {
//                System.out.println("文件名: " + f.getName() + "    文件大小:" + f.length());
//            }
//        }


//        3.* 需求:从键盘接收一个文件夹路径,删除该文件夹
//        System.out.println("请输入要删除文件夹的路径");
//        String path = sc.next();
//        file = new File(path);
//        if (file.isDirectory()) {
//            delDir(file);
//        } else {
//            System.out.println("该路径不是一个文件夹");
//        }


//        4. 需求:从键盘接收两个文件夹路径,把其中一个文件夹中(全部内容)拷贝到另一个文件夹中
//        System.out.println("请输入要拷贝的文件夹路径");
//        path = sc.next();
//        System.out.println("请输入目标路径");
//        String toPath = sc.next();
//        copyFile(path, toPath);
//        5.需求：用递归求出10的阶乘
//        System.out.println("请输入数字求其阶乘");
//        int n = sc.nextInt();
//        int sum = getMul(n);
//        System.out.println(n + "的阶乘为" + sum);
//        6. 需求:求出1000的阶乘所有零和尾部零的个数,不用递归做
//        System.out.println("所有零的个数为:" + demo01());
//        System.out.println("尾部零的个数为:" + demo02());
//        7. 需求:求出1000的阶乘尾部零的个数,用递归做
//        System.out.println("尾部零的个数为:" + fun(1000));
//        8.假设一对刚出生的小兔一个月后就能长成大兔，再过一个月就能生下一对小兔，并且此后每个月都生一对小兔，一年内没有发生死亡，
//        问：一对刚出生的兔子，一年内繁殖成多少对兔子?
        System.out.println("请输入月份查看兔子数量");
        int r = sc.nextInt();
        System.out.println("第" + r + "个月的兔子对数为" + getRabbitNumber(r));
//        9.有一个牢房,里面关着N个犯人,有一天遇国王巡视,将所有犯人召集一处,围成一圈,从侍卫旁边的犯人开始报数,
//        遇到3的倍数就杀掉,直至最后只剩一个犯人.假设现在牢房中共有30个犯人,求出最后存活的犯人的幸运数字
        System.out.println("请输入犯人个数");
        int num = sc.nextInt();
        int[] prisoner = new int[num];
        for (int i = 0; i < num; i++) {
            prisoner[i] = i + 1;
        }
        int count = 0;
        System.out.println(luckyNum(prisoner, num, count));
    }

    // 删除文件夹
    public static void delDir(File file) {
        Scanner sc = new Scanner(System.in);
        String name = file.getName();
        File[] files = file.listFiles();
        if (files.length == 0) {
            file.delete();
            System.out.println(name + "文件夹已删除");
        } else {
            System.out.println("文件夹内还有文件，是否全部删除？Y/N");
            String flag = sc.next();
            if (flag.equals("Y") || flag.equals("y")) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        delDir(f);
                    } else {
                        System.out.println(f.getName() + "文件已删除");
                        f.delete();
                    }
                }
                file.delete();
                System.out.println(name + "文件夹已删除");
            } else {
                System.out.println("删除失败");
            }
        }
    }

    // 拷贝文件夹
    public static void copyFile(String path, String toPath) throws IOException {
        File file = new File(path);
        File toFile = new File(toPath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            toFile.mkdir();
            if (files.length != 0) {
                for (File f : files) {
//                    System.out.println(f.getName() + 1);
                    if (f.isDirectory()) {
//                        System.out.println(f.getName() + 3);
                        copyFile(f.getPath(), toFile + "/" + f.getName());
                    } else {
//                        System.out.println(toFile.getName() + 2);
                        BufferedReader br = new BufferedReader(new FileReader(f.getPath()));
                        BufferedWriter bw = new BufferedWriter(new FileWriter(toPath + "/" + f.getName()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            bw.write(line);
                            bw.newLine();
                            bw.flush();
                        }
                        br.close();
                        bw.close();
                    }
                }
            }

        }

    }

    // 计算 n!
    public static int getMul(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * getMul(num - 1);
        }
    }

    // 求1000的阶乘中所有的零(非递归)
    public static int demo01() {
        BigInteger bi1 = new BigInteger("1");
        for (int i = 1; i <= 1000; i++) {
            BigInteger bi2 = new BigInteger(i + "");
            bi1 = bi1.multiply(bi2);
        }
        String str = bi1.toString();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('0' == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    // 求1000的阶乘中尾部有多少个零(非递归)
    public static int demo02() {
        BigInteger bi1 = new BigInteger("1");
        for (int i = 1; i <= 1000; i++) {
            BigInteger bi2 = new BigInteger(i + "");
            bi1 = bi1.multiply(bi2);
        }
        String str = bi1.toString();
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('0' != str.charAt(i)) {
                break;
            } else {
                count++;
            }
        }

        return count;
    }

    // 求1000的阶乘中尾部零的个数(递归）
    public static int fun(int num) {
        if (num > 0 && num < 5) {
            return 0;
        } else {
            return num / 5 + fun(num / 5);
        }
    }

    // 兔子个数
    public static int getRabbitNumber(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return getRabbitNumber(month - 1) + getRabbitNumber(month - 2);
        }
    }

    // 犯人幸运数字
    public static int luckyNum(int[] sum, int num,int count) {
        if (num == 1) {
            return sum[0];
        } else {
            int[] lucky = new int[num];
            int index = 0;
            for (int i = 0; i < num; i++) {
                count++;
                if (count % 3 != 0){
                    lucky[index++] = sum[i];
                }
            }
            return luckyNum(lucky,index, count);
        }
    }
}
