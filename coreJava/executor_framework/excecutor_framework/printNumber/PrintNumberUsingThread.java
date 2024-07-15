package coreJava.executor_framework.excecutor_framework.printNumber;


public class PrintNumberUsingThread {
    public static void main(String[] args) {
        Object lock = new Object(); // Shared lock object for synchronization

        Thread thread1 = new Thread(new Print1(lock));
        Thread thread2 = new Thread(new Print2(lock));

        thread1.start();
        thread2.start();
    }
}




