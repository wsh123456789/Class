package homework.practice03.car;
/*
* 3、设计2个类，要求如下：
	3.1 定义一个汽车类Vehicle，
	3.1.1 属性包括：汽车品牌brand（String类型）、颜色color（String类型）和速度speed（double类型）。
	3.1.2 至少提供一个有参的构造方法（要求品牌和颜色可以初始化为任意值，但速度的初始值必须为0）。
	3.1.3 为属性提供访问器方法。注意：汽车品牌一旦初始化之后不能修改。
	3.1.4 定义一个一般方法run()，用打印语句描述汽车奔跑的功能
	3.1.5 在main方法中创建一个品牌为“benz”、颜色为“black”的汽车。
	3.2 定义一个Vehicle类的子类轿车类Car，要求如下：
	3.2.1 轿车有自己的属性载人数loader（int 类型）。
	3.2.2 提供该类初始化属性的构造方法。
	3.2.3 重新定义run()，用打印语句描述轿车奔跑的功能。
	3.2.4 在main方法中创建一个品牌为“Honda”、颜色为“red”，载人数为2人的轿车。
*/
public class CarTest {
    public static void main(String[] args) {
        Vehicle car1 = new Vehicle("benz", "black");
        Car car2 = new Car("Honda", "red", 2);
        car1.run();
        car2.run();
    }
}
