package indi.chen.hellojava.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ScanSum {

    public static void main(String[] args) throws IOException {
        // 下面前三种是ClassLoader的方式
        System.out.println("Thread.currentThread().getContextClassLoader().getResource(\"\")\n"
                + Thread.currentThread().getContextClassLoader().getResource("") + "\n");

        System.out.println("ScanSum.class.getClassLoader().getResource(\"\")\n"
                + ScanSum.class.getClassLoader().getResource("") + "\n");

        System.out.println("ClassLoader.getSystemResource(\"\")\n"
                + ClassLoader.getSystemResource("") + "\n");

        // 下面两种是class的方式
        // "" 表示包路径
        // / 表示类路径
        System.out.println("ScanSum.class.getResource(\"\")\n" + ScanSum.class.getResource("")
                + "\n");

        System.out.println("ScanSum.class.getResource(\"/\")\n" + ScanSum.class.getResource("/")
                + "\n");

        Scanner s = null;
        double sum = 0;
        try {

            String fileName = "usnumbers.txt";
            // new FileReader("src/usnumbers.txt") 特别不推荐 不具有移植性
            s = new Scanner(new BufferedReader(new FileReader(ScanSum.class.getResource(fileName)
                    .getPath())));
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        System.out.format("%.2f%n", sum);
        System.out.format("%f, %1$+020.10f %n", Math.PI);
        System.out.format("%f, %<+020.10f %n", Math.PI);
    }
}
