https://medium.com/javarevisited/java-completablefuture-c47ca8c885af

# CompletableFuture: `join()` vs `get()`

## `future1.join()`

```java
String result1 = future1.join();

Usage: join() is a method specific to CompletableFuture that blocks the current thread until the result of future1 is available.
Behavior:
If future1 has already completed (either normally or exceptionally), join() returns the result immediately.
If future1 has not yet completed, join() will wait until the future completes and then return the result.
Unlike get(), join() does not throw checked exceptions (InterruptedException, ExecutionException); instead, it wraps any exceptions in an unchecked CompletionException.

Blocking Nature: It blocks the current thread until future1 completes, but it does not wait for all dependent futures to complete.


allFutures.get()

try {
    allFutures.get(); // Wait for all futures to complete
} catch (Exception e) {
    e.printStackTrace();
}
Usage: get() is a method from the java.util.concurrent.Future interface (which CompletableFuture implements) that waits for the computation to complete and then retrieves its result.
Behavior:
It blocks the current thread until all futures in allFutures have completed, including both normal completion and exceptions.
get() throws InterruptedException if the current thread is interrupted while waiting and ExecutionException if any of the futures complete exceptionally.
Handling Exceptions: You must handle checked exceptions (InterruptedException, ExecutionException) explicitly when using get().
Key Differences:
Exception Handling:

join() wraps exceptions in CompletionException, making it easier to handle them in a functional style.
get() requires explicit handling of InterruptedException and ExecutionException, which might complicate the code.
Blocking Behavior:

join() blocks only for the specific CompletableFuture it is called on.
get() blocks until all futures in allFutures have completed, making it suitable for waiting on multiple futures concurrently.
Choosing Between join() and get():
Single Future: Use join() for simplicity and cleaner exception handling when waiting on a single CompletableFuture.
Multiple Futures: Use allFutures.get() when waiting for all futures to complete or when you need to handle exceptions across multiple futures in a centralized manner.
Example:
java
Copy code
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            // Simulating a long-running operation
            return "Result 1";
        });

        String result1 = future1.join(); // Wait for future1 to complete
        System.out.println("Result 1: " + result1);

        // Or, if dealing with multiple futures:
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            // Simulating another long-running operation
            return "Result 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            // Simulating yet another long-running operation
            return "Result 3";
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        try {
            allFutures.get(); // Wait for all futures (future1, future2, future3) to complete
            String result2 = future2.get();
            String result3 = future3.get();
            System.out.println("Result 2: " + result2);
            System.out.println("Result 3: " + result3);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
In summary, future1.join() is simpler for waiting on a single future, while allFutures.get() is more appropriate for waiting on multiple futures and handling their completion or exceptions together. Choose based on your specific concurrency requirements and how you plan to manage the completion of asynchronous tasks in your application.