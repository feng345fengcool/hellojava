package indi.chen.hellojava.basic;

import java.util.ArrayList;
import java.util.HashMap;

public class GoolgeThread {

    public static void main(String[] args) {
        Runnable t = new Task();
        // 创建4个进程
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(t);
            thread.setName(String.valueOf(i));
            thread.start();
        }
    }

    // 为了便于阅读代码 定义静态内部类
    private static class Task implements Runnable {

        // 定义用于多线程共享的变量
        private int index = 0;
        private int max = 8;
        private int count = 0;
        private boolean isRunning = true;

        private HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        {
            {
                for (int i = 0; i < 4; i++) {
                    map.put(i, new ArrayList<Integer>());
                }
            }
        }

        @Override
        public synchronized void run() {

            int name = Integer.valueOf(Thread.currentThread().getName());

            // 多线程一贯的写作手法 while(true)
            while (true) {
                // 进来先判断是否结束
                if (!isRunning) {
                    return;
                }
                // 多线程一贯的写作手法 while(condition)
                while (index % 4 != name) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 比较好的结束线程的方式 让线程一醒来就去死
                    if (!isRunning) {
                        return;
                    }
                }

                // 线程要做的事情
                for (int i = 0; i < 4; i++) {
                    int size = map.get(i).size();
                    if (size >= 0 && size < max) {
                        if (size == 0 && i == name) {
                            map.get(i).add(name + 1);
                            count++;
                        } else if (size > 0) {
                            map.get(i).add(name + 1);
                            count++;
                        }
                    }
                }

                System.out.println("A:" + map.get(0));
                System.out.println("B:" + map.get(1));
                System.out.println("C:" + map.get(2));
                System.out.println("D:" + map.get(3));
                System.out.println("当前线程 "
                        + (Integer.valueOf(Thread.currentThread().getName()) + 1) + "当前数目" + count);
                System.out.println();
                index++;

                // 当满足一定条件的时候 安装结束状态 随时结束生命
                if (count >= 32) {
                    isRunning = false;
                }

                // 唤醒所有的其他进程
                this.notifyAll();
            }
        }
    }

}
