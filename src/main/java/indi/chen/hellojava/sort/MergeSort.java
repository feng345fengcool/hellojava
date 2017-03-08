package indi.chen.hellojava.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(a);
        mergesort(a);
        printArray(a);
    }

    private static void mergesort(int[] a) {
        sort(a, 0, a.length - 1);

    }

    private static void sort(int[] a, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            sort(a, left, mid);
            sort(a, mid + 1, right);
            merge(a, left, mid, right);
        }

    }

    private static void merge(int[] a, int left, int mid, int right) {
        int i = left, m = mid;
        int j = mid + 1, n = right;

        int[] temp = new int[a.length];
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }

        for (i = 0; i < k; i++) {
            a[left + i] = temp[i];
        }
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

}