package com.demo.object;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsualClass {
    public static void main(String[] args) throws ParseException {
        String str = "1999-08-10 10:26:47";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);
        System.out.println(date);
        System.out.println(date.getTime());

//      System类的概述
//          * System 类包含一些有用的类字段和方法。
//      成员方法
//          * public static void gc()   垃圾回收机制     Object.finalise()
//          * public static void exit(int status)//退出当前JVM
//	        * public static long currentTimeMillis()
//        demo1();
//        demo2();
//        demo3();


        //    Date类的概述是java.util包下的
//    类 Date 表示特定的瞬间，精确到毫秒。
//    构造方法
//      public Date()//如果没有传参数代表的是当前时间
//      public Date(long date)//如果构造方法中参数传为0代表的是1970年1月1日   元年
//    成员方法
//      public long getTime()  //通过时间对象获取当前时间毫秒值  与System.currentTimeMillis()功能相似
//      public void setTime(long time)  //设置毫秒值,改变时间对象

        Date d1 = new Date();
        d1.setTime(1000);                                //设置毫秒值,改变时间对象
        System.out.println(d1);
//        dateDemo1();
//        dateDemo2();


//        SimpleDateFormat类实现日期和字符串的相互转换
//        DateFormat类的概述
//          * DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。是抽象类，所以使用其子类SimpleDateFormat

//          * SimpleDateFormat构造方法
//          * public SimpleDateFormat()//默认的时间转换格式
//          * public SimpleDateFormat(String pattern)//自定义格式  取决于  参数格式

//          * 成员方法
//          * public final String format(Date date)     Date  String
//          * public Date parse(String source)//将时间字符串转换成日期对象

        //simpleDateFormatDemo1();
        //simpleDateFormatDemo2();
        //simpleDateFormatDemo3();

        simpleDateFormatDemo4();

    }


    public static void systemDemo3() {
        long start = System.currentTimeMillis();   //1秒等于1000毫秒
        for (int i = 0; i < 1000; i++) {
            System.out.println("*");
        }
        long end = System.currentTimeMillis();    //获取当前时间的毫秒值

        System.out.println(end - start);
    }

    public static void systemDemo2() {
        System.exit(1);     //非0状态是异常终止,退出jvm
        //因为在上面已经退出了java虚拟机,所以下面的语句不会执行
        System.out.println("11111111111");
    }

    public static void systemDemo1() {
        //产生垃圾的for循环
        for (int i = 0; i < 100; i++) {
            new Demo();
            System.gc();  //运行垃圾回收器,相当于呼喊保洁阿姨,但是不一厅呼喊一次就执行,有可能需要呼喊多次才执行
        }
    }


    public static void dateDemo2() {
        Date d1 = new Date();
        System.out.println(d1.getTime());                //通过时间对象获取当前时间毫秒值
        System.out.println(System.currentTimeMillis());        //通过系统类的方法获取当前时间毫秒值
    }

    public static void dateDemo1() {
        Date d1 = new Date();                    //如果没有传参数代表的是当前时间
        System.out.println(d1);

        Date d2 = new Date(0);                    //如果构造方法中参数传为0代表的是1970年1月1日
        System.out.println(d2);


    }


    private static void simpleDateFormatDemo4() throws ParseException {
        //将时间字符串转换成日期对象
        String str = "2000年08月08日 08:08:08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d = sdf.parse(str);						//将时间字符串转换成日期对象
        System.out.println(d);
    }

    public static void simpleDateFormatDemo3() {
        Date d = new Date();							//获取当前时间对象
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM年-dd日 HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//创建日期格式化类对象
        System.out.println(sdf.format(d));				//将日期对象转换为字符串
    }

    public static void simpleDateFormatDemo2() {
        Date d = new Date();							//获取当前时间对象
        SimpleDateFormat sdf = new SimpleDateFormat();	//创建日期格式化类对象
        System.out.println(sdf.format(d));	 			//88-6-6 下午9:31
    }

    public static void simpleDateFormatDemo1() {
        //DateFormat df = new DateFormat();				//DateFormat是抽象类,不允许实例化
        //DateFormat df1 = new SimpleDateFormat();
        DateFormat df1 = DateFormat.getDateInstance();	//相当于父类引用指向子类对象,右边的方法返回一个子类对象
    }

}

class Demo {    //在一个源文件中不允许定义两个用public修饰的类

    @Override
    public void finalize() {//系统 自动 垃圾回收
        System.out.println("垃圾被清扫了");
    }

}
