package designPattern.multithreading.syncronization;

public class SyncronizedDemo {
    public static void main(String[] args) {
        Display d = new Display();
        Display d1 = new Display();
        MyThread t1 = new MyThread(d,"Dhoni");
        MyThread t2 = new MyThread(d1,"Yuvraj");
        t1.start();
        t2.start();
    }
}
