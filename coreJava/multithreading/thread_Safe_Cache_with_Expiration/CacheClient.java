package coreJava.multithreading.thread_Safe_Cache_with_Expiration;

class CacheClient implements Runnable {
    private final ExpiringCache<String, String> cache;

    public CacheClient(ExpiringCache<String, String> cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                String key = STR."key\{i}";
                String value = STR."value\{i}";
                cache.put(key, value);
                System.out.println(STR."\{Thread.currentThread().getName()} put: \{key} = \{value}");
                Thread.sleep(500);  // Simulate work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
