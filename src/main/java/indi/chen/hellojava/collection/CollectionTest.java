package indi.chen.hellojava.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

    private List<String> alist;
    private List<String> blist;

    @Before
    public void startup() {
        alist = new ArrayList<String>() {
            {
                for (int i = 0; i <= 10; i++) {
                    System.out.println("\"" + i + "\",");
                    add(i + "");
                }
            }
        };

        blist = new ArrayList<String>() {
            {
                for (int i = 10; i <= 20; i++) {
                    add(i + "");
                }
            }
        };
    }

    @Test
    public void testCastArray() {
        /**
         * 基于数组的API和基于集合的API之间的桥梁
         */
        Object[] aarray = alist.toArray();
        for (Object o : aarray) {
            System.out.println(o);
        }
        /**
         * 使用new String[0]效率较低 JVM需要根据Collection实际大小重新分配空间 因此使用new
         * String[blist.size()]效率较高
         */
        String[] barray = blist.toArray(new String[blist.size()]);
        for (String s : barray) {
            System.out.println(s);
        }
    }

    @Test
    public void testFilter() {
        // 过滤
        for (Iterator<?> it = alist.iterator(); it.hasNext(); ) {
            if (it.next() == "10") {
                it.remove();
            }
        }
        // 遍历
        for (Iterator<?> it = alist.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }

    @Test
    public void testBulkOperation() {
        // containsAll
        System.out.println(alist.containsAll(blist));
        // addAll
        alist.addAll(blist);
        // removeAll
        startup();
        alist.removeAll(blist);
        // retainAll
        startup();
        alist.retainAll(blist);
        // clear
        startup();
        alist.clear();
    }

    @Test
    public void testSingleton() {
        for (int i = 0; i < 10; i++) {
            alist.add(null);
            alist.add("10");
        }
        alist.removeAll(Collections.singleton("10"));
        // Collections.singleton 静态工厂方法 返回一个只包含制定元素的不可变的Set
        alist.removeAll(Collections.singleton(null));
    }
}
