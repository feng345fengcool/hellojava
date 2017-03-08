package indi.chen.hellojava.basic;

public class Singleton {

    private static Singleton instance = null;

    private Singleton() {

    }

    /**
     * 这是普遍的做法
     */
    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    public static Singleton getInstanceMore() {
        return SingletonHolder.instance;
    }

    /**
     * 比较犀利的做法
     */
    private static class SingletonHolder {
        public final static Singleton instance = new Singleton();
    }
}