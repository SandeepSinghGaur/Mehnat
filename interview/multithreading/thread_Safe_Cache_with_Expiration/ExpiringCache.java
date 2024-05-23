package interview.multithreading.thread_Safe_Cache_with_Expiration;


import java.util.concurrent.*;

class ExpiringCache<K, V> {
    private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<K, ScheduledFuture<?>> expirations = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final long expirationTime;

    public ExpiringCache(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public void put(K key, V value) {
        cancelExpiration(key);  // Cancel any existing expiration
        cache.put(key, value);
        scheduleExpiration(key);  // Schedule a new expiration
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void remove(K key) {
        cancelExpiration(key);  // Cancel any existing expiration
        cache.remove(key);
    }

    private void scheduleExpiration(K key) {
        ScheduledFuture<?> future = scheduler.schedule(() -> {
            cache.remove(key);
            expirations.remove(key);
            System.out.println("Expired: " + key);
        }, expirationTime, TimeUnit.MILLISECONDS);
        expirations.put(key, future);
    }

    private void cancelExpiration(K key) {
        ScheduledFuture<?> future = expirations.remove(key);
        if (future != null) {
            future.cancel(false);
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}