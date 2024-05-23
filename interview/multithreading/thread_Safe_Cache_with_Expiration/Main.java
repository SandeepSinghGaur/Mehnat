package interview.multithreading.thread_Safe_Cache_with_Expiration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExpiringCache<String, String> cache = new ExpiringCache<>(3000);  // Entries expire after 3000 ms

        Thread client1 = new Thread(new CacheClient(cache), "Client-1");
        Thread client2 = new Thread(new CacheClient(cache), "Client-2");

        client1.start();
        client2.start();

        client1.join();
        client2.join();

        // Wait some time to see expiration in action
        Thread.sleep(10000);

        cache.shutdown();
    }
}