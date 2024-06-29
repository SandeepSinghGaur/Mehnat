package coreJava.executor_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExampleOfCallable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 12, 3, 34, 5, 5, 6, 6, 43, 5, 1, 11223, 12, 11};
        int n = arr.length / 10;

        List<Future<Integer>> futureList = new ArrayList<>();

        // Submitting tasks to process each segment of the array
        for (int i = 0; i < 10; i++) {
            int start = i * n;
            int end = (i + 1) * n;
            if (i == 9) {
                end = arr.length; // Adjusting the end index for the last segment
            }

            Callable<Integer> task = new ArraySumTask(arr, start, end);
            Future<Integer> future = executorService.submit(task);
            futureList.add(future);
        }

        // Collecting results from futures
        int totalSum = 0;
        for (Future<Integer> future : futureList) {
            try {
                totalSum += future.get(); // Blocking call to get the result of each task
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor service
        executorService.shutdown();

        // Output total sum of the array
        System.out.println(STR."Total sum of the array: \{totalSum}");
    }

    static class ArraySumTask implements Callable<Integer> {
        private final int[] arr;
        private final int start;
        private final int end;

        public ArraySumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }
}
