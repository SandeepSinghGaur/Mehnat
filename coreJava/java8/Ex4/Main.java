package coreJava.java8.Ex4;

public class Main {
    public static void main(String[] args) {
        Runnable r = ()->{
            System.out.println("Child Thread is Running");
        };
        r.run();
        System.out.println("Main Thread is Running");
    }
}
