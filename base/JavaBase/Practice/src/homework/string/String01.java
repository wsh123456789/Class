package homework.string;

import java.io.*;
import java.util.*;

public class String01 {
    private static char[] is;
    private static int total;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        /**
         * 输入一个数字,输出为多少元,例如输入10200,输出壹万零贰佰元

         */
//        String[] str1 = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
//        String[] str2 = {"圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟"};
//        char[] ch = sc.next().toCharArray();
//        int len;
//        for (int i = ch.length - 1; ; i--){
//            if (ch[i] != '0'){
//                len = i + 1;
//                break;
//            }
//        }
//        StringBuffer str3 = new StringBuffer();
//        for (int i = 0; i < len; i++) {
//            int index1 = ch[i] - '0';
////            System.out.println("1" + index1);
//            str3.append(str1[index1]);
//            if (ch[i] != '0'){
//                int index2 = ch.length - i - 1 ;
////                System.out.println("2" + index2);
//                str3.append(str2[index2]);
//            }
//        }
//        if (len == ch.length)
//        {
//            System.out.println(str3);
//        }else {
//            System.out.println(str3 + "圆");
//        }


        /**
         * 输入一个字符串,分别统计出其中英文字母、空格、数字和其它字符的数量

         */
//        String str4 = sc.nextLine();
//        char[] ch1 = str4.toCharArray();
//        int[] count = {0, 0, 0, 0};
//        for (int i = 0; i < ch1.length; i++) {
//            if ((ch1[i] >= 'a' && ch1[i] <= 'z') || (ch1[i] >= 'A' && ch1[i] <= 'Z')) {
//                count[0]++;
//            } else if (ch1[i] >= '0' && ch1[i] <= '9') {
//                count[2]++;
//            } else if (ch1[i] == ' ') {
//                count[1]++;
//            } else {
//                count[3]++;
//            }
//        }
//        System.out.println("英文字母:" + count[0] + "空格:" + count[1] + "数字:" + count[2] + "其它字符的数量:" + count[3]);

        /**
         *1.模拟验证手机号的过程，按照以下要求实现相关代码（友情提示：不一定要用正则）
         a.	提示用户在控制台输入手机号，用一个字符串对其进行保存
         b.	判断该手机号位数是否是11位
         c.	判断该手机号，是否都是数字
         d.	判断改手机号最后3为数字如果是相同数字则认为是靓号

         */
//        System.out.println("请输入手机号");
//        String phoneNumber = sc.next();
//        if(phoneNumber.length()  == 11){
//            if(phoneNumber.matches("[0-9]+")) {
//                char[] ch = phoneNumber.toCharArray();
//                if(ch[10] == ch[9] && ch[10] == ch[8]) {
//                    System.out.println("该手机号为靓号");
//                }else {
//                    System.out.println("该手机号为普通手机号");
//                }
//            }else {
//                System.out.println("手机号应全部为数字");
//            }
//        }else {
//            System.out.println("手机号长度错误");
//        }

        /**
         * 输出一个字符串，怎样判断是否是aba,abcba,abffba的字符串

         */
//        String str = sc.next();
//        StringBuilder sb = new StringBuilder(str);
//        StringBuilder c = sb.reverse();
//        boolean flag = true;
//        for (int i = 0; i < c.length()/2; i++) {
//            if(str.charAt(i)==c.charAt(i)) {
//                flag =true;
//            }else {
//                flag = false;
//            }
//        }
//        if(flag) {
//            System.out.println("是回文数");
//        }else{
//            System.out.println("不是回文数!");
//        }
        /**
         * 编写一个程序，这个程序把一个整数数组中的每个元素用逗号连接成一个字符串，
         //例如，根据内容为[1][2][3]的数组形成内容为"1,2,3"的字符串。

         */
//        System.out.println("请输入数组长度");
//        int len = sc.nextInt();
//        int[] arr = new int[len];
//        StringBuffer str = new StringBuffer();
//        for (int i = 0; i < len; i++) {
//            System.out.println("请输入第" + (i + 1) + "元素");
//            arr[i] = sc.nextInt();
//            if (i == len - 1) {
//                str.append(arr[i]);
//            } else {
//                str.append(arr[i]);
//                str.append(",");
//            }
//        }
//        System.out.println(str);
        /**
         *从键盘输入一个值,根据值进行判断如果是小于60则输出sorry,如果是包含60分以上则输出ok

         */
//        int num = sc.nextInt();
//        if (num >= 60) {
//            System.out.println("ok");
//        }else {
//            System.out.println("sorry");
//        }

