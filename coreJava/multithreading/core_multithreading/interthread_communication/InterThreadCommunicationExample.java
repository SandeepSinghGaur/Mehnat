package coreJava.multithreading.core_multithreading.interthread_communication;

public class InterThreadCommunicationExample {
    private static final Object lock = new Object();
    private static boolean conditionMet = false;

    public static void main(String[] args) {
        Thread waitingThread = new Thread(new WaitingTask());
        Thread notifyingThread = new Thread(new NotifyingTask());

        waitingThread.start();
        try {
            Thread.sleep(1000); // Ensure waitingThread starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyingThread.start();
    }

    static class WaitingTask implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (!conditionMet) {
                    try {
                        System.out.println("Waiting for condition to be met...");
                        lock.wait(); // Release lock and wait
                        System.out.println("after wait next line is not excecuting immediately this thread went to wait state");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Condition met! Proceeding with task...");
            }
        }
    }

    static class NotifyingTask implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                conditionMet = true;
                lock.notify(); // Notify one waiting thread
                System.out.println("Condition has been met, notified waiting thread.");
            }
        }
    }
}
