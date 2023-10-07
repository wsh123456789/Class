package homework.exam.exam01;

import java.util.Scanner;

public class question05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查询第几项");
        int n = sc.nextInt();
        System.out.println(fun(n));
    }

    public static int fun(int n) {
        if (n == 1){
            return 1;
        }else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 3;
        }else {
            return fun(n-1) + fun(n - 3);
        }
    }
}
