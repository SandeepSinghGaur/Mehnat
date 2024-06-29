package coreJava.executor_framework.excecutor_framework.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentUserHandlingExample {

    public static void main(String[] args) throws InterruptedException {
        // Assuming 2000 concurrent users
        int concurrentUsers = 2000;

        // Create a thread pool with enough threads to handle the load
        ExecutorService executor = Executors.newFixedThreadPool(2000);

        // Simulate concurrent user requests
        for (int i = 0; i < concurrentUsers; i++) {
            int userId = i + 1;
            executor.submit(() -> handleUserRequest(userId));
        }

        // Shutdown the executor after all tasks are submitted
        executor.shutdown();

        // Wait for all tasks to complete or timeout after a specified time
        executor.awaitTermination(10, TimeUnit.MINUTES);
    }

    // Method to handle each user request asynchronously
    private static void handleUserRequest(int userId) {
        CompletableFuture<Void> userRequest = CompletableFuture.runAsync(() -> {
            // Simulate processing for the user request
            System.out.println("Handling request for User " + userId + " - Thread: " + Thread.currentThread().getName());
            try {
                // Simulate some processing time
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Handle completion or error scenarios if required
        userRequest.handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Error handling request for User " + userId + ": " + ex.getMessage());
            } else {
                System.out.println("Request for User " + userId + " handled successfully");
            }
            return result;
        });
    }
}
