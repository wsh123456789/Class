package com.demo._enum;

// 枚举类jdk5.0之前
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//jdk5.0之前
//class Season {
//
//    private final String seasonName;
//    private final String seasonDesc;
//
//    private Season(String seasonName, String seasonDesc) {
//        this.seasonName = seasonName;
//        this.seasonDesc = seasonDesc;
//    }
//
//    public String getSeasonName() {
//        return seasonName;
//    }
//
//    public String getSeasonDesc() {
//        return seasonDesc;
//    }
//
//    public static final Season SPRING = new Season("春天","春暖花开");
//    public static final Season SUMMER = new Season("夏天","夏日炎炎");
//    public static final Season AUTUMN = new Season("秋天","秋高气爽");
//    public static final Season WINTER = new Season("冬天","白雪皑皑");
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
//}

// 5.0使用enum关键字定义枚举类
// enum对象定义的对象其父类默认是java.lang.Enum类 不要显式继承父类
/*
* 方法
* String toString() 默认返回值是常量名（对象名） （可以重写方法)
* static 枚举类型[] values(): 返回枚举类型的对象数组。该方法可以很方便的遍历所有的枚举值，是一个静态方法
* static 枚举类型 valueOf(String name): 可以把字符串转换为对应的枚举类对象。要求字符串必须是枚举对象的名字
* String name(): 得到当前枚举常量的名称。建议优先使用toString()
* int ordinal(): 返回当前枚举常量的次序号，默认从零开始
* */
enum Season {

    // 必须在枚举类开头声明多个对象且用逗号隔开
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "白雪皑皑");
    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
