package coreJava.executor_framework.excecutor_framework.completable;

import java.util.concurrent.CompletableFuture;

public class StandardPatternInCompletable {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            // Simulating a long-running operation
            try {
                Thread.sleep(2000); // Sleep for 2 seconds to simulate a long task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            // Simulating a long-running operation
            try {
                Thread.sleep(3000); // Sleep for 3 seconds to simulate another long task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            // Simulating a long-running operation
            try {
                Thread.sleep(4000); // Sleep for 4 seconds to simulate yet another long task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result 3";
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        allFutures.thenRun(() -> {
            // All futures completed
            System.out.println("All futures completed!");

            // Example using thenAccept
            future1.thenAccept(result -> System.out.println("Future 1 result: " + result));

            // Example using thenApply
            CompletableFuture<Integer> combinedFuture = future2.thenApply(result -> result.length());
            combinedFuture.thenAccept(length -> System.out.println("Future 2 result length: " + length));

            // Example using thenCombine
            CompletableFuture<String> combinedFuture2 = future1.thenCombine(future3, (result1, result3) -> result1 + " and " + result3);
            combinedFuture2.thenAccept(combinedResult -> System.out.println("Combined result: " + combinedResult));
        });

        // Optionally, wait for all tasks to complete
        try {
            allFutures.get(); // Wait for all futures to complete
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

