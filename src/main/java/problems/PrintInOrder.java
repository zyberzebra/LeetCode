package problems;

import lombok.NoArgsConstructor;

/**
 * <a href="https://leetcode.com/problems/print-in-order/">print-in-order</a>
 */
@NoArgsConstructor
public class PrintInOrder {

    private final Object lock = new Object();
    private int nextThreadToExecute = 1;

    public void first(Runnable printFirst) {
        synchronized (lock) {
            printFirst.run();
            nextThreadToExecute = 2;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while(nextThreadToExecute != 2) {
                lock.wait();
            }
            printSecond.run();
            nextThreadToExecute = 3;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while(nextThreadToExecute != 3) {
                lock.wait();
            }
            printThird.run();
            nextThreadToExecute = 3;
            lock.notifyAll();
        }
    }
}
