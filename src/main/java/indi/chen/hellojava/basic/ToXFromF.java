package indi.chen.hellojava.basic;

import java.util.HashSet;
import java.util.Set;

public class ToXFromF {

    private static Set<Integer> set = new HashSet<Integer>();
    private static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) {
        int zi = 1;
        int mu = 8;
        System.out.println(process(zi, mu));

    }

    private static String xhj(int zi, int mu) {
        StringBuilder sbtmp = new StringBuilder("");
        Set<Integer> settmp = new HashSet<Integer>();
        settmp.add(zi);
        while (true) {
            if (zi < mu) {
                zi *= 10;
            }
            while (zi < mu) {
                zi *= 10;
                sbtmp.append("0");
            }
            int shang = zi / mu;
            int yushu = zi % mu;
            boolean success = settmp.add(yushu);
            sbtmp.append(shang);
            if (!success) {
                return sbtmp.toString();
            } else {
                zi = yushu;
            }
        }
    }

    private static String process(int zi, int mu) {
        if (zi == mu) {
            return "1";
        }
        int zs = 0;
        if (zi > mu) {
            zs = zi / mu;
            zi %= mu;
        }
        sb.append(zs);
        sb.append(".");

        set.add(zi);
        while (true) {
            if (zi < mu) {
                zi *= 10;
            }
            while (zi < mu) {
                zi *= 10;
                sb.append("0");
            }
            int shang = zi / mu;
            int yushu = zi % mu;
            if (yushu == 0) {
                sb.append(shang);
                return sb.toString();
            } else {
                boolean success = set.add(yushu);
                sb.append(shang);
                if (!success) {
                    String xhj = xhj(yushu, mu);
                    int firstIndex = sb.indexOf(xhj);
                    sb.insert(firstIndex, '(');
                    sb.insert(sb.length(), ')');
                    return sb.toString();
                } else {
                    zi = yushu;
                }
            }
        }
    }

}
