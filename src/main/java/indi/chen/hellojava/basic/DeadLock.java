package indi.chen.hellojava.basic;

class Test implements Runnable {
    private boolean flag;

    public Test(boolean flag) {
        super();
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (MyLock.locka) {
                    System.out.println("if locka");
                    synchronized (MyLock.lockb) {
                        System.out.println("if lockb");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (MyLock.lockb) {
                    System.out.println("else lockb");
                    synchronized (MyLock.locka) {
                        System.out.println("else locka");
                    }
                }
            }
        }
    }
}

class MyLock {
    static final Object locka = new Object();
    static final Object lockb = new Object();
}

public class DeadLock {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Test(true));
        Thread t2 = new Thread(new Test(false));
        t1.start();
        t2.start();
    }
}
