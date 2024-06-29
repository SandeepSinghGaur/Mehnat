package coreJava.multithreading.core_multithreading.join;

public class JoinExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(), "Thread-1");
        Thread thread2 = new Thread(new Task(), "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Main thread waits for thread1 to finish
            System.out.println("Thread-1 has finished executing");

            thread2.join(); // Main thread waits for thread2 to finish
            System.out.println("Thread-2 has finished executing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have finished executing");
    }


}
