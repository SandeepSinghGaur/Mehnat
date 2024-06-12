package interview.multithreading.core_multithreading.yield;

public class ThreadYieldDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        System.out.println(STR."thread priority\{Thread.currentThread().getPriority()}");
        for (int i=11;i<20;i++){
            System.out.println(STR."This is Parent Thread\{Thread.currentThread().getName()}"+" "+i);
        }
    }
}
