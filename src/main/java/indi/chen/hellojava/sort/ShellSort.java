package indi.chen.hellojava.sort;

public class ShellSort {

    public static void shellSortOne(int a[]) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < a.length; j++) {
                    int temp = a[j];

                    int k = j - gap;
                    while (k >= 0 && temp < a[k]) {
                        a[k + gap] = a[k];
                        k -= gap;
                    }
                    a[k + gap] = temp;
                }
            }
        }
    }

    public static void shelloSortTwo(int a[]) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int temp = a[i];
                int k = i - gap;
                while (k >= 0 && temp < a[k]) {
                    a[k + gap] = a[k];
                    k -= gap;
                }

                a[k + gap] = temp;
            }
        }
    }

    public static void shellSortThree(int a[]) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i - gap; j >= 0 && a[j + gap] < a[j]; j -= gap) {
                    swap(a, j, j + gap);
                }
            }

        }
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        shellSortThree(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
