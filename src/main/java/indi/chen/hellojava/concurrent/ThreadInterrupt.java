package indi.chen.hellojava.concurrent;

public class ThreadInterrupt extends Thread {

    private volatile boolean stop = false;

    public static void main(String args[]) throws Exception {
        ThreadInterrupt thread = new ThreadInterrupt();
        System.out.println("Starting Thread ...");
        thread.start();
        System.out.println("Asking thread to stop...");
//        thread.stop = true;
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    public void run() {
        while (!stop) {
            System.out.println("Thread running...");
            try {
                System.out.println("###");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted...");
            }
        }
        System.out.println("Thread exiting under request...");
    }
}
