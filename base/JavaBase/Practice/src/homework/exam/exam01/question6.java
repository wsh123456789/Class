package homework.exam.exam01;

import java.util.Scanner;

public class question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] str2 = {"圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟"};
        char[] ch = sc.next().toCharArray();
        int len;
        for (int i = ch.length - 1; ; i--){
            if (ch[i] != '0'){
                len = i + 1;
                break;
            }
        }
        StringBuffer str3 = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int index1 = ch[i] - '0';
//            System.out.println("1" + index1);
            str3.append(str1[index1]);
            if (ch[i] != '0'){
                int index2 = ch.length - i - 1 ;
//                System.out.println("2" + index2);
                str3.append(str2[index2]);
            }
        }
        if (len == ch.length)
        {
            System.out.println(str3);
        }else {
            System.out.println(str3 + "圆");
        }

    }

}
