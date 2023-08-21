package homework;

import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
//        需求：我有如下一个字符串:”91 27 46 38 50”，请写代码实现最终输出结果是：”27 38 46 50 91”
        String str = "91 27 46 38 50";
        String[] str1 = str.split(" ");
//        System.out.println(Arrays.toString(str1));
        int arr[] = new int[str1.length];
        for (int i = 0; i < str1.length; i++) {
            arr[i] = Integer.parseInt(str1[i]);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

//        * 需求：定义一个功能：校验一串字符串中是否是qq号码
//                * 		1.要求必须是5-15位数字
//                * 		2.0不能开头
//                * 		3.必须都是数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入qq号码");
        String qq = sc.next();
        System.out.println(qq.matches("[1-9]\\d{4,14}"));
//        if (qq.startsWith("0")) {
//            System.out.println("qq号码不能以0开头");
//        } else if (qq.length() < 5 || qq.length() > 15) {
//            System.out.println("qq号必须是5-15位数字");
//        } else if (!qq.matches("[0-9]+")) {
//            System.out.println("qq必须都为数字");
//        }
//        else{
//            System.out.println("您的qq号为" + qq);
//        }

    }
}
