package homework;

public class Guess {
    public static void main(String[] args) {
        System.out.println("第一题");
        boolean b = true;
        if (b == false)
            System.out.println("a");
        else if (b)
            System.out.println("b");
        else if (!b)
            System.out.println("c");
        else {
            System.out.println("d");
        }

        System.out.println("第二题");
        int x = 1, y = 1;
        if (x++ == 2 & ++y == 2) {
//            System.out.println(x);
            x = 7;
        }
        System.out.println("x=" + x + ",y=" + y);


        System.out.println("第三题");
        x = y = 1;
        if (x++ == 2 && ++y == 2) {
            x = 7;
        }
        System.out.println("x=" + x + ",y=" + y);


        System.out.println("第四题");
        x = y = 1;
        if (x++ == 1 | ++y == 1) {
            x = 7;
        }
        System.out.println("x=" + x + ",y=" + y);


        System.out.println("第五题");
        x = y = 1;
        if (x++ == 1 || ++y == 1) {
            x = 7;
        }
        System.out.println("x=" + x + ",y=" + y);

        System.out.println("第六题");
        b = true;

        if (b = false)
            System.out.println("a");
        else if (b)
            System.out.println("b");
        else if (!b)
            System.out.println("c");
        else
            System.out.println("d");


        System.out.println("第七题");
        x = 2;
        y = 3;
        switch (x) {

            default:
                y++;
            case 3:
                y++;
                break;
            case 4:
                y++;
        }
        System.out.println("y=" + y);

        System.out.println("第八题");
        int i = 6;
        switch (i) {
            case 0:
                System.out.print("0");
                break;
            case 1:
                System.out.print("1");
                break;
            case 2:
                System.out.print("2");
                break;
            default:
                System.out.println("default");
                break;
        }


        System.out.println("第九题");
        i = 2;
        switch (i) {
            case 0:
                System.out.print("0");
            case 1:
                System.out.print("1");
            case 2:
                System.out.print("2");
            default:
                System.out.println("default");
        }


        System.out.println("第十题");
        i = 6;

        switch (i) {
            case 0:
                System.out.print("0");
            case 1:
                System.out.print("1");
            case 2:
                System.out.print("2");
            default:
                System.out.println("default");
        }


        System.out.println("第十一题");
        i = 2;

        switch (i) {
            case 0:
                System.out.print("0");
            case 1:
                System.out.print("1");
            case 2:
                System.out.print("2");
            case 3:
                System.out.print("3");
                break;
            default:
                System.out.print("default");
        }
        System.out.println();

        System.out.println("第十二题");
        x = 0;

        switch (x) {
            default:
                System.out.println("default");
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
        }


        System.out.println("第十三题");
        x = 0;

        switch (x) {
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println("default");
        }


        System.out.println("第十四题");
        int a = 1;

        switch (a) {
            case 2:
                System.out.println("print 2");
            case 1:
                System.out.println("print 1");
            default:
                System.out.println("first default print");
            case 3:
                System.out.println("print 3");
        }


        System.out.println("第十五题");
//        String param = null;
//
//        switch (param) {
//            case "param":
//                System.out.println("print param");
//                break;
//            case "String":
//                System.out.println("print String");
//                break;
//            case "null":
//                System.out.println("print null");
//                break;
//            default:
//                System.out.println("second default print");
//        }

        System.out.println("第十六题");
        x = 10;
        y = 20;
        int c = x++ + y;
        int d = ++x + y;
        System.out.println("c:" + c + "\td:" + d);


        System.out.println("第十七题");
        i = 1;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i + ",j=" + j + ",k=" + k);


        System.out.println("第十八题");
        x = 10;
        y = 10;
        System.out.println("x+y=" + x + y);
        System.out.println("x*y=" + x * y);
        System.out.println("x/y=" + x / y);


        System.out.println("第十九题");

        int count = 0;
        y = 0;
        for (i = 1; i <= 10; i++) {
            y = count++;
        }
        System.out.println(y);


        System.out.println("第二十题");
        count = 0;
        for (i = 1; i <= 10; i++) {
            count = count++;
        }
        System.out.println(count);


        System.out.println("第二十一题");
        x = 0;
        y = 0;
        k = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2) && (k++ > 2)) {
                x++;
                ++y;
                k++;
            }
        }
        System.out.println(x + "," + y + "," + k);

    }
}
