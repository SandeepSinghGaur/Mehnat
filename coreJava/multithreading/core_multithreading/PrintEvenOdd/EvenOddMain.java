package coreJava.multithreading.core_multithreading.PrintEvenOdd;

public class EvenOddMain {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new PrintOddEven(lock),"Even");
        Thread t2 = new Thread(new PrintOddEven(lock),"Odd");
        t1.start();
        t2.start();
    }

}
