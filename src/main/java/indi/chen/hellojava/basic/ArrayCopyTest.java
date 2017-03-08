package indi.chen.hellojava.basic;

import java.util.Arrays;

public class ArrayCopyTest {

    public static int[] cloneCopy(int src[]) {
        return src.clone();
    }

    public static int[] arrayCopy(int src[]) {
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }

    public static void main(String[] args) {
        int[] src = {1, 3, 5, 7, 9};
        System.out.println(String.valueOf(Arrays.asList(src)));
        // 使用clone方法 得到数组的值 而不是引用 不能复制指定元素 灵活性较差
        int[] destone = cloneCopy(src);
        System.out.println(String.valueOf(Arrays.asList(destone)));

        // 使用System.arraycopy(src,srcPos,dest,destPos,length)方法 推荐使用
        int[] desttwo = arrayCopy(src);
        System.out.println(String.valueOf(Arrays.asList(desttwo)));
    }
}