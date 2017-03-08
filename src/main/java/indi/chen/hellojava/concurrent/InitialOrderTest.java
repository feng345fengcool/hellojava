package indi.chen.hellojava.concurrent;

public class InitialOrderTest {

    // 静态变量
    public static String staticField = "静态变量";
    private static InitialOrderTest instance = new InitialOrderTest();

    // 静态初始化块
    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    // 变量
    public String field = "变量";

    // 初始化块
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 构造器
    private InitialOrderTest() {
        System.out.println("构造器");
    }

    public static InitialOrderTest getInstance() {
        return instance;
    }

    public static void main(String[] args) {
//        new InitialOrderTest();
        InitialOrderTest.getInstance();
    }
}


// 先是静态的（静态初始化块和静态变量先后看声明的顺序，变量和初始化块也是看顺序的）然后是非静态的 父类和子类交替执行


