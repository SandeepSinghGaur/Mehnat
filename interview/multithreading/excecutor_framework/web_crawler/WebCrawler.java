package interview.multithreading.excecutor_framework.web_crawler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebCrawler {
    private Set<String> visitedUrls = new HashSet<>();
    private ExecutorService executor;
    private static final int MAX_DEPTH = 2;

    public WebCrawler() {
        executor = Executors.newFixedThreadPool(10);
    }

    public void crawl(String url, int depth) {
        if (depth <= MAX_DEPTH && !visitedUrls.contains(url)) {
            visitedUrls.add(url);
            executor.submit(() -> {
                try {
                    System.out.println(STR."Crawling: \{url}");
                    // Download page content and extract links
                    Set<String> links = getLinks(url);
                    // Recursively crawl linked pages
                    for (String link : links) {
                        crawl(link, depth + 1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private Set<String> getLinks(String url) throws IOException {
        // Dummy method to extract links from a web page
        return new HashSet<>();
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();
        crawler.crawl("https://www.linkedin.com/feed/", 0);
        crawler.shutdown();
    }
}