package indi.chen.hellojava.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Thread.interrupted(); thread.interrupt(); thread.isInterrupted();
public class ThreadInterrupt2 extends Thread {

    public static void main(String args[]) throws Exception {
        ThreadInterrupt2 thread = new ThreadInterrupt2();
        System.out.println("Starting Thread ...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Interrupting thread ...");
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    public void run() {
        ServerSocket socket;
        try {
            socket = new ServerSocket(7856);
        } catch (IOException e) {
            System.out.println("Could not create the socket...");
            return;
        }
        while (true) {
            System.out.println("Waiting for connection...");
            try {
                Socket sock = socket.accept();
            } catch (IOException e) {
                System.out.println("accept() failed or interrupted...");
            }
        }
    }
}
