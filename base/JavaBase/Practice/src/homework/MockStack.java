package homework;

import java.util.LinkedList;

public class MockStack {

//    static int[] elem = new int[]{1,2};
//    static int usedSize = 2;

    public static void main(String[] args) throws MyemptyStackException {
//        push(3);
//        push(4);
//        pop();
//        pop();
//        pop();
//        pop();
//        pop();
        MyStack myStack = new MyStack();
        myStack.push(111);
        myStack.push(222);
        myStack.push(333);
        myStack.pop();
        myStack.pop();
        myStack.pop();
    }

//    public static int push(int val) {
//
//        if (isFull()) {
//            //扩容
//            elem = Arrays.copyOf(elem, 2 * elem.length);//扩2倍
//        }
//        elem[usedSize] = val;//从栈顶压入元素
//        usedSize++;//元素个数加1
//        return val;
//    }
//
//    public static boolean isFull() {
//        //当前栈中元素个数等不等于数组的大小
//        return usedSize == elem.length;
//    }
//
//    public static void pop() throws MyemptyStackException{
//        if (isEmpty()) {
//            //抛异常
//            throw new MyemptyStackException("栈为空！！！");
//        }
//        int ret = elem[usedSize - 1];
//        usedSize--;
//        System.out.println(ret);;//返回栈顶的元素
//    }
//
//    public static boolean isEmpty() {
//        return usedSize == 0;//为真就是空
//    }

}
class MyStack extends LinkedList {
    public void push(Object obj) {
        this.addLast(obj);
    }

    public Object pop(){
       if (!this.isEmpty()) {
            System.out.println(this.removeLast());
        }else {
           System.out.println("栈为空");
       }
        return null;
    }
}