        /**
         *1.将用户在控制台上输出的5个数字按照大小顺序存入到D:\\xx.txt中,并读出显示在控制台上
         *

         */
//        int[] arr = new int[5];
//        for (int i = 0; i < 5; i++) {
//            arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr);
//        BufferedWriter bw = new BufferedWriter(new FileWriter("src/homework/string/string.txt"));
//        for (int i = 4; i >= 0; i--) {
//            bw.write(String.valueOf(arr[i]));
//            bw.flush();
//        }
//        bw.close();
//        BufferedReader br = new BufferedReader(new FileReader("src/homework/string/string.txt"));
//        System.out.println(br.readLine());

        /**
         * .从键盘接受多个int型的整数,直到用户输入end结束
         要求:把所有的整数按倒序写到D:\\number.txt中
         * @throws IOException
         */
//        String01.reverseNumber();

        /**
         * 将每一个单词首字母变成大写,后边的变成小写

         */
//        String str = "hello World";
//        String a = str.substring(0,1).toUpperCase().concat(str.substring(1).toLowerCase());
//        System.out.println(a);

        /**
         * @从控制台接受一串字符串(8分) (1)将该字符串转换成字符数组(2分)
        (2)将该字符数组下标为偶数的字符打印到控制台(3分)//偶数包括0
        (3)将该字符数组的第一个元素与最后一个元素互换(3分)

         */
//        String str = sc.next();
//        char[] ch = str.toCharArray();
//        for (int i = 0; i < ch.length; i++) {
//            if (i % 2 == 0) {
//                System.out.println(ch[i]);
//            }
//        }
//        char temp = ch[ch.length - 1];
//        ch[ch.length - 1] = ch[0];
//        ch[0] = temp;
//        System.out.println(Arrays.toString(ch));


        /**
         *  从键盘接受一个数字,将这个十进制的数字转换成二进制并输出
         * 到控制台,当输入"end"时,结束.
         *
         */

//        //获取用户输入
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请随机输入一个十进制整数：");
//
//        //检验用户输入的数值是否符合要求
//        if(sc.hasNextInt()){
//            int num=sc.nextInt();
//            if(num>=0){
//                System.out.print("十进制"+num+"的二进制为：");
//                int x=1, y=0;
//                String binary="";
//                while(x!=0){
//                    x=num/2;
//                    y=num%2;
//                    num=x;
//                    binary+=y;
//                }
//                for(int i=binary.length()-1;i>=0;i--){
//                    System.out.print(binary.charAt(i));
//                }
//            }else{
//                System.out.println("您输入的数值有误，请重新输入。");
//            }
//        }else{
//            System.out.println("您输入的数值有误，请重新输入。");
//        }

//        String str = "";
//        String s;
//        while (!(s = sc.nextLine()).equals("end")) {
//            str = str.concat(s);
//        }
//        System.out.println(str);
//        System.out.println(Integer.toBinaryString(Integer.parseInt(str)));

        /**
         * 录入一个浮点数,例如3.1415926,只获取小数点后两位,只打印3.14

         */
//        System.out.println("请录入一个浮点数:");
//        split(sc.nextLine());

//        String result = String.format("%.2f", sc.nextDouble());
//        System.out.println(result);

