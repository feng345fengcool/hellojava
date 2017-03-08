package indi.chen.hellojava.basic;

public class LongestPalindromeSubSequence {

    /**
     * 算法核心思想：
     * <p>
     * ··· ----|--j---id---i--mx---- ···
     * <p>
     * 上图已经解释的很明白了
     * <p>
     * 已知id的范围已经延伸至mx
     * <p>
     * 那么i的范围可以参考与id对称的j的范围
     * <p>
     * 那么最大是mx-i 最小是j的范围
     * <p>
     * j也就是i的对称点 亦即 2*id-i;
     */

    public static void main(String[] args) {

        // 最大回文子串是dfwswfd
        String str = "dadfwswfdsad";

        System.out.println(process(str));
    }

    private static String process(String str) {
        StringBuilder sb = new StringBuilder("$#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            sb.append("#");
        }

        int[] p = new int[sb.length()];
        int mx = 0;
        int id = 0;
        for (int i = 1; i < sb.length(); i++) {
            if (mx > i) {
                p[i] = Math.min(p[2 * id - i], mx - i);
            } else {
                p[i] = 1;
            }

            while (i + p[i] < sb.length() && i - p[i] >= 0
                    && sb.charAt(i + p[i]) == sb.charAt(i - p[i])) {
                p[i]++;
            }

            if (mx < p[i] + i) {
                mx = p[i] + i;
                id = i;
            }
        }

        int max = p[1];
        id = 1;
        for (int i = 2; i < sb.length(); i++) {
            if (p[i] > max) {
                id = i;
                max = p[i];
            }
        }

        return sb.substring(id - p[id] + 1, id + p[id]).replaceAll("#", "");
    }

}
