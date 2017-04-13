package indi.chen.hellojava.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * Created by chenshuai on 2017/4/13.
 */
public class NioTest {

    public static void main(String[] args) throws Exception {
        TunnelScheduler ts = new TunnelScheduler();
        ts.start();
        Thread.sleep(5000);
        ts.bind();
        while (true) {
            Thread.sleep(1000);
        }
    }

    private static class TunnelScheduler {

        private Selector selector;
        private IOScheduler scheduler;
        private Thread worker;
        private String regLock = new String("reg-lock");

        private void start() throws IOException {
            selector = Selector.open();
            scheduler = new IOScheduler(selector, regLock);
            worker = new Thread(scheduler);
            worker.setName("tunnel-scheduler");
            worker.start();
        }

        private void bind() throws Exception {
            int port = 65500;
            try {
                while (port++ <= 65530) {
                    long start = System.currentTimeMillis();
                    synchronized (regLock) {
                        SocketAddress addr = new InetSocketAddress("0.0.0.0", port);
                        DatagramChannel dc = DatagramChannel.open();
                        dc.configureBlocking(false);
                        dc.socket().bind(addr);
                        dc.socket().setReceiveBufferSize(1024 * 8);
                        dc.socket().setSendBufferSize(1024 * 4);
                        scheduler.wakeup(regLock);
                        dc.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                    }
                    long end = System.currentTimeMillis();
                    System.out.println("bind port ::: " + port + ", exec time ::: " + (end - start) + "ms");
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                //
            }
        }

        private static class IOScheduler implements Runnable {
            private final Selector selector;
            private String regLock = null;

            public IOScheduler(Selector s, String regLock) {
                this.selector = s;
                this.regLock = regLock;
            }

            public void wakeup(String regLock) {
                this.regLock = regLock;
                if (selector != null) {
                    selector.wakeup();
                }
            }

            private void wait4register() {
                if (regLock != null) {
                    synchronized (regLock) {
                    }
                }
            }

            @Override
            public void run() {

                while (selector != null) {
                    try {
                        int count = selector.select(1000L);
                        System.out.println("count ::: " + count);
                        wait4register();
                        if (count == 0) {
                            continue;
                        }
                    } catch (IOException e) {
                        //
                    }
                    Iterator<SelectionKey> keyItr = selector.selectedKeys().iterator();
                    while (keyItr.hasNext()) {
                        SelectionKey key = keyItr.next();
                        keyItr.remove();
                        try {
                            if (key.isValid() && key.isReadable()) {
                                System.out.println("process read key");
                            }

                            if (key.isValid() && key.isWritable()) {
                                System.out.println("process write key");
                            }
                        } catch (Exception e) {
                            //
                        }

                        try {
                            if (!key.isValid()) {
                                key.cancel();
                            }
                        } catch (Exception e) {
                            //
                        }
                    }
                }

            }
        }
    }

}
