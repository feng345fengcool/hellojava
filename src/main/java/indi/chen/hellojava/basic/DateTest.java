package indi.chen.hellojava.basic;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {

        Date d = new Date();
        // 在默认时区下输出日期和时间值
        System.out.println(d);

        // 2008-08-08 20:00:00对应的毫秒数
        long t2008 = 1218196800000L;
        // 1900-01-01 20:00:00对应的毫秒数
        long t1900 = -2208945952000L;
        // 指定毫秒数创建Date对象
        Date d2008 = new Date(t2008);
        // 使用系统默认时间创建Date对象
        Date d1900 = new Date();
        // 通过设置毫秒数改变日期和时间
        d1900.setTime(t1900);
        System.out.println("调用方法：d1900.before(d2008)");
        System.out.print("比较结果：\"1900-01-01 20:00:00\"在\"2008-08-08 20:00:00\"");
        // 使用before()方法比较
        if (d1900.before(d2008)) {
            System.out.println("之前");
        } else {
            System.out.println("之后");
        }
        System.out.println();
        System.out.println("调用方法：d2008.after(d1900)");
        System.out.print("比较结果：\"2008-08-08 20:00:00\"在\"1900-01-01 20:00:00\"");
        // 使用after()方法比较
        if (d2008.after(d1900)) {
            System.out.println("之后");
        } else {
            System.out.println("之前");
        }
        System.out.println();
        System.out.println("调用方法：d1900.compareTo(d2008)");
        System.out.print("比较结果：\"1900-01-01 20:00:00\"在\"2008-08-08 20:00:00\"");
        // 使用compareTo()方法比较
        int i = d1900.compareTo(d2008);
        if (i == -1) {
            System.out.println("之前");
        } else if (i == 1) {
            System.out.println("之后");
        } else if (i == 0) {
            System.out.println("是同一时刻");
        }
    }

}