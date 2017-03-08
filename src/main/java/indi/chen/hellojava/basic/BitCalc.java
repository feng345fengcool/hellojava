package indi.chen.hellojava.basic;

public class BitCalc {

    // 奇偶
    private static boolean isEven(int x) {
        return (x & 1) != 1;
    }

    // 取反
    private static int signReversal(int x) {
        return ~x + 1;
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                System.out.print(" " + a[i]);
            } else {
                System.out.print(a[i]);
            }
        }
        System.out.println();
    }

    // 交换数组中两个数
    private static void reverseArray(int[] a) {

        printArray(a);
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            swap(a, left, right);
            left++;
            right--;
        }
        printArray(a);
    }

    private static void swap(int[] a, int left, int right) {
        if (a[left] != a[right]) {
            a[left] ^= a[right];
            a[right] ^= a[left];
            a[left] ^= a[right];
        }
    }

    // 取绝对值
    private static int getAbs(int x) {
        int i = x >> 31;
        return ((x ^ i) - i);
    }

    // 素数筛法
    private static void getPrimer(int x) {
        int[] flag = new int[x / 32 + 1];
        int[] primer = new int[x / 3 + 1];
        int count = 0;
        for (int i = 2; i <= x; i++) {
            // 由内而外写括号
            if (((flag[i / 32] >> (i % 32)) & 1) == 0) {
                primer[count++] = i;
                for (int j = i + i; j <= x; j += i) {
                    flag[j / 32] |= (1 << (j % 32));
                }
            }
        }
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                System.out.print(" " + primer[i]);
            } else {
                System.out.print(primer[i]);
            }
        }
        System.out.println();
    }

    // 二进制逆序
    private static void ReverseTest(int x) {
        System.out.println(Integer.toBinaryString(x));
        int result = Integer.reverse(x);
        System.out.println(Integer.toBinaryString(result));
    }

    public static void main(String[] args) {

    }

}
