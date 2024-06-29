package coreJava.executor_framework;

import java.util.concurrent.*;

public class ExampleOfRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> {
            System.out.println("Task 1 Completed");
        };
        Runnable task2 = ()->{
            System.out.println("Task 2 is Completed");
        };
        Callable<Integer> task3 = () -> {
            int c = 4+3;
            return c;
        };
        executorService.submit(task1);
        executorService.submit(task2);
        int ans = executorService.submit(task3).get();
        System.out.println(ans);

    }
}
