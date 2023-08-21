package homework.shop.utils;

import java.util.Scanner;

public class SC {

    //String
    public static String getString(){
        return new Scanner(System.in).next();
    }
    public static int getInt(){
        return new Scanner(System.in).nextInt();
    }
    public static double getDouble(){
        return new Scanner(System.in).nextDouble();
    }


}