package indi.chen.hellojava.basic;

public class Anagram {

    private static boolean isAnagram(String s, String t) {
        if ("".equals(s) || "".equals(t)) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] c = new int[256];
        for (int i = 0; i < s.length(); i++) {
            ++c[(int) s.charAt(i)];
            --c[(int) t.charAt(i)];
        }

        for (int i = 0; i < 256; i++) {
            if (c[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aeiou";
        String t = "ieauo";

        System.out.println(isAnagram(s, t));
    }

}
