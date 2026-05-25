package com.example.practice.system_design.java9_14example.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ConcurrencyExample1 {

    public static void main(String[] args) throws Exception {
        // orTimeout() — Java 9 addition
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    simulateWork(200); // fast — completes before timeout
                    return "User data loaded successfully";
                })
                .orTimeout(5, TimeUnit.SECONDS)
                .exceptionally(ex -> "TIMEOUT or ERROR: " + ex.getMessage());

        System.out.println("Result: " + future.join());

        // Demonstrate timeout — slow task
        CompletableFuture<String> slow = CompletableFuture
                .supplyAsync(() -> {
                    simulateWork(3000); // slow — will timeout
                    return "This never arrives";
                })
                .orTimeout(1, TimeUnit.SECONDS)
                .exceptionally(ex -> "TIMED OUT after 1s");

        System.out.println("Slow:   " + slow.join());
    }

    static void simulateWork(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
