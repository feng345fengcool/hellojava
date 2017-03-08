package indi.chen.hellojava.basic;

import java.io.UnsupportedEncodingException;

public class CutString {
    public static boolean isChineseChar(char c) throws UnsupportedEncodingException {
        return String.valueOf(c).getBytes("GBK").length > 1;
    }

    /**
     * 这里使用utf-8编码 主要原因在于本java文件的页面编码格式为utf-8
     * java文件中的硬编码自然是utf-8格式的
     * 由于汉字使用utf-8的方式进行存储 会使用三个字节 因此程序会有一些问题
     */

    public static String substring(String orignal, int count) throws UnsupportedEncodingException {
        if (orignal != null && !"".equals(orignal)) {
            orignal = new String(orignal.getBytes(), "UTF-8");
            if (count > 0 && count < orignal.getBytes("UTF-8").length) {
                StringBuilder buff = new StringBuilder();
                char c;
                for (int i = 0; i < count; i++) {
                    c = orignal.charAt(i);
                    buff.append(c);
                    if (CutString.isChineseChar(c)) {
                        --count;
                    }
                }
                return buff.toString();
            }
        }
        return orignal;
    }

    public static void main(String[] args) {
        String s = "我CS爱JAVA";
        System.out.println("原始字符串：" + s);
        try {
            System.out.println("截取前1位：" + CutString.substring(s, 1));
            System.out.println("截取前2位：" + CutString.substring(s, 2));
            System.out.println("截取前4位：" + CutString.substring(s, 4));
            System.out.println("截取前6位：" + CutString.substring(s, 6));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
