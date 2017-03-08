package indi.chen.hellojava.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {

    private SortedSet<String> sortedSet;

    @Before
    public void startup() {

        sortedSet = new TreeSet<String>() {
            {
                add("abandon");
                add("banana");
                add("clear");
                add("dog");
                add("egg");
                add("five");
                add("god");
                add("hello");
                add("idea");
                add("jack");
                add("kill");
            }
        };

    }

    @Test
    public void testSubSet() {
        System.out.println(sortedSet.subSet("abandon", "jack\0").size());
        System.out.println(sortedSet.subSet("abandon", "kill\0").size());

        sortedSet.subSet("ab", "ja\0").clear();
        System.out.println(sortedSet.size());

    }

    @Test
    public void testCountOfWord() {
        char ch = 'a';
        while (ch <= 'z') {
            String from = String.valueOf(ch++);
            String to = String.valueOf(ch);
            System.out.println(from + ": " + sortedSet.subSet(from, to));
        }
    }

    @After
    public void shutdown() {

    }

}
