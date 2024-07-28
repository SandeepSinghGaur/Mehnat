package coreJava.multithreading.core_multithreading.interthread_communication.PrintEvenOdd;

public class PrintOddEven implements Runnable{
    private static int count = 1;
    private final Object lock;

    public PrintOddEven(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        while(count<=10){
            if(count%2!=0 && Thread.currentThread().getName().equals("Odd")){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" "+count);
                    count++;
                    lock.notify();

                }
            }
            if(count%2==0 && Thread.currentThread().getName().equals("Even")){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" "+count);
                    count++;
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        throw  new RuntimeException("Some thing went wrong");
                    }

                }
            }
        }
    }
}
