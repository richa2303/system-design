package com.example.practice.system_design.java9_14example.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ConcurrencyExample2 {

    public static void main(String[] args) throws Exception {
        // Fast path — returns before timeout
        var fast = CompletableFuture
                .supplyAsync(() -> { simulateWork(100); return "Alice (fresh from DB)"; })
                .completeOnTimeout("Alice (from cache)", 2, TimeUnit.SECONDS)
                .thenApply(v -> v.contains("cache") ? "[CACHED] " + v : v);

        System.out.println("Fast:  " + fast.join());

        // Slow path — cache kicks in
        var slow = CompletableFuture
                .supplyAsync(() -> { simulateWork(3000); return "Bob (fresh from DB)"; })
                .completeOnTimeout("Bob (from cache)", 1, TimeUnit.SECONDS)
                .thenApply(v -> v.contains("cache") ? "[CACHED] " + v : v);

        System.out.println("Slow:  " + slow.join());
    }

    static void simulateWork(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
