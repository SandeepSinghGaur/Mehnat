package coreJava.multithreading.blockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int value = 0;
            while (true) {
                queue.put(value);
                System.out.println(STR."Produced: \{value}");
                value++;
                Thread.sleep(500); // Simulate time taken to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
