package coreJava.multithreading.core_multithreading.syncronization;

public class SyncronizedClass {


    public static synchronized void m1(String name) {
        System.out.println("static Synchronized m1 method executed by"+" "+name);
    }

    public static synchronized void m2(String name) {
        System.out.println("static Synchronized m2 method executed by"+" "+name);
    }

    public static void m3(String name) {
        System.out.println("static m3 method executed by"+" "+name);
    }

    public synchronized void m4(String name) {
        System.out.println("synchronized m4 method executed by"+" "+name);
    }

    public void m5(String name) {
        System.out.println("Instance m5 method executed by"+" "+name);
    }

}
