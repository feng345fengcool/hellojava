package indi.chen.hellojava.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.util.*;

public class ObjectSortTest {

    // 排序因子
    static final Comparator<Employee> SENIORITY_ORDER = new Comparator<Employee>() {

        @Override
        public int compare(Employee o1, Employee o2) {
            // 自定义排序
            int dateCmp = o2.hireDate().compareTo(o1.hireDate());
            if (dateCmp != 0)
                return dateCmp;
            // 自然排序
            return o1.number().compareTo(o2.number());
        }

    };

    // 员工数据库
    static final Collection<Employee> employees = new ArrayList<Employee>() {
        {
            add(new Employee(new Name("shuai", "chen"), -110061070, new Date(1989, 7, 31)));
            add(new Employee(new Name("zhigang", "mao"), 110061071, new Date(1988, 6, 24)));
            add(new Employee(new Name("jianhai", "lin"), 110061072, new Date(1989, 7, 31)));
            add(new Employee(new Name("yiming", "wei"), 110061073, new Date(1988, 2, 25)));
            add(new Employee(new Name("nannan", "shang"), 110061074, new Date(1988, 1, 25)));
            add(new Employee(new Name("xiaoliang", "xu"), 110061075, new Date(1976, 3, 20)));
        }
    };

    @Before
    public void startup() {
    }

    @Test
    /**
     * 自然排序
     */
    public void testNameSort() {
        // 默认初始化 Name[] nameArray = new Name[5];
        /**
         *  动态初始化
         *  Name[] nameArray;
         *  nameArray = new Name[4];
         *  nameArray[0] = new Name("John","Lennon");
         *  nameArray[1] = new Name("John","Lennon");
         *  nameArray[2] = new Name("John","Lennon");
         *  nameArray[3] = new Name("John","Lennon");
         */
        // 静态初始化
        Name[] nameArray = {
                new Name("John", "Lennon"),
                new Name("Karl", "Marx"),
                new Name("Groucho", "Marx"),
                new Name("Oscar", "Grouch")
        };
        List<Name> names = Arrays.asList(nameArray);
        Collections.sort(names);
        System.out.println(names);
    }

    @Test
    /**
     * 自定义排序
     */
    public void testEmpSort() {
        List<Employee> e = new ArrayList<Employee>(employees);
        Collections.sort(e, SENIORITY_ORDER);
        for (Employee temp : e) {
            System.out.println(temp.name());
        }
    }

    // 1. SimpleDateFormat parse 方法 和 format 方法
    // 2. 使用标准的日期格式化过程
    @Test
    public void testDate() {
        Date date = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT, DateFormat.SHORT);
        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM, DateFormat.MEDIUM);
        DateFormat longDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG);
        DateFormat fullDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.FULL, DateFormat.FULL);

        System.out.println(shortDateFormat.format(date));
        System.out.println(mediumDateFormat.format(date));
        System.out.println(longDateFormat.format(date));
        System.out.println(fullDateFormat.format(date) + "\n");

        /**
         *
         *
         * Calendar cal = Calendar.getInstance();
         * Date date = cal.getTime();
         *
         * Date date = new Date();
         * Calendar cal = Calendar.getInstance();
         * cal.setTime(date);
         *
         * Date date = new Date();
         * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         * System.out.println(df.format(date));
         *
         *
         */
        Calendar d1 = Calendar.getInstance();
        d1.set(2013, 6, 24, 14, 02, 02);
        Calendar d2 = Calendar.getInstance();
        d2.set(2014, 6, 25, 14, 03, 03);
        System.out.println(getDaysBetween(d1, d2));
    }

    private int getDaysBetween(Calendar d1, Calendar d2) {
        if (d1.after(d2)) {
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    @After
    public void shutdown() {

    }

}
