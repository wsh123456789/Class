package com.demo._singleton;

public class AdapterDemo {
    public static void main(String[] args) {

    }
}
// 适配器模式

// 手机的功能
interface Phone {
    void call();
    void sendMessage();
    void playGame();
}

// 适配器实现功能
class MyAdapter implements Phone{

    @Override
    public void call() {

    }

    @Override
    public void sendMessage() {

    }

    @Override
    public void playGame() {

    }
}

// 手机并不具备所有功能所以通过适配器来重写自己有的功能
class MyPhone extends MyAdapter {

    @Override
    public void call(){
        System.out.println("我的手机能打电话");
    }
    @Override
    public void sendMessage(){
        System.out.println("我的手机能发信息");
    }
}
