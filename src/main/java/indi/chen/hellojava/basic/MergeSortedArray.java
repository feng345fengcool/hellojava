package indi.chen.hellojava.basic;

public class MergeSortedArray {

    public static void main(String[] args) {
        int a[] = {2, 3, 5, 7, 11, 12, 0, 0, 0, 0, 0, 0, 0};
        int b[] = {1, 3, 4, 5, 6, 8, 9};

        mergeSortedArray(a, 6, b, 7);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void mergeSortedArray(int[] dest, int destLen, int[] src, int srcLen) {

        int k = dest.length - 1;
        int i = destLen - 1;
        int j = srcLen - 1;
        while (k >= 0) {
            if (j == -1 && i == 0) {
                dest[k--] = dest[i--];
                break;
            }
            if (i == -1 && j == 0) {
                dest[k--] = src[j--];
                break;
            }
            if (dest[i] > src[j]) {
                dest[k--] = dest[i--];
            } else if (dest[i] < src[j]) {
                dest[k--] = src[j--];
            } else {
                dest[k--] = dest[i--];
                dest[k--] = src[j--];
            }
        }
    }

}
