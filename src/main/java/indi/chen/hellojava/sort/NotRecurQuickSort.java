package indi.chen.hellojava.sort;

import java.util.Stack;

public class NotRecurQuickSort {

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(a);
        quickSort(a, 0, a.length - 1);
        printArray(a);
    }

    private static void quickSort(int[] a, int low, int high) {
        Stack<Integer> stack = new Stack<Integer>();
        if (low < high) {
            int mid = partition(a, low, high);
            if (low < mid - 1) {
                stack.push(low);
                stack.push(mid - 1);
            }
            if (mid + 1 < high) {
                stack.push(mid + 1);
                stack.push(high);
            }

            while (!stack.empty()) {
                int q = stack.pop();
                int p = stack.pop();
                mid = partition(a, p, q);
                if (p < mid - 1) {
                    stack.push(p);
                    stack.push(mid - 1);
                }
                if (mid + 1 < q) {
                    stack.push(mid + 1);
                    stack.push(q);
                }
            }
        }

    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] > pivot) {
                high--;
            }
            if (low < high) {
                a[low++] = a[high];
            }
            while (low < high && a[low] < pivot) {
                low++;
            }
            if (low < high) {
                a[high--] = a[low];
            }
        }
        a[low] = pivot;
        return low;
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
