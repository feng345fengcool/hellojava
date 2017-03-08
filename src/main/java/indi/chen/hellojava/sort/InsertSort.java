package indi.chen.hellojava.sort;

public class InsertSort {

    public static void insertSortOne(int a[]) {
        int i, j;
        for (i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = temp;
            }
        }
    }

    public static void insertSortTwo(int a[]) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                swap(a, i, j);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertSortTwo(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
