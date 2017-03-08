package indi.chen.hellojava.basic;

public class EqualsTest {
    /**
     * ==运算符在基本类型和其包装类对象之间比较时，遵循如下规则：
     * 1. 只要两个操作数中有一个是基本类型，就是比较他们的数值是否相等
     * 2. 否则，就是判断这两个对象的内存地址是否相等，即是否是同一个对象
     */
    public static void main(String[] args) {
        // int类型用int类型初始化
        int int_int = 0;
        // int类型用Integer类型初始化
        int int_Integer = new Integer(0);
        // Integer类型用Integer类型初始化
        Integer Integer_Integer = new Integer(0);
        // Integer类型用int类型初始化
        Integer Integer_int = 0;
        System.out.println("int_int == int_Integer结果是：" + (int_int == int_Integer));
        System.out.println("Integer_Integer == Integer_int结果是：" + (Integer_Integer == Integer_int));
        System.out.println();
        System.out.println("int_int == Integer_Integer结果是：" + (int_int == Integer_Integer));
        System.out.println("Integer_Integer == int_int结果是：" + (Integer_Integer == int_int));
        System.out.println();
        // boolean类型用boolean类型初始化
        boolean boolean_boolean = true;
        // boolean类型用Boolean类型初始化
        boolean boolean_Boolean = new Boolean(true);
        // Boolean类型用Boolean类型初始化
        Boolean Boolean_Boolean = new Boolean(true);
        // Boolean类型用boolean类型初始化
        Boolean Boolean_boolean = true;
        System.out.println("boolean_boolean == boolean_Boolean结果是："
                + (boolean_boolean == boolean_Boolean));
        System.out.println("Boolean_Boolean == Boolean_boolean结果是："
                + (Boolean_Boolean == Boolean_boolean));
        System.out.println();
        System.out.println("boolean_boolean == Boolean_Boolean结果是："
                + (boolean_boolean == Boolean_Boolean));
        System.out.println("Boolean_Boolean == boolean_boolean结果是："
                + (Boolean_Boolean == boolean_boolean));
    }
}
