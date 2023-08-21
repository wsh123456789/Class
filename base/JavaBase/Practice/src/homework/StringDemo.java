package homework;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
//		1. 需求：模拟登录,给三次机会,并提示还有几次。
//		* 用户名和密码都是admin
        demo1();
//
//
//	2.需求：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数,其他字符出现的次数。
//		* ABCDEabcd123456!@#$%^
        demo2();
//
//
//	3.把一个字符串的首字母转成大写，其余为小写  例: "sdjFdC"==>"Sdjfdc"
        demo3();
//
//
//	4. 需求：把数组中的数据按照指定格式拼接成一个字符串
//			* 举例：
//				* int[] arr = {1,2,3};
//			* 输出结果：
//				* "[1, 2, 3]"
        demo4();


//	5.需求：把字符串反转
//			* 举例："abc"
//			* 输出结果："cba"
        demo5();
        System.out.println();
//	6.*需求：统计大串中小串出现的次数
//		* 这里的大串和小串可以自己根据情况给出
//	大串:Uihfouf09ew8934AAAAugvoiAAAAkjfo[jfAAAAu4jki[AAAA-wiff
//	小串:AAAA
//	统计小串出现的次数
        demo6();
		/*String s = "Uihfouf09ew8934AAAAugvoiAAAAkjfo[jfAAAAu4jki[AAAA-wiff ";
		String min = "AAAA";
		System.out.println(s.indexOf(min));*/

    }

    private static void demo6() {
//		6.*需求：统计大串中小串出现的次数
//		* 这里的大串和小串可以自己根据情况给出
//	大串:Uihfouf09ew8934AAAAugvoiAAAAkjfo[jfAAAAu4jki[AAAA-wiff
//	小串:AAAA
//	统计小串出现的次数
        String s = "Uihfouf09ew8934AAAAugvoiAAAAkjfo[jfAAAAu4jki[AAAA-wiff ";
        String min = "AAAA";
        int count = 0;
        while (s.contains(min)) {
            count++;
            s = s.substring(s.indexOf(min) + min.length());
        }
        System.out.println(count);

    }

    private static void demo5() {
//		5.需求：把字符串反转
//		* 举例："abc"
//		* 输出结果："cba"
        String s = "abc";
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            System.out.print(c[i]);
        }

    }

    private static void demo4() {
//		4. 需求：把数组中的数据按照指定格式拼接成一个字符串
//		* 举例：
//			* int[] arr = {1,2,3};
//		* 输出结果：
//			* "[1, 2, 3]"
        int[] arr = {1, 2, 3};
        StringBuffer s = new StringBuffer();
        s.append("\"[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s.append(arr[i]).append("]\"");
            } else {
                s.append(arr[i]).append(", ");
            }
        }
        System.out.println(s);

    }

    private static void demo3() {
//		3.把一个字符串的首字母转成大写，其余为小写  例: "sdjFdC"==>"Sdjfdc"
        String s = "sdjFdC";
        System.out.println(s.substring(0, 1).toUpperCase().concat(s.toLowerCase().substring(1)));
    }

    private static void demo2() {
//		2.需求：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数,其他字符出现的次数。
//		* ABCDEabcd123456!@#$%^
        String s = "ABCDEabcd123456!@#$%^";
        char[] c = s.toCharArray();
        int da, xiao, shu, qi;
        da = xiao = shu = qi = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                xiao++;
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                da++;
            } else if (c[i] >= '0' && c[i] <= '9') {
                shu++;
            } else qi++;
        }
        System.out.println("大写字母字符为：" + da);
        System.out.println("小写字母字符为：" + xiao);
        System.out.println("数字字符为：" + shu);
        System.out.println("其他字符为：" + qi);

    }

    private static void demo1() {
//		1. 需求：模拟登录,给三次机会,并提示还有几次。
//		* 用户名和密码都是admin
        Scanner sc = new Scanner(System.in);
        String s = "admin";
        int i = 3;
        while (i > 0) {
            System.out.println("请输入用户名:");
            String user = sc.next();
            System.out.println("请输入密码：");
            String pw = sc.next();
            if (user.equals(s) && pw.endsWith(s)) {
                System.out.println("登录成功！");
                break;
            }
            i--;
            if (i == 0) {
                System.out.println("登陆失败");
            } else {
                System.out.println("用户名或者密码错误，请重新输入！");
                System.out.println("您还有" + i + "次机会");
            }

        }
    }
}



