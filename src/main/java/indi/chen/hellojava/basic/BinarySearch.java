package indi.chen.hellojava.basic;

public class BinarySearch {

    // Collections 标准二分查找
    private static int indexBinarySearch(int a[], int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midValue = a[mid];
            if (midValue < key) {
                low = mid + 1;
            } else if (midValue > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 10, 15, 20, 25, 28, 30, 35, 40, 45, 50, 55};
        System.out.println(indexBinarySearch(a, 28));
    }

}
