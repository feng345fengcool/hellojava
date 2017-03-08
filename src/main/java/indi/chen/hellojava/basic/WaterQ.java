package indi.chen.hellojava.basic;

import java.util.LinkedList;
import java.util.Queue;

class W {
    int curA;
    int curB;
    W before;

    public W(int curA, int curB) {
        super();
        this.curA = curA;
        this.curB = curB;
    }
}

public class WaterQ {

    private static int capA = 3;

    private static int capB = 4;

    private static int target = 1;

    private static W result;

    private static void bfs() {

        Queue<W> que = new LinkedList<W>();
        W w = new W(0, 0);
        w.before = null;

        que.offer(w);

        while (!que.isEmpty()) {
            W now = que.poll();
            int curA = now.curA;
            int curB = now.curB;

            if (curA == target || curB == target) {
                result = now;
                return;
            }

            if (curA + curB >= target) {

                // A倒满B
                if (curA + curB >= capB) {
                    W e = new W(curA + curB - capB, capB);
                    e.before = now;
                    que.offer(e);
                }

                // B倒满A
                if (curA + curB >= capA) {
                    W e = new W(capA, curA + curB - capA);
                    e.before = now;
                    que.offer(e);
                }

                // A 倒完
                if (curA + curB <= capB) {
                    W e = new W(0, curA + curB);
                    e.before = now;
                    que.offer(e);
                }

                // B 倒完
                if (curA + curB <= capA) {
                    W e = new W(curA + curB, 0);
                    e.before = now;
                    que.offer(e);
                }
            }

            // A 清空
            if (curA > 0) {
                W e = new W(0, curB);
                e.before = now;
                que.offer(e);
            }

            // B清空
            if (curB > 0) {
                W e = new W(curA, 0);
                e.before = now;
                que.offer(e);
            }

            // A装满
            if (curA < capA) {
                W e = new W(capA, curB);
                e.before = now;
                que.offer(e);
            }
            // B装满
            if (curB < capB) {
                W e = new W(curA, capB);
                e.before = now;
                que.offer(e);
            }

        }
    }

    public static void main(String[] args) {
        bfs();
        if (result != null) {
            while (result != null) {
                System.out.println(result.curA + " " + result.curB);
                result = result.before;
            }
        }
    }
}