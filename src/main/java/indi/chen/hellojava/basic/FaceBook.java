package indi.chen.hellojava.basic;

import java.util.ArrayList;
import java.util.List;

public class FaceBook {

    public static void main(String[] args) {
        String str = "thiisss iss a sennnntttenceee";
        List<Character> result = process(str);
        System.out.println(result);
    }

    private static List<Character> process(String str) {
        List<Character> list = new ArrayList<Character>();
        int max = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            int j = i;
            // 有相同字符的一个段 从j到i
            while (i + 1 < str.length() && str.charAt(i) != ' ' && str.charAt(i + 1) == str.charAt(i)) {
                i++;
            }
            // 判断长度是否大于max 清空list 加入list
            if (max < i - j + 1) {
                max = i - j + 1;
                list.clear();
                list.add(str.charAt(i));
            } else if (max == i - j + 1) {
                list.add(str.charAt(i));
            }
        }
        return list;
    }
}

