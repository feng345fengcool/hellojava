package indi.chen.hellojava.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private String[] strArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "7", "8", "9"};

    @Test
    public void testBulkOperation() {
        // 只通过接口引用集合可以禁止程序使用任何非标准操作
        // 可以通过改变构造器来改变实现
        Set<String> uniques = new HashSet<String>();
        Set<String> dups = new HashSet<String>();
        for (String str : strArr) {
            // 添加元素的时候可以获得重复的元素
            // 添加结束的时候可以获得不重复的元素
            if (!uniques.add(str)) {
                dups.add(str);
            }
            uniques.removeAll(dups);
        }
        System.out.println("Unique words: " + uniques);
        System.out.println("Duplicte words: " + dups);
    }
}
