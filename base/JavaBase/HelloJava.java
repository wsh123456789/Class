public class HelloJava {
    public static void main(String[] args) {
        /*package 包

        public 权限修饰符 公共的
        class 声明这是一个类
Demo2 自己起的类名

        static 静态的  它的作用是让main方法随着类的加载而加载
        void 返回值  无
        main 方法名
        (String[] args) 参数  []数组

        {} 作用域



        System 系统类
        out 标准输出流
        in 标准输入流
        err 标准错误输出流

        println() 将内容打印到控制台的方法  ln换行*/
        System.out.println("HelloJava");
        // 包名: 多单词组成时都用小写 例如：java.lang
        // 类名、接口名: 多单词组成时所有字母首字母大写 例如： XxxYyyZzz
        // 变量名、方法名: 多单词组成时首字母小写第二个单词开始首字母大写 例如： xxxYyyZzz
        // 常量名: 所有字母大写，每个单词之间用下划线连接 XXX_YYY_ZZZ

        /*
          基本数据类型
        *   整型: byte(1字节) \ short(2字节) \ int(4字节） \ long(八字节)(后缀加L或l)
        *   浮点型: float (声明时后缀加f) \ double
        *   字符型: char (不允许为空)
        *   布尔型: boolean
        * 引用数据类型
            类(class)
            数组(array)
            接口(interface)

            枚举(enum)
            注解(annotation)
            记录(record)
        * */
        // 自动类型提升  byte、short、char --> int --> long --> float --> double --> String
//        强制类型转换
//        高精度 BigDecimal  a = BigDecimal.valueOf(10.1);
        int i1 = (int) 1.9; // 向上取整
        System.out.println(i1);

        // String 类型 属于引用类型 允许为空
        String s1 = "111";
        System.out.println(s1);

        // String 转为 int
        String s2 = "10";
        int num = Integer.parseInt(s2);
        System.out.println(num);

        // 进制
        // 二进制 0B 或 0b 开头
        // 八进制 0 开头
        // 十六进制 0X 或 0x 开头

        // 检查是否是类的对象instanceof
        System.out.println("hello" instanceof String);

        /*
        位运算符
        * << 左移   3 << 2 = 12       3*2*2
        * >> 右移   3 >> 1 = 1        3 / 2 = 1
        * >>> 无符号右移 3 >>> 1 = 1   3 / 2 = 1
        * & 与运算   6 & 3 = 2        二进制运算: 结果是 1&1 结果为1 否则为0
        * | 或运算   6 | 3 = 7        结果是 0|0 结果为0 否则为1
        * ^ 异或运算 6 ^ 3 = 5        相同为0 不同为1
        * ~ 取反运算 6 ~ 3 = -5
        * */
//        System.out.println();

        // 条件表达式 ? a : b ;
        int a = 4, b = 2, c = 3;
        int max = a > b ? a > c ? a : c : b > c ? b : c;
        System.out.println(max);

        // 输入
//        Scanner scan = new Scanner(System.in);
//        String s3 = scan.next();
//        System.out.println(s3);

        // 随机数
        // random() 调用后返回一个[0.0, 1.0)范围的double型随机数
        double d1 = Math.random();
        System.out.println(d1);
//        获取一个[a, b]范围的随机数
//        (int)(Math.random() * (b - a +1) + a)

        // switch
//        switch (表达式) {
//            case 常量值:
//                语句块1;
//            case 常量值2:
//                语句块2;
//            default:
//                语句块n+1;
//                break;;
//        }
        int i = 1;
        while (i >= 0){
            System.out.println(i);
            i--;
        };
        i = 1;
        do {
            System.out.println(i);
            i--;
        }while (i >= 0);
//      获取时间戳
        long end = System.currentTimeMillis();
        System.out.println(end);
    }
}
