package indi.chen.hellojava.concurrent;

/**
 * Created by chenshuai on 16-6-6.
 */
public class FalseSharing implements Runnable {

    public static final int NUM_THREADS = 4;
    public static final long ITERATIONS = 500L * 1000L * 1000L;
    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];

    static {
        for (int i = 0; i < NUM_THREADS; i++) {
            longs[i] = new VolatileLong();
        }
    }

    private final int arrayIndex;

    public FalseSharing(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(String[] args) throws InterruptedException {
        final long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + (System.nanoTime() - start) / 1000000);
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }


    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }

    }

    public final static class VolatileLong {
        public volatile long value = 0L;
//        public long p1, p2, p3, p4, p5, p6; // COMMENT OUT
    }
}
