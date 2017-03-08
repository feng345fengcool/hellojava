package indi.chen.hellojava.basic;

public class LongestNotRepeat {

    public static int longestNotRepeat(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int check = 0;
            for (int j = 0; i + j < s.length(); j++) {
                int v = s.charAt(i + j) - 'a';
                if ((check & (1 << v)) != 0) {
                    break;
                }
                check |= (1 << v);
                ans = Math.max(ans, j + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abcedfghijklmnopqrstuvwxxl";
        System.out.println(longestNotRepeat(str));
    }
}
