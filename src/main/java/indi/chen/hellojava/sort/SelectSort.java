package indi.chen.hellojava.sort;

public class SelectSort {

    public static void selectSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    private static void swap(int[] a, int i, int minIndex) {
        int temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
