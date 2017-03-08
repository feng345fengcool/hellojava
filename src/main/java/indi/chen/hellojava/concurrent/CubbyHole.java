package indi.chen.hellojava.concurrent;

/**
 * Created by chenshuai on 16-10-11.
 */

// 读者写者问题 写者优先
public class CubbyHole {

    private int readerCount;
    private int writerCount;

    private boolean reading;
    private boolean writing;

    public CubbyHole() {
        readerCount = 0;
        writerCount = 0;
        reading = false;
        writing = false;
    }

    // 只要有人在写就等待
    public synchronized int startRead() {
        ++readerCount;
        while (writerCount > 0) {
            try {
                System.out.println("Reader is waiting ...");
                wait();
            } catch (Exception e) {
                // ignore
            }
        }
        if (readerCount > 0) {
            reading = true;
        }
        return readerCount;
    }

    // 读完释放信号
    public synchronized int endRead() {
        --readerCount;
        if (readerCount == 0) {
            reading = false;
        }
        notifyAll();
        return readerCount;
    }

    // 只要有人在读或者写就等待
    public synchronized int startWrite() {
        while (reading || writing) {
            try {
                System.out.println("Writer is waiting ...");
                wait();
            } catch (Exception e) {
                // ignore
            }
        }
        ++writerCount;
        return writerCount;
    }

    // 写完释放信号
    public synchronized void endWrite() {
        --writerCount;
        writing = false;
        notifyAll();
    }


}
