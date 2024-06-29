package coreJava.multithreading.core_multithreading.sleep;

public class SleepExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
    }


}
