package indi.chen.hellojava.basic;

public class BIT {

    private static int len = 11;

    private static int[] sumArr = new int[len];

    private static int lowbit(int i) {
        return i & (-i);
    }

    private static int getResult(int end) {
        int sum = 0;
        while (end > 0) {
            sum += sumArr[end];
            end -= lowbit(end);
        }
        return sum;
    }

    private static void modify(int i, int delta) {
        while (i < len) {
            sumArr[i] += delta;
            i += lowbit(i);
        }
    }

    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
            modify(i, i);
        }

        for (int i = 1; i < 11; i++) {
            System.out.println(getResult(i));
        }

    }

}
