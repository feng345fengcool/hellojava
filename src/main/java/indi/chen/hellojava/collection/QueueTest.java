package indi.chen.hellojava.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class QueueTest {

    private List<String> alist;

    @Before
    public void startup() {
        for (int i = 0; i < 26; i++) {
            System.out.println((char) ('a' + i));

        }
        alist = new ArrayList<String>() {
            {
                for (int i = 0; i < 26; i++) {
                    // 不符合自动转换 (byte short char --> int --> long --> float --> double) 需要进行强制转换
                    add(String.valueOf((char) ((int) 'z' - i)));
                }
            }
        };
    }

    /**
     * 方法的两种形式：1. 失败抛出异常; 2. 失败返回特殊值 ( null | false )
     * 一、添加: add(IllegalStateException)	offer(false)
     * PS:
     * 1. 由于null被用作poll和peak方法的特殊返回值, 不允许插入null元素
     * 2. offer只用于有界队列
     * <p>
     * 二、删除: remove(NoSuchElementException) poll(null)
     * <p>
     * 三、找头: element(NoSuchElementException) peek(null)
     */

    // java.util.concurrent 中的一些Queue实现是有界的
    // java.util.concurrent.BlockingQueue 中定义了Queue接口没有定义的阻塞队列的方法 在并发编程中很常见 等待元素的出现或者等待空间可用
    @Test
    public void testQueue() throws InterruptedException {
        int time = 10;
        // 类结构 : Queue --> Deque --> LinkedList
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = time; i >= 0; i--) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            Thread.sleep(1000);
        }
    }

    @Test
    public void testPriorityQueue() {
        Queue<String> queue = new PriorityQueue<String>(alist);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

}
