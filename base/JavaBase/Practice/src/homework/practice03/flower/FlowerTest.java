package homework.practice03.flower;

/*
* 4、花类练习需求：
	1. 定义一个Flower花作为父类
	2. 属性：颜色（color） 价格（price）
	3. 将属性进行封装（即为每条都封装）
	4. 定义无参、有参的构造方法
	5. 定义一个显示详细信息的方法 showInfo
	6. 定义一个Rose玫瑰花类继承Flower类
	7. 玫瑰花自己的属性：产地（pop）,进行封装
	8. 重写父类的showInfo方法，调用父类的方法，介绍颜色和价格，并单独显示产地信息
	9. 定义一个方法，warn 警告显示：不要摘玫瑰花，小心扎手。
*/
public class FlowerTest {
    public static void main(String[] args) {
        Flower flower = new Flower("白色", 9.9);
        Rose rose = new Rose("红色", 13.14, "罗曼蒂克");
        flower.showInfo();
        rose.showInfo();
        rose.warn();
    }
}
