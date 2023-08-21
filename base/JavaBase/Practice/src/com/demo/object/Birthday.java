package com.demo.object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Birthday {
    /**
     * * A:案例演示
     * 需求：算一下你来到这个世界多少天?
     * 分析:
     * 1,将生日字符串和今天字符串存在String类型的变量中
     * 2,定义日期格式化对象
     * 3,将日期字符串转换成日期对象
     * 4,通过日期对象后期时间毫秒值
     * 5,将两个时间毫秒值相减除以1000,再除以60,再除以60,再除以24得到天
     *
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        //1,将生日字符串和今天字符串存在String类型的变量中
        String birthday = "1949年10月01日";
        String today = "2023年8月11日";
        //2,定义日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //3,将日期字符串转换成日期对象
        Date d1 = sdf.parse(birthday);
        Date d2 = sdf.parse(today);
        //4,通过日期对象后期时间毫秒值
        long time = d2.getTime() - d1.getTime();
        //5,将两个时间毫秒值相减除以1000,再除以60,再除以60,再除以24得到天
        System.out.println("已经活了" + (time / 1000 / 60 / 60 / 24) + "天");
        System.out.println("已经活了" + (time / 1000 / 60 / 60 / 24 / 365) + "年");
    }


}
