package HOMEWORKS_2SEM.Dhw26;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{

    private static final Lock lock = new ReentrantLock();

    private int start;
    private int end;
    private int[] arr;

    MyThread(int start, int end, int[] arr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            lock.lock();
            Main.mainSum += arr[i];
            lock.unlock();
        }
    }
}