        /**
         * 从控制台接收一串字符串,完成以下要求 (共10分)
         a,求出该字符串的长度并输出到控制台,如字符串长度为:X
         b,将该字符串转为数组(toCharArray),判断(if)该数组第一个字符(arr[0])和最后一个字符(arr[arr.length-1])是否相同,不相同则交换(想第三方变量)
         c,统计出数组中的每个字符出现的次数,然后自然排序(Tree树结构)后按指定格式输出到控制台,如a=3,b=4,c=5
         d,将第二步互换后的数组角标为奇数的字符用”*”号替换,然后遍历输出
         e,将数组中元素重新拼接成字符串,最后截取第一个'*'到第三个'*'之间的数据输出(注意:两边都包含'*')

         例如输入字符串:aaabbbbccccdddeef 打印台输出效果如下:
         该字符串的长度为:17

         每个字符出现的次数为:a=3,b=4,c=4,d=3,e=2,f=1
         被替换后的数组元素为:f*a*b*b*c*c*d*e*a
         第一个*到第三个*之间的数据为:*a*b*
         */
//        String str = sc.next();
//        System.out.println("字符串长度为:" + str.length());
//        char[] ch = str.toCharArray();
//        if (ch[0] != ch[ch.length - 1]) {
//            char c = ch[0];
//            ch[0] = ch[ch.length - 1];
//            ch[ch.length - 1] = c;
//        }
//        TreeMap<Character, Integer> treeMap = new TreeMap<>();
//        for (int i = 0; i < ch.length; i++) {
//            if (treeMap.containsKey(ch[i])) {
//                int value = treeMap.get(ch[i]);
//                treeMap.put(ch[i], value + 1);
//            } else {
//                treeMap.put(ch[i], 1);
//            }
//        }
//        for (Character c : treeMap.keySet()) {
//            System.out.println(c + "=" + treeMap.get(c));
//        }
//
//        for (int i = 0; i < ch.length; i++) {
//            if (i % 2 != 0) {
//                ch[i] = '*';
//            }
//        }
//        System.out.println(Arrays.toString(ch));
//
//        String str1 = String.valueOf(ch);
//        String[] s = str1.split("\\*");
//        System.out.println('*' + s[1]+ '*' + s[2] + '*');

        /**
         * 接收用户输入的一句英文，将其中的单词以反序输出。例如：
         “I love you” →"I evol uoy"

         */
//        String str = sc.next();
//        String[] s = str.split(" ");
//        for (int i = 0; i < s.length; i++) {
//            char[] ch = s[i].toCharArray();
//            for (int j = ch.length - 1; j >= 0; j--) {
//                System.out.print(ch[i]);
//            }
//            System.out.print(" ");
//        }

        /**
         *编写一个可以获取文件扩展名的函数。形参接收一个文件名字符串，返回一个扩展字符串。
         */

        /**
         * 编程列出一个字符串的全部字符组合情况。原始字符串中没有重复字符。
         例如：

         原始字符串是“abc”，打印得到下列所有组合情况：
         “a” “b” “c”
         "ab" "ac" "ba" "bc" "ca"  "cb"
         "abc"  "acb"  "bac" "bca"  "cab" "cba"
         */
//        StringBuilder sb = new StringBuilder();
//        System.out.println("请输入一串字符");
//        String next = sc.next();
//        is = next.toCharArray();
//        int len = next.length();
//        // i 控制的是组合长度所以从1开始
//        for (int i = 1; i <= len; i++) {
//            group("", sb, i);
//            System.out.println();
//        }
//        System.out.println("total : " + total);

        /**
         * 1.有一个字符串"wojavaaijavahahajavajavaaiwo"删除该字符串中所有的"java"并且统计删除了多少个“java”

         */

    }

    public static void reverseNumber() throws IOException {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            System.out.println("请输入整数，若输入end，则结束输入");
            String n = sc.nextLine();
            //如果输入的字符串为end，则跳出，否则添加到list中
            if (n.equals("end")) {
                break;
            }
            //将输入的整数添加到list中
            list.add(n);
        }
        System.out.println("输入数据完毕");
        //创建写入的文件
        BufferedWriter fw = new BufferedWriter(new FileWriter("src/homework/string/string01.txt"));
        //倒序遍历list
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            fw.write(s);
        }
        fw.close();
        System.out.println("写入成功！");
    }

    public static void split(String s) {
        //将传入的数据用点切割成字符数组
        String[] arr = s.split("\\.");
        //获取到指定位置的字符串
        String str = arr[1].substring(0, 2);
        //定义字符串序列
        StringBuilder sb = new StringBuilder();
        //将获取到的元素拼接一起
        sb.append(arr[0]).append(".").append(str);
        Float f = Float.parseFloat(sb.toString());//Float.parseFloat:将字符串转换成小数
        System.out.println(f);
    }

    public static void group(String s, StringBuilder sb, int m) {
        if (m == 0) {
            System.out.print(s + "\t");
            total++;
            return;
        }
        StringBuilder sb2;
        for (int i = 0; i < is.length; i++) {
            sb2 = new StringBuilder();
            sb2.append(sb);
            if (sb.indexOf(String.valueOf(i)) == -1) {
//                System.out.println("s=" + s);
//                System.out.println("is[" + i +"]=" + is[i]);
                String str = s + is[i];
//                System.out.println("str=" + str);
                sb2.append(i);
//                System.out.println("sb2=" + sb2);
                group(str, sb2, m - 1);
            }
        }
    }
}
