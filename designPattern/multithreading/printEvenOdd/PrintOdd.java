package designPattern.multithreading.printEvenOdd;

public class PrintOdd implements Runnable{
    PrintNumber printNumber;

    PrintOdd(PrintNumber printNumber){
        this.printNumber = printNumber;
    }
    @Override
    public void run() {
        synchronized (printNumber.lock){
            while(printNumber.number<= printNumber.printMax){
                while(printNumber.number%2==0){
                    try {
                        printNumber.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                if(printNumber.number%2!=0){
                    System.out.println("Odd:: "+printNumber.number);
                    printNumber.number++;
                    printNumber.lock.notify();
                }
            }
        }
    }
}
