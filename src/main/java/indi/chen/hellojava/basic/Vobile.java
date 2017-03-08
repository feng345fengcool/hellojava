package indi.chen.hellojava.basic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vobile {
    /**
     * 判断是对象还是数组
     * 如果是对象+++
     * ①脱去双括号 如果是第一次输出xml之后输出Object
     * ②以逗号分割为字符串数组
     * ③分析每个字符串有一下三件事情
     * 一、判断字符串的值是什么类型 以确定键是什么样的显示格式
     * 二、如果值是数字、字符串类型 输出 Item type 并注意调节insertIndex
     * 三、如果值是数组、对象直接进行递归
     * 如果是数组+++
     * ①脱去方括号 输出Array
     * ②以逗号分割为字符串数组
     * ③分析每个字符串有以下三件事情
     * 一、判断字符串的值是什么类型 以确定键是什么样的显示格式
     * 二、如果值是数字、字符串类型 输出 Item type index 并注意调节insertIndex
     * 三、如果值是数组、对象直接进行递归
     * <p>
     * 不能使用split函数了 可以使用stack来层层剥去括号 来分割字符串
     */

    private static StringBuffer sb = new StringBuffer();

    private static int insertIndex = 0;

    public static String getResult() {
        return sb.toString();
    }

    private static String checkType(String str) {
        str = str.trim();
        char ch = str.charAt(0);
        if (Character.isDigit(ch)) {
            return "NUM";
        } else if (Character.isLetter(ch)) {
            return "STR";
        } else if (ch == '{') {
            return "OBJ";
        } else if (ch == '[') {
            return "ARR";
        } else {
            return null;
        }
    }

    public static void process(String jsonStr) {
        String type = checkType(jsonStr);
        jsonStr = jsonStr.substring(1, jsonStr.length() - 1);
        String temp;
        if (type.equals("OBJ")) {
            if (sb.length() == 0) {
                temp = "<xml>\n\t<Object>\n";
                sb.insert(insertIndex, temp);
                insertIndex += temp.length();
                temp = "\t</Object>\n</xml>\n";
                sb.insert(insertIndex, temp);
            } else {
                temp = "\t<Object>\n";
                sb.insert(insertIndex, temp);
                insertIndex += temp.length();
                temp = "\t<Object>\n";
                sb.insert(insertIndex, temp);
            }
        } else {
            temp = "\t<Array>\n";
            sb.insert(insertIndex, temp);
            insertIndex += temp.length();
            temp = "\t</Array>\n";
            sb.insert(insertIndex, temp);
        }

        String[] strs = jsonStr.split(",");
        int count = 0;
        for (String s : strs) {
            String[] t = s.split(":");
            String ttype = checkType(t[1].trim());

            if (ttype.equals("STR") || ttype.equals("NUM")) {
                String xtype = null;
                if (ttype.equals("STR")) {
                    xtype = "string";
                } else {
                    xtype = "number";
                }
                temp = "\t<Item type=\"" + xtype + "\"";
                if (type.equals("ARR")) {
                    count++;
                    temp += " index=" + count + ">";
                } else {
                    temp += ">";
                }
                sb.insert(insertIndex, temp);
                insertIndex += temp.length();
                temp = "\t</Item>";
                sb.insert(insertIndex, temp);
            } else if (ttype.equals("OBJ")) {
                process(t[1].trim());
            } else if (ttype.equals("ARR")) {
                process(t[1].trim());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(
                Vobile.class.getResource("json.txt").getPath())));
        String source = bufr.readLine();
        process(source);
        System.out.println(getResult());

    }
}