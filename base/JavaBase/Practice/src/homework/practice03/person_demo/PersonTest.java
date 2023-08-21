package homework.practice03.person_demo;

/*
* 5、需求:
 	有一个父类Person，里面有姓名name和性别sex，年龄age属性，
 	 还有一个抽象show方法（功能是陈述自己是什么类）。
 	 定义一个能说的接口Sayable，
 	 定义一个能听的接口Hearable，
 	 还有一个能吃的接口Eatable，

 	 哑巴Dumb是不能说的，
 	 聋子Deaf是不能听到的，
 	 但他们都有姓名，年龄，性别，都有吃的能力。
	要求：
		请按如上描述定义相应的类与接口，并且在测试类中创建对象，使用对象，运行输出结果
*/
public class PersonTest {
    public static void main(String[] args) {
        Deaf deaf = new Deaf("Tom", "男", 22);
        Dumb dumb = new Dumb("Kim", "女", 18);
        deaf.show();
        deaf.eat();
        deaf.speak();
        dumb.show();
        dumb.eat();
        dumb.listen();
    }
}
