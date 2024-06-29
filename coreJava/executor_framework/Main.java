package coreJava.executor_framework;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Random random = new Random();
        int min = 1; // 100k
        int max = 10; // 1000k

        // Generate a random integer between min (inclusive) and max (exclusive)
        int[] arr = new int[1000];
        for(int i=0;i<10;i++){
            arr[i] = random.nextInt((max - min) + 1) + min;
        }




        System.out.println(executorService.submit(new CallableService(arr)).get());
    }
}
