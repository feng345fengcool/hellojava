package indi.chen.hellojava.basic;

public class ArrayWall {

    public static void main(String[] args) {

        int[] data = {2, 5, 1, 2, 3, 4, 7, 6, 7};
        System.out.println(process(data));

    }

    private static int process(int[] data) {
        if (data == null || data.length < 3) {
            return 0;
        }
        int leftMax = data[0];
        int leftIndex = 0;
        int rightMax = data[data.length - 1];
        int rightIndex = data.length - 1;

        int count = 0;
        while (leftIndex < rightIndex) {
            if (leftMax < rightMax) {
                leftIndex++;
                if (data[leftIndex] > leftMax) {
                    leftMax = data[leftIndex];
                } else {
                    count += leftMax - data[leftIndex];
                }
            } else {
                rightIndex--;
                if (data[rightIndex] > rightMax) {
                    rightMax = data[rightIndex];
                } else {
                    count += rightMax - data[rightIndex];
                }
            }
        }
        return count;

    }

}
