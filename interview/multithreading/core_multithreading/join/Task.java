package interview.multithreading.core_multithreading.join;

public class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(STR."\{Thread.currentThread().getName()} is executing");
            try {
                Thread.sleep(500); // Simulate some work with sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}