package coreJava.executor_framework.excecutor_framework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApiExecutor {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(12);

        // CompletableFuture for calling API 1, 10 times
        CompletableFuture<?>[] api1Futures = new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            CompletableFuture.runAsync(() -> callApi1(), threadPool);
        }

        // CompletableFuture for calling API 2
        CompletableFuture.runAsync(() -> callApi2(), threadPool);

        // CompletableFuture for calling API 3
         CompletableFuture.runAsync(() -> callApi3(), threadPool);

        // Wait for all futures to complete


        threadPool.shutdown();
    }

    private static void callApi1() {
        System.out.println("Calling API 1");
        try {
            Thread.sleep(1000); // Simulate API call delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void callApi2() {
        System.out.println("Calling API 2");
        try {
            Thread.sleep(1000); // Simulate API call delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void callApi3() {
        System.out.println("Calling API 3");
        try {
            Thread.sleep(1000); // Simulate API call delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
