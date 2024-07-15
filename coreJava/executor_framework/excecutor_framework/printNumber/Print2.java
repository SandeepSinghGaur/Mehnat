package coreJava.executor_framework.excecutor_framework.printNumber;

public class Print2 implements Runnable {
    private final Object lock;

    public Print2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                synchronized (lock) {
                    System.out.print("2 ");
                    lock.notify(); // Notify other thread to print
                    System.out.printf("1 ");
                    if (i < 19) {
                        lock.wait(); // Wait for notification to proceed
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

