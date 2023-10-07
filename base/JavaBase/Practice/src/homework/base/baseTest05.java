package homework.base;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class baseTest05 {
    public static void main(String[] args) throws IOException {
//     【程序41】
//        题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
//        第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
//        fun41();
//     【程序42】
//        题目：809*??=800*??+9*??+1
//        其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。
//        fun42();
//     【程序43】
//        题目：求0—7所能组成的奇数个数。
        fun43(7);
//     【程序44】
//        题目：一个偶数总能表示为两个素数之和。
//        fun44(2);
//     【程序45】
//        题目：判断一个素数能被几个9整除
//        fun45(107);
//     【程序46】
//        题目：两个字符串连接程序
//        fun46("aa","bb");
//     【程序47】
//        题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。
//        fun47(10);
//     【程序48】
//        题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，
//        加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。
//        fun48(6789);
//     【程序49】
//        题目：计算字符串中子串出现的次数
        fun49("aabbccaaadaa","aa");
//     【程序50】
//        题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
//        计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。
//        fun50();

    }


    // 题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
    // 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
    private static void fun41() {
        double peach = 0;
        // 假设i是第五个猴子拿拿完剩余的桃子数
        for (int i = 4; i < 10000; i += 4) {
            int count = 0;

            peach = i;
            // 前一只猴子剩下的四堆桃子数
            for (int k = 0; k < 4; k++) {
                peach = peach / 4 * 5 + 1;
                // 判断能否等分成四份，如果不是说明桃子数有误
                if (peach % 4 == 0)
                    count++;
                else
                    break;
            }
            if (count == 4) {
                System.out.println("原有桃子 " + (peach / 4 * 5 + 1) + " 个");
                break;
            }
        }

    }

    // 题目：809*??=800*??+9*??+1
    // 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。
    private static void fun42() {
        int flag = 0;
        for (int i = 10; i <= 100; i++) {
            if (((809 * i) == (800 * i + 9 * i + 1)) && (8 * i < 100) && (9 * i >= 100)) {
                System.out.println(i);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("此数不存在");
        }
    }

    // 求0—7所能组成的奇数个数。
    private static void fun43(double n) {
        n++;
        int num = (int) Math.ceil(n / 2);
        System.out.println("0~7组成1位数，有：" + num + "个");
        // 记录总数
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int total = (int) ((n - 1) * Math.pow(n, i) * num);
            System.out.println("0~7组成" + (i + 2) + "位数，有：" + total + "个");
            count += total;
        }
        System.out.println(count + num);
    }

    // 一个偶数总能表示为两个素数之和。
    private static void fun44(int n) {
        if (n % 2 != 0 && n != 1) {
            System.out.println("此数不符合规范");
        } else {
            for (int i = 2; i < n / 2 + 1; i++) {
                if (isPrime(i) && isPrime(n - i)) {
                    System.out.println(n + "符合要求:" + n + " = " + i + " + " + (n - i));
                    break;
                }
            }
        }
    }

    // 判断是不是素数
    private static boolean isPrime(int n) {
        boolean flag = true;

        if (n > 2) {
            for (int i = 2; i < Math.sqrt(n) + 1; i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    // 判断一个素数能被几个9整除
    private static void fun45(int n) {
        int num = n;
        // 记录数量
        int count = 0;
        if (!isPrime(n)) {
            System.out.println(n + "不是素数");
        } else {
            while (n > 8) {
                n /= 9;
                count++;
            }
            System.out.println(num + "能被" + count + "个9整除");
        }
    }

    // 两个字符串连接程序
    private static void fun46(String s1, String s2) {
        String s3 = s1.concat(s2);
        System.out.println(s3);
    }

    // 读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。
    private static void fun47(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }

    // 加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。
    private static void fun48(long n) {
        String[] s = String.valueOf(n).split("");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = (Integer.parseInt(s[i]) + 5) % 10;
        }
        int temp = arr[0];
        arr[0] = arr[3];
        arr[3] = temp;
        temp = arr[1];
        arr[1] = arr[2];
        arr[2] = temp;
        System.out.println(Arrays.toString(arr));

    }

    // 计算字符串中子串出现的次数
    private static void fun49(String s1, String s2) {
        int len = s2.length();
        int count = 0;
        while (true){
            if (s1.contains(s2)) {
                count++;
                int index = 0;
                index = s1.indexOf(s2, index) + len;
                if (s1.length() - index >= len){
                    s1 = s1.substring(index);
                }else {
                    break;
                }
            }
        }
        System.out.println(count);
    }

    // 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
    // 计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。
    private static void fun50() throws IOException {
        Scanner sc = new Scanner(System.in);
        TreeSet<Student> treeSet = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            Student stu = new Student();
            System.out.println("请输入第" + (i + 1) + "个学生的学号");
            stu.setId(sc.nextInt());
            System.out.println("请输入第" + (i + 1) + "个学生的姓名");
            stu.setName(sc.next());
            System.out.println("请输入第" + (i + 1) + "个学生的语文成绩");
            stu.setChinese(sc.nextDouble());
            System.out.println("请输入第" + (i + 1) + "个学生的数学成绩");
            stu.setMath(sc.nextDouble());
            System.out.println("请输入第" + (i + 1) + "个学生的英语成绩");
            stu.setEnglish(sc.nextDouble());
            stu.setScore();
            treeSet.add(stu);
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/homework/base/stud.txt"));
        for (Student stu : treeSet) {
            bw.write(stu.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

}

// 学生类
class Student implements Comparable<Student> {

    private Integer id;
    private String name;
    private double chinese;
    private double math;
    private double english;

    private double score;

    public Student() {
    }

    public Student(Integer id, String name, double chinese, double math, double english) {
        this.id = id;
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public void setScore() {
        score = (chinese + english + math) / 3;
    }

    public double getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return -Double.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                ", score=" + score +
                '}';
    }


}
