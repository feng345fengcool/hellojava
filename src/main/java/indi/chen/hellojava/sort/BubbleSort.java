package indi.chen.hellojava.sort;

public class BubbleSort {

    public static void bubbleSortOne(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bubbleSortTwo(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static void bubbleSortThree(int[] a) {
        int j, k;
        int flag = a.length - 1;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (j = 0; j < k; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = j;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSortThree(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
