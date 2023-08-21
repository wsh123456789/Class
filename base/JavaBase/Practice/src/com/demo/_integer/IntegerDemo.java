package com.demo._integer;

public class IntegerDemo {
    public static void main(String[] args) {
        /*
         * * 将基本数据类型 封装成对象的好处在于可以在对象中定义更多的功能方法  操作该数据。
         * 假如将一个十进制数转成十六(二)进制数,需要做很多操作,现在有了包装类包装类中封装了很多方法,可以直接使用.
         * 常用的操作之一：用于基本数据类型与字符串之间的转换。
         * */

       /* 基本类型和包装类的对应
                *
        byte 			Byte
        short			Short
        int				Integer
        long			Long
        float			Float
        double			Double
        char			Character
        boolean			Boolean
        * */
        Integer a = 100;
        String str = String.valueOf(a);
        System.out.println(str);
        Byte b = Byte.parseByte(str);
        System.out.println(b);
        Double d = Double.parseDouble(str);
        System.out.println(d);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        Integer i1 = new Integer(100);
        System.out.println(i1);

        //Integer i2 = new Integer("abc");			//java.lang.NumberFormatException数字格式异常
        //System.out.println(i2);						//因为abc不是数字字符串,所以转换会报错

        Integer i3 = new Integer("100");
        System.out.println(i3);

//        * A:int -- String
//                * a:和""进行拼接
//                * b:public static String valueOf(int i)      valueOf（任意类型 xxx） 将任意类型转换成字符串
//                * c:int -- Integer -- String(Integer类的toString方法())
//                * d:public static String toString(int i)(Integer类的静态方法)
//                * B:String -- int
//	      * a:String -- Integer -- int
//	                * public static int parseInt(String s)
//	                parseXxx(String s)将字符串转换成任意类型Xxx可以为byte/char/long/float等等（Character除外）

        //demo1();
        String s1 = "true";
        boolean bl = Boolean.parseBoolean(s1);
        System.out.println(bl);

        //String s2 = "abc";
        //char c = Character.p		//char的包装类Character中没有pareseXxx的方法
        //字符串到字符的转换通过toCharArray()就可以把字符串转换为字符数组
    }

    private static void demo1() {
        //int ----> String int转换成String
        int i = 100;
        String s1 = i + "";                        //推荐用
        String s2 = String.valueOf(i);            //推荐用

        Integer i2 = new Integer(i);
        String s3 = i2.toString();

        String s4 = Integer.toString(i);
        System.out.println(s1);

        //String----> int String 转换int
        String s = "200";
        Integer i3 = new Integer(s);
        int i4 = i3.intValue();                    //将Integer转换成了int数

        int i5 = Integer.parseInt(s);
//
//      注意事项
//          * 在使用时，Integer  x = null;代码就会出现NullPointerException。
//	        * 建议先判断是否为null，然后再使用。

//        -128到127是byte的取值范围,如果在这个取值范围内,自动装箱就不会新创建对象,而是从常量池中获取
//                * 如果超过了byte取值范围就会再新创建对象
        Integer i1 = new Integer(127);
        Integer i11 = new Integer(127);
        System.out.println(i1 == i11);
        System.out.println(i1.equals(i11));
        System.out.println("-------------");

        Integer i111 = new Integer(138);
        Integer i1111 = new Integer(138);
        System.out.println(i111 == i1111);
        System.out.println(i111.equals(i1111));
        System.out.println("-------------");

        Integer i7 = 127;
        Integer i8 = 127;
        System.out.println(i7 == i8);
        System.out.println(i7.equals(i8));
        System.out.println("-------------");

        Integer i9 = 128;
        Integer i10 = 128;
        System.out.println(i9 == i10);
        System.out.println(i9.equals(i10));


    }
}
