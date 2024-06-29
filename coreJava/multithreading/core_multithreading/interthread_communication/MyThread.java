package coreJava.multithreading.core_multithreading.interthread_communication;

public class MyThread implements Runnable{
    @Override
    public void run() {
        try{
           for(int i=1;i<=10;i++){
               System.out.println("I am Lazy Thread");
               Thread.sleep(100);
           }
        }catch (InterruptedException e) {
            System.out.println("I am Interrupted Thread");
           // throw new RuntimeException(e);
        }
    }
}
