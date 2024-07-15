package coreJava.multithreading.core_multithreading.print12TwentyTimes;

import java.util.concurrent.locks.Lock;

public class Print1 implements Runnable{
    private final Object lock;

    public Print1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        print1();

    }

    private void print1() {

        try {
            for (int i = 0; i < 20; i++) {
                synchronized (this.lock) {
                    System.out.printf(" 1 ");
                    this.lock.notify();
                    if (i < 19) {
                        this.lock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("Some thing Went Wrong");
        }


    }
}
