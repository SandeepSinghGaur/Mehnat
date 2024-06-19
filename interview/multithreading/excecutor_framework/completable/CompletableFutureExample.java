package interview.multithreading.excecutor_framework.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;


public class CompletableFutureExample {

    public static void main(String[] args) throws Exception {
        // Generate a random array of 1000 elements within the range 100000 to 1000000
        int[] array = generateRandomArray(1000, 100000, 1000000);

        // Number of threads to use (adjust as needed)
        int numberOfThreads = Runtime.getRuntime().availableProcessors();

        // Split array into chunks for concurrent processing
        int chunkSize = (int) Math.ceil((double) array.length / numberOfThreads);

        // Create an executor service with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Start time
        long startTime = System.nanoTime();

        // List of CompletableFuture to store results of sum calculation
        CompletableFuture<Long>[] futures = new CompletableFuture[numberOfThreads];

        // Process each chunk concurrently
        for (int i = 0; i < numberOfThreads; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);

            // CompletableFuture to calculate sum of chunk
            futures[i] = CompletableFuture.supplyAsync(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            }, executor);
        }

        // Combine all CompletableFuture results to get final sum
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);

        // Using an AtomicLong to accumulate sum from all chunks
        AtomicLong totalSum = new AtomicLong(0);

        // Wait for all CompletableFuture tasks to complete
        allFutures.thenRun(() -> {
            for (CompletableFuture<Long> future : futures) {
                totalSum.addAndGet(future.join()); // Add each chunk's sum to totalSum
            }
            // End time
            long endTime = System.nanoTime();
            long elapsedTimeInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

            // Print results
            System.out.println("Total Sum: " + totalSum.get());
            System.out.println("Time Taken: " + elapsedTimeInMillis + " milliseconds");

            // Shutdown executor
            executor.shutdown();
        }).get(); // Blocking call to wait for all CompletableFuture tasks to finish
    }

    // Method to generate a random array of given size within specified range
    private static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        return random.ints(size, min, max + 1).toArray();
    }
}
