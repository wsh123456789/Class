package homework.exam.exam02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Practice03 {
    public static void main(String[] args) throws Exception{
        /** 3.利用反射给string泛型的集合添加int类型数据
         *
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello World");

        Class stringClass = list.getClass();

        Method method = stringClass.getDeclaredMethod("add", Object.class);
        method.setAccessible(true);

        method.invoke(list, 123);
        method.invoke(list, 456);
        System.out.println(list);

    }
}
