package indi.chen.hellojava.collection;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MapTest {

    // linkedHashMap 顺序
    private Map<String, Integer> linkedHashMap;
    // hashMap 混序
    private Map<String, Integer> hashMap;
    // treeMap 字典序
    private Map<String, Integer> treeMap;

    private List<String> sList;

    /**
     * 一、基本操作 : put get remove containsKey containsValue size isEmpty
     * <p>
     * 二、批量操作 : putAll clear
     * <p>
     * 三、Collection视图 : 1. 提供键、值、键值对迭代	2. 迭代期间删除项目的安全方式
     */

    @Before
    public void startup() {
        sList = new ArrayList<String>() {
            {
                for (int i = 0; i < 15; i++) {
                    add(String.valueOf((char) ('a' + i)));
                }
                for (int i = 12; i < 26; i++) {
                    add(String.valueOf((char) ('a' + i)));
                }
            }
        };
    }

    @Test
    public void testFreq() {

        hashMap = new HashMap<String, Integer>();
        for (String s : sList) {
            // 一个小技巧：如果字符串没出现过 freq为null
            Integer freq = hashMap.get(s);
            hashMap.put(s, freq == null ? 1 : freq + 1);
        }

        System.out.println("hashmap output");
        System.out.println(hashMap.size() + " distinct words:");
        System.out.println(hashMap);

        treeMap = new TreeMap<String, Integer>(hashMap);
        System.out.println("treemap output");
        System.out.println(treeMap.size() + " distinct words:");
        System.out.println(treeMap);

        linkedHashMap = new LinkedHashMap<String, Integer>(hashMap);
        System.out.println("linkedhashmap output");
        System.out.println(linkedHashMap.size() + " distinct words:");
        System.out.println(linkedHashMap);

        // putAll 一个微妙的覆盖作用
        Map<String, Integer> overrides = new HashMap<String, Integer>() {
            {
                put("m", 4);
                put("n", 4);
                put("o", 4);
            }
        };
        treeMap.putAll(overrides);
    }

    // hashMap.keySet() treeMap.entrySet() linkedHashMap.values() 总是返回相同的对象
    // 遍历方式：1. keySet iterator 2. entrySet iterator 3. keySet 4. entrySet 5. values
    // 无破坏性
    // P324 java tutorials
    // static <K, V> boolean validate(Map<K, V> attrMap, Set<K> requiredAttrs, Set<K> permittedAttrs);
    // missing = requiredAttrs.removeAll(attrs);
    // illegal = attrs.removeAll(permittedAttrs);

    // 有破坏性
    // P325 java tutorials
    // managers.keySet().removeAll(values);
    // managers.values().removeAll(keySet);
    // managers.keySet().removeAll(Collections.singleton("xxx"));
    // managers.values().removeAll(Collections.singleton("xxx"));

    @Test
    public void testAnagrams() throws FileNotFoundException {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        BufferedReader reader = null;
        try {
            String fileName = "words.txt";
            reader = new BufferedReader(new FileReader(MapTest.class.getResource(fileName)
                    .getPath()));
            String word;
            while ((word = reader.readLine()) != null) {
                String alpha = alphabetize(word);
                List<String> l = m.get(alpha);
                if (l == null) {
                    // 注意这种写法
                    m.put(alpha, l = new ArrayList<String>());
                }
                l.add(word);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        List<List<String>> winners = new ArrayList<List<String>>();
        for (List<String> list : m.values()) {
            // 变位词组 输出前排序
            Collections.sort(list);
            if (list.size() >= 8)
                winners.add(list);
            Collections.sort(winners, new Comparator<List<String>>() {
                public int compare(List<String> o1, List<String> o2) {
                    /**
                     * 终于理解这里的自然 和 非自然的区别了
                     * 自然就是按照参数列表的顺序
                     * 非自然就是按照参数列表相反的顺序
                     * 至于大于 小于 等于 当然 对应 1 0 -1了
                     * 困惑已久 终于解开 不用死记硬背了
                     */
                    return o2.size() < o1.size() ? -1 : o2.size() == o1.size() ? 0 : 1;
                }
            });
        }
        for (List<String> list : winners) {
            System.out.println(list.size() + ": " + list);
        }
    }

    private String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

}
