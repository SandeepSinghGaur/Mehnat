package interview.multithreading.core_multithreading.syncronization;

public class ClassLevelLock {
    public static void main(String[] args) {
        Runnable task = () -> {
          SyncronizedClass.m1(Thread.currentThread().getName());
          SyncronizedClass.m2(Thread.currentThread().getName());
          SyncronizedClass.m3(Thread.currentThread().getName());
          SyncronizedClass s = new SyncronizedClass();
          s.m4(Thread.currentThread().getName());
          s.m5(Thread.currentThread().getName());
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();


    }
}
