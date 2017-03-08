package indi.chen.hellojava.sort;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(a);
        quicksort(a);
        printArray(a);
    }

    private static void quicksort(int[] a) {
        sort(a, 0, a.length - 1);

    }

    private static void sort(int[] a, int left, int right) {
        if (left < right) {
            int index = partition(a, left, right);
            sort(a, left, index - 1);
            sort(a, index + 1, right);
        }

    }

    private static int partition(int[] a, int left, int right) {
        randomPartition(a, left, right);
        middleThreePartition(a, left, right);
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            if (left < right) {
                a[left++] = a[right];
            }
            while (left < right && a[left] < pivot) {
                left++;
            }
            if (left < right) {
                a[right--] = a[left];
            }
        }
        a[left] = pivot;
        return left;

    }

    private static void middleThreePartition(int[] a, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (a[left] > a[right]) {
            swap(a, left, right);
        }
        if (a[left] > a[mid]) {
            swap(a, left, mid);
        }
        if (a[mid] > a[left]) {
            swap(a, mid, left);
        }
    }

    private static void randomPartition(int[] a, int left, int right) {
        Random rnd = new Random();
        int index = rnd.nextInt(right - left + 1) + left;
        swap(a, index, left);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

}
