package coreJava.multithreading.core_multithreading.print12TwentyTimes;

import coreJava.executor_framework.excecutor_framework.printNumber.Print2;

public class PrintNumber {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new Print1(lock));
        Thread t2 = new Thread(new Print2(lock));
        t1.start();
        t2.start();
    }
}
