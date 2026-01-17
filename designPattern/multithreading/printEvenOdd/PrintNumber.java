package designPattern.multithreading.printEvenOdd;

public class PrintNumber {
    int number = 1;
    final int max = 100;
    final Object lock = new Object();
}
