package interview.multithreading.core_multithreading.yield;

public class MyThread implements Runnable{
    @Override
    public void run() {

        Thread.currentThread().setPriority(2);
        System.out.println(STR."Child thread priority\{Thread.currentThread().getPriority()}");
        Thread.yield();
        for(int i=0;i<10;i++){
            System.out.println(STR."This is Child Class\{Thread.currentThread().getName()}"+" "+i);
        }

    }
}
