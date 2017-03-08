package indi.chen.hellojava.basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {

    public static String toFriendlyString(Calendar c) {
        if (c != null) {
            DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            return df.format(c.getTime());
        }
        return null;
    }

    public static void main(String[] args) {
        /**
         * GregorianCalendar
         * 1. 8 is September, so we will use static field instead of integer.
         * 2. 24h.
         * 3. sunday is the first day.
         */
        Calendar c1 = Calendar.getInstance();
        System.out.println("创建方式：Calendar.getInstance()");
        System.out.println("日期时间：" + CalendarTest.toFriendlyString(c1));
        System.out.println();

        Calendar c2 = new GregorianCalendar();
        System.out.println("创建方式：new GregorianCalendar()");
        System.out.println("日期时间：" + CalendarTest.toFriendlyString(c2));
        System.out.println();

        // 参数含义依次为：年、月、日
        Calendar c3 = new GregorianCalendar(2008, Calendar.AUGUST, 8);
        System.out.println("创建方式：new GregorianCalendar(2008, 8, 8)");
        System.out.println("日期时间：" + CalendarTest.toFriendlyString(c3));
        System.out.println();

        // 参数含义依次为：年、月、日、时、分
        Calendar c4 = new GregorianCalendar(2008, Calendar.AUGUST, 8, 6, 10);
        System.out.println("创建方式：new GregorianCalendar(2008, 8, 8, 6, 10)");
        System.out.println("日期时间：" + CalendarTest.toFriendlyString(c4));
        System.out.println();

        // 参数含义依次为：年、月、日、时、分、秒
        Calendar c5 = new GregorianCalendar(2008, Calendar.AUGUST, 8, 18, 10, 5);
        System.out.println("创建方式：new GregorianCalendar(2008, 8, 8, 18, 10, 5)");
        System.out.println("日期时间：" + CalendarTest.toFriendlyString(c5));

        Calendar c = Calendar.getInstance();
        System.out.println("当前时刻：" + CalendarTest.toFriendlyString(c));
        System.out.println();

        System.out.println("属性名称：Calendar.AM_PM");
        System.out.println("代表含义：上下午标识，上午返回Calendar.AM=0，下午返回Calendar.PM=1");
        System.out.println("测试结果：" + c.get(Calendar.AM_PM));
        System.out.println();

        System.out.println("属性名称：Calendar.DATE");
        System.out.println("代表含义：一个月中的第几天，同Calendar.DAY_OF_MONTH");
        System.out.println("测试结果：" + c.get(Calendar.DATE));
        System.out.println();

        System.out.println("属性名称：Calendar.DAY_OF_MONTH");
        System.out.println("代表含义：一个月中的第几天，同Calendar.DATE");
        System.out.println("测试结果：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println();

        System.out.println("属性名称：Calendar.DAY_OF_WEEK");
        System.out.println("代表含义：一周中的第几天，对应星期几，第一天为星期日，于此类推。");
        System.out.println("星期日:Calendar.SUNDAY=1");
        System.out.println("星期一:Calendar.MONDAY=2");
        System.out.println("星期二:Calendar.TUESDAY=3");
        System.out.println("星期三:Calendar.WEDNESDAY=4");
        System.out.println("星期四:Calendar.THURSDAY=5");
        System.out.println("星期五:Calendar.FRIDAY=6");
        System.out.println("星期六:Calendar.SATURDAY=7");
        System.out.println("测试结果：" + c.get(Calendar.DAY_OF_WEEK));
        System.out.println();

        System.out.println("属性名称：Calendar.DAY_OF_WEEK_IN_MONTH");
        System.out.println("代表含义：这一天所对应的星期几在该月中是第几次出现");
        System.out.println("测试结果：" + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println();

        System.out.println("属性名称：Calendar.DAY_OF_YEAR");
        System.out.println("代表含义：一年中的第几天");
        System.out.println("测试结果：" + c.get(Calendar.DAY_OF_YEAR));
        System.out.println();
        System.out.println("属性名称：Calendar.HOUR");
        System.out.println("代表含义：12小时制下的小时数，中午和午夜表示为0");
        System.out.println("测试结果：" + c.get(Calendar.HOUR));
        System.out.println();

        System.out.println("属性名称：Calendar.HOUR_OF_DAY");
        System.out.println("代表含义：24小时制下的小时数，午夜表示为0");
        System.out.println("测试结果：" + c.get(Calendar.HOUR_OF_DAY));
        System.out.println();

        System.out.println("属性名称：Calendar.MILLISECOND");
        System.out.println("代表含义：毫秒数");
        System.out.println("测试结果：" + c.get(Calendar.MILLISECOND));
        System.out.println();
        System.out.println("属性名称：Calendar.MINUTE");
        System.out.println("代表含义：分钟");
        System.out.println("测试结果：" + c.get(Calendar.MINUTE));
        System.out.println();

        System.out.println("属性名称：Calendar.MONTH");
        System.out.println("代表含义：月份，从0到11表示12个月份，比实际月份值小1");
        System.out.println("测试结果：" + c.get(Calendar.MONTH));
        System.out.println();

        System.out.println("属性名称：Calendar.SECOND");
        System.out.println("代表含义：秒");
        System.out.println("测试结果：" + c.get(Calendar.SECOND));
        System.out.println();

        System.out.println("属性名称：Calendar.WEEK_OF_MONTH");
        System.out.println("代表含义：一个月中的第几个星期");
        System.out.println("测试结果：" + c.get(Calendar.WEEK_OF_MONTH));
        System.out.println();

        System.out.println("属性名称：Calendar.WEEK_OF_YEAR");
        System.out.println("代表含义：一年中的第几个星期");
        System.out.println("测试结果：" + c.get(Calendar.WEEK_OF_YEAR));
        System.out.println();

        System.out.println("属性名称：Calendar.YEAR");
        System.out.println("代表含义：年份");
        System.out.println("测试结果：" + c.get(Calendar.YEAR));
        System.out.println();

        /**
         * Date Calendar 相互转换
         * getTime : Calendar --> Date
         * setTime : Date --> Calendar
         *
         * 想要输出原始的字母 两个连续的单引号将输出一个单引号结果 双引号需要转义
         */
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("'YEAR': yyyy 'MONTH': '''MM''' 'DAY': \"dd\" ");
        System.out.println(sdf.format(now));
        System.out.println();

        try {
            String s = "2008-08-08";
            System.out.println("原始字符串：" + s);
            String pattern = "yyyy-MM-dd";
            System.out.println("对应表达式：" + pattern);
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            Date date = df.parse(s);
            System.out.println("转换后的值：" + date);
            System.out.println();

            s = "05年2月12日 18:04:33";
            System.out.println("原始字符串：" + s);
            pattern = "yy年M月d日 HH:mm:ss";
            System.out.println("对应表达式：" + pattern);
            df.applyPattern(pattern);
            date = df.parse(s);
            System.out.println("转换后的值：" + date);
            System.out.println();

            s = "16/5/2004 20:7:2.050";
            System.out.println("原始字符串：" + s);
            pattern = "d/M/yyyy HH:m:s.SSS";
            System.out.println("对应表达式：" + pattern);
            df.applyPattern(pattern);
            date = df.parse(s);
            System.out.println("转换后的值：" + date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
