package coreJava.executor_framework.excecutor_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class SumArrayWithThreads {

    private static final int ARRAY_SIZE = 1000;
    private static final int RANGE_MIN = 100000;
    private static final int RANGE_MAX = 1000000;
    private static final int NUM_THREADS = 6; // You can adjust this based on your CPU cores

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Generate the random array
        int[] array = new Random().ints(ARRAY_SIZE, RANGE_MIN, RANGE_MAX).toArray();

        // Measure the time taken to calculate the sum
        long startTime = System.nanoTime();

        // Calculate the sum using multithreading
        long sum = calculateSumWithThreads(array);

        long endTime = System.nanoTime();

        // Print the sum and time taken
        System.out.println("Sum of array: " + sum);
        System.out.println("Time taken (milliseconds): " + ((endTime - startTime) / 1_000_000));

    }

    private static long calculateSumWithThreads(int[] array) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        int chunkSize = (int) Math.ceil((double) array.length / NUM_THREADS);
        AtomicLong totalSum = new AtomicLong(0);
        List<Future<Long>> futures = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);
            futures.add(executorService.submit(new SumTask(array, start, end)));
        }

        for (Future<Long> future : futures) {
            totalSum.addAndGet(future.get());
        }

        executorService.shutdown();

        return totalSum.get();
    }
}