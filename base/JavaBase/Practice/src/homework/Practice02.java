package homework;

import java.util.Arrays;
import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
//        1、求数组中的最大值、最小值
        int[] a = new int[]{1, 5, 9, 10, 8};
        Arrays.sort(a);
        System.out.println("最小值为" + a[0] + "最大值为" + a[a.length - 1]);
//        2、根据用户键盘录入的数，查询数组的索引。如果数字不存在，应返回-1
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的数字");
        int select = sc.nextInt();
        int flag = -1;
        for (int i = 0; i <= a.length; i++) {
            if (a[i] == select) {
                flag = i;
                break;
            }
        }
        if (flag == -1) {
            System.out.println("数组不存在");
        } else {
            System.out.println("数组索引为" + flag);
        }

//        3、定义一个数组，遍历数组后，并求出所有元素的和
        int num = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            System.out.print(a[i] + "\t");
            num += a[i];
        }
        System.out.println("\n数组元素总和为" + num);
//
//        4、定义一个数组，并将数组进行反转，要求输出反转前后的结果，
        System.out.println(Arrays.toString(a));
        for (int i = 0; i <= (a.length - 1) / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(a));
//
//
//        5、有同一类型的 数组a 和 数组b ，两个数组存放的元素个数不同。最后把两个数组合并到一个数组中，进行排序
        int[] b = new int[]{7, 9, 99, 67, 42, 86};
        int[] arr = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, arr, a.length, b.length);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

//        1、定义第一个方法 getArray, 功能是：
//        键盘录入5个学生，并返回结果
        String[] stu = getArray();
        System.out.println(Arrays.toString(stu));
//        定义第二个方法 getTopic , 功能是：
//        在其中定义一个数组，里面存着五道题。
//        随机出1位同学，并随机出3道题。（要求题目不一样）
        getTopic(stu);

//        2、猜数字
//        电脑随机生成一个1-100之间的数字，用户猜数字，猜中之后提示“恭喜您	，猜中了，一共猜了几次”。如果没猜中，则猜数范围发生对应的变化。
        int r = (int) (Math.random() * 101);
        int count = 1;
        while (true) {
            System.out.println("请输入第" + count + "猜测的数字");
            int guess = sc.nextInt();
            if (guess == r) {
                System.out.println("恭喜你猜对了，数字为" + r + "一共猜了" + count + "次");
                break;
            } else if (guess > r) {
                System.out.println("猜大了，请重新猜测");
            } else {
                System.out.println("猜小了，请重新猜测");
            }
            count++;
        }
//        3、猜拳
//        从控制台输入要出的拳 ——石头（0）／剪刀（1）／布（2） 输入-2退出
//        电脑 随机 出拳
//                比较胜负
        while (true) {
            r = (int) (Math.random() * 3);
            String[] content = new String[]{"石头", "剪刀", "布"};
            System.out.println("请做出你的选择：(石头（0）／剪刀（1）／布（2） 输入-2退出)");
            int guess = sc.nextInt();
            if (guess == -2) {
                System.out.println("退出成功");
                break;
            } else if (guess == r) {
                System.out.println("您的决定为" + content[guess] + "\n电脑决定为" + content[r] + "\n平局");
            } else if (guess - r == -1 || guess - r == 2) {
                System.out.println("您的决定为" + content[guess] + "\n电脑决定为" + content[r] + "\n您赢了");
            } else {
                System.out.println("您的决定为" + content[guess] + "\n电脑决定为" + content[r] + "\n您输了");
            }

        }

//        6.1案例：公司年销售额求和
//        某公司按照季度和月份统计的数据如下：单位(万元)
//        第一季度：22,66,44
//        第二季度：77,33,88
//        第三季度：25,45,65
//        第四季度：11,66,99
        int[][] money = {{22, 66, 44}, {77, 33, 88}, {25, 45, 65}, {11, 66, 99}};
        int sum = 0;
        for (int i = 0; i < money.length; i++) {
            for (int j = 0; j < money[i].length; j++) {
                sum += money[i][j];
            }
        }
        System.out.println("销售总额为" + sum);


    }

    public static String[] getArray() {
        String[] stu = new String[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "名学生姓名");
            stu[i] = sc.next();
        }
        return stu;
    }

    public static void getTopic(String[] stu) {
        String[] question = new String[]{"题目1", "题目2", "题目3", "题目4", "题目5"};
        int[] arr = new int[question.length];
        System.out.println("回答问题的同学为:" + stu[(int) (Math.random() * 5)]);
        for (int i = 0; i < 3; i++) {
            int r = (int) (Math.random() * 5);
            if (arr[r] == 1) {
                i--;
                continue;
            } else {
                System.out.println(question[r]);
                arr[r] = 1;
            }
        }
    }
}
