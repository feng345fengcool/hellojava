package indi.chen.hellojava.basic;

public class SnakeMatrix {

    private static int[][] printMatrixOne(int n) {
        int[][] array = new int[n][n];
        int row = 0, col = 0, m = 1;

        boolean isRow = true;

        for (int i = 0; i < (2 * n - 1); i++) {
            row = i;
            while (row >= ((i < n) ? 0 : i - n + 1)) {
                if (row > (n - 1)) {
                    row = n - 1;
                }
                col = i - row;
                if (isRow) {
                    array[col][row] = m;
                } else {
                    array[row][col] = m;
                }
                row--;
                m++;
            }
            isRow = !isRow;
        }

        return array;
    }

    private static int[][] printMatrixTwo(int n) {
        int[][] array = new int[n][n];
        int row = 0, col = 0, m = 1;
        int number1 = (n * n / 2 + n * n % 2);
        int number2 = n * n + 1;
        boolean isRow = false;

        for (int i = 0; m < number1; i++) {
            row = i;
            while (row >= 0) {
                col = i - row;
                if (isRow) {
                    array[row][col] = m;
                    array[n - row - 1][n - col - 1] = number2 - m;
                } else {
                    array[col][row] = m;
                    array[n - col - 1][n - row - 1] = number2 - m;
                }
                m++;
                if (m >= number1)
                    break;
                row--;
            }
            isRow = !isRow;
        }
        return array;

    }

    public static void main(String[] args) {

        int n = 20;
        int[][] array = printMatrixTwo(n);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j > 0) {
                    System.out.print("\t" + array[i][j]);
                } else {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println("\n");
        }
    }

}
