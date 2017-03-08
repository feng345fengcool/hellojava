package indi.chen.hellojava.sort;

public class HeapSort {

    public static int len;

    public static void heapSort(int[] a) {
        buildHeap(a);
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            len--;
            heapify(a, 0);
        }
    }

    private static void heapify(int[] a, int i) {
        int largest = i;
        int left = getLeft(i);
        int right = getRight(i);
        if (left < len && a[largest] < a[left]) {
            largest = left;
        }
        if (right < len && a[largest] < a[right]) {
            largest = right;
        }

        if (i == largest) {
            return;
        } else {
            swap(a, i, largest);
            heapify(a, largest);
        }

    }

    private static int getRight(int i) {
        return (i << 1) + 2;
    }

    private static int getLeft(int i) {
        return (i << 1) + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void buildHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, i);
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 5, 1, 7, 5, 3, 2, 5, 8, 1, 4, 7, 3, 6, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        len = a.length;
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}