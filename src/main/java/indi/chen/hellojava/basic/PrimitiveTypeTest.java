package indi.chen.hellojava.basic;

public class PrimitiveTypeTest {

    public static void main(String[] args) {

        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();
        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();
        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();
        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();
        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();
        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();
        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE=" + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE=" + (int) Character.MAX_VALUE);

        /**
         *
         * 空：void
         * 布尔：boolean
         * 字符：char
         * 数值整数类型：byte short int long
         * 数值浮点类型：float double
         *
         * 所有基本类型都有其包装类型 且 都使用了final修饰符
         *
         * ==========================================================================
         *
         * 1. 整数默认是int类型 浮点数默认是double类型
         * 2. 初始化的时候超过取值范围 编译出错
         *
         *				char
         *				  |
         *				  |
         *	byte--short--int--long--float--double
         *
         *	1. int型值可以付给所有数值类型的变量
         *	2. 从低精度向高精度进行转换 无精度损失
         *	3. 整数类型向浮点类型转化 可能会损失一定精度
         *
         * long float double 运算会都先转换为long float double 结果也是long float double
         * byte short int char 运算都会先转换为int 结果也是int
         * += -= *= /= %=
         * 运算符右边的数值将首先被强制转换成与运算符左边数值相同的类型
         * 然后再执行计算 且运算结果与运算符左边数值类型相同
         *
         * ==运算符在基本类型和其包装类对象之间比较时，遵循如下规则：
         * 1. 只要两个操作数中有一个是基本类型，就是比较他们的数值是否相等
         * 2. 否则，就是判断这两个对象的内存地址是否相等，即是否是同一个对象
         *
         */
    }
}
