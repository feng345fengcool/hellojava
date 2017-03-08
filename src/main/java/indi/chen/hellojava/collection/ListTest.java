package indi.chen.hellojava.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ListTest {

    private List<String> alist;
    private List<String> blist;
    private String[] strArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    @Before
    public void startup() {
        alist = new ArrayList<String>() {
            {
                for (int i = 0; i <= 10; i++) {
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
    public void testShuffle() {
        /**
         * 基于数组的API和基于集合的API之间的桥梁
         * 允许数组作为List查看 List修改数组修改
         * 数组修改List修改
         * 数组无List的通用实现
         * 没有实现add remove操作
         * 数组不能改变大小
         */
        List<String> list = Arrays.asList(strArr);
        /**
         * 所有排列出现的几率是相同的 既公平 又迅速
         */
        Collections.shuffle(list);
        System.out.println(list);
    }

    @Test
    public void testListIterator() {
        /**
         * it.next() it.previous() 返回跳过的元素
         * it.set() 设置跳过的元素
         * it.remove() 删除跳过的元素
         * it.add() 在跳过元素的位置增加元素
         */
        // 反向迭代
        for (ListIterator<String> it = alist.listIterator(alist.size()); it.hasPrevious(); ) {
            System.out.println(it.previous());
        }
        // 正向迭代 + 修改元素
        for (ListIterator<String> it = blist.listIterator(); it.hasNext(); ) {
            if ("10".equals(it.next())) {
                it.set("100");
            }
        }
        // 删除元素 + 增加元素
        for (ListIterator<String> it = blist.listIterator(); it.hasNext(); ) {
            if ("100".equals(it.next())) {
                it.remove();
                for (String str : strArr) {
                    it.add(str);
                }
            }
        }
    }

    @Test
    public void testRangeView() {
        // 对子列表的修改会反映到原列表
        alist.subList(0, 5).clear();
        startup();
        // 元素的索引是子列表中的索引
        System.out.println(alist.subList(0, 5).indexOf("4"));
        System.out.println(alist.subList(5, 11).lastIndexOf("10"));
    }

    private <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }

    @Test
    public void testDeal() {
        int numHands = 4;
        int cardsPerHand = 5;

        String[] suit = new String[]{"spades", "hearts", "diamonds", "clubs"};
        String[] rank = new String[]{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

        List<String> deck = new ArrayList<String>();
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck.add(rank[j] + " of " + suit[i]);
            }
        }

        Collections.shuffle(deck);

        for (int i = 0; i < numHands; i++) {
            System.out.println(dealHand(deck, cardsPerHand));
        }
    }

    @Test
    public void testAlgorithm() {
        List<String> list = Arrays.asList(strArr);
        Collections.reverse(list);
        Collections.sort(list);

        /**
         * 向左旋转一步
         */
        Collections.rotate(list, list.size() - 1);
        String[] array = list.toArray(new String[list.size()]);
    }
}