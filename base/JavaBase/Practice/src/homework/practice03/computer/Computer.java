package homework.practice03.computer;

public class Computer implements USB{
    @Override
    public void open() {
        System.out.println("开机");
    }

    @Override
    public void close() {
        System.out.println("关机");
    }

    public Mouse useMouse() {
        Mouse mouse = new Mouse();
        return mouse;
    }

    public KeyBoard useKeyBoard() {
        KeyBoard keyBoard = new KeyBoard();
        return keyBoard;
    }
}
