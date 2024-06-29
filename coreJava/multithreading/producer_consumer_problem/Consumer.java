package coreJava.multithreading.producer_consumer_problem;

import java.util.List;

public class Consumer implements Runnable {
    private final List<Integer> taskQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {
            while (taskQueue.isEmpty()) {
                System.out.println("Queue is empty, consumer thread is waiting for producer to put something in queue");
                taskQueue.wait();
            }

            Thread.sleep(1000);
            int i = taskQueue.remove(0);
            System.out.println(STR."Consumed: \{i}");
            taskQueue.notifyAll();
        }
    }
}

