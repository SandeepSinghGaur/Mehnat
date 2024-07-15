package coreJava.multithreading.core_multithreading.print12TwentyTimes;


public class Print2 implements Runnable{
    private final Object lock;

    public Print2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        print2();
    }

    private void print2() {

        try {
            for (int i = 0; i < 20; i++) {
                synchronized (this.lock) {
                    System.out.printf(" 2 ");
                    this.lock.notify();
                    if (i < 19) {
                        System.out.printf("1");
                        this.lock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("Some thing Went Wrong");
        }

    }

}
