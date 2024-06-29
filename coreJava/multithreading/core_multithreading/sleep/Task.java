package coreJava.multithreading.core_multithreading.sleep;

public class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(STR."\{Thread.currentThread().getName()} is executing");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(STR."\{Thread.currentThread().getName()} was interrupted");
            }
        }
    }
}