package interview.multithreading.core_multithreading.interthread_communication;

public class InterruptThread {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread);
        t.start();
        t.interrupt();
        System.out.println("End of Main Thread");
    }
}
