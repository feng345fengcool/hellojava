package indi.chen.hellojava.basic;

public class MathTest {
    /**
     * 1. 如果参数为正数 且小数点后第一位>=5 运算结果为参数的整数部分+1
     * 2. 如果参数为负数 且小数点后第一位>5 运算结果为参数的整数部分-1
     * 3. 如果参数为正数 且小数点后第一位<5 或者参数为负数 且小数点后第一位<=5 运算结果为参数的整数部分
     * <p>
     * 最好的记忆方法是正数四舍五入 负数四舍六入
     */
    public static void main(String[] args) {
        System.out.println("小数点后第一位=5");
        System.out.println("正数：Math.round(11.5)=" + Math.round(11.5));
        System.out.println("负数：Math.round(-11.5)=" + Math.round(-11.5));
        System.out.println();
        System.out.println("小数点后第一位<5");
        System.out.println("正数：Math.round(11.46)=" + Math.round(11.46));
        System.out.println("负数：Math.round(-11.46)=" + Math.round(-11.46));
        System.out.println();
        System.out.println("小数点后第一位>5");
        System.out.println("正数：Math.round(11.68)=" + Math.round(11.68));
        System.out.println("负数：Math.round(-11.68)=" + Math.round(-11.68));
    }
    /**
     * byte char short int及其包装类都可以使用switch语句
     * enum类型可以用于switch语句
     * long float double boolean及其包装类都不可以使用switch语句
     * 所有类型的对象都不能用于switch语句
     */
}