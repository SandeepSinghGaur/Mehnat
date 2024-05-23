package interview.multithreading.producer_consumer_problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> taskQueue = new LinkedList<>();
        int MAX_CAPACITY = 5;
        Thread producer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread consumer = new Thread(new Consumer(taskQueue), "Consumer");
        producer.start();
        consumer.start();
    }
}

