package designPattern.multithreading.printEvenOdd;

public class Driver {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        Thread evenThread = new Thread(new PrintEven(printNumber));
        Thread oddThread = new Thread(new PrintOdd(printNumber));
        oddThread.start();
        evenThread.start();
    }
}
