package indi.chen.hellojava.basic;

public class ClimbStairs {

    // getStepNum(n,m) = getStepNum(n-1,m) + getStepNum(n-2,m) + ... + getStepNum(n-m,m);
    public static int getStepNum(int n, int m) {
        if (n == 0) {
            return 1;
        }
        if (n < m) {
            return getStepNum(n, n);
        } else {
            int stepNum = 0;
            for (int i = 1; i <= m; i++) {
                stepNum += getStepNum(n - i, m);
            }
            return stepNum;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int maxStep = 1;
        System.out.println(getStepNum(n, maxStep));
    }

}
