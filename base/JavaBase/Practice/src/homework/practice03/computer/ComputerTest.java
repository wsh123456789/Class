package homework.practice03.computer;

/*
* 6、进行描述笔记本类，实现笔记本使用USB鼠标、USB键盘
	USB接口，包含运行（open）、关闭（close）功能
	笔记本类（Computer），包含运行功能、关机功能、使用USB设备功能
	鼠标类（mouse），实现USB接口，并具备点击的方法
	键盘类（keyboard），实现USB接口，并具备敲击的方法
*/
public class ComputerTest {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.open();
        computer.useMouse().open();
        computer.useMouse().click();
        computer.useMouse().close();

        computer.useKeyBoard().open();
        computer.useKeyBoard().input();
        computer.useKeyBoard().close();
        computer.close();
    }
}
