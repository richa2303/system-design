package com.example.practice.system_design.java9_14example.completable_future;

import java.util.concurrent.CompletableFuture;

public class ConcurrencyExample3 {

    public static void main(String[] args) throws Exception {
        // Two independent async tasks
        var nameFuture = CompletableFuture
                .supplyAsync(() -> { simulateWork(100); return "Alice"; });

        var scoreFuture = CompletableFuture
                .supplyAsync(() -> { simulateWork(150); return 95; });

        // thenCombine — runs when BOTH complete
        var result = nameFuture.thenCombine(
                scoreFuture,
                (name, score) -> name + " scored " + score + " points"
        );

        System.out.println(result.join()); // Alice scored 95 points

        // allOf — wait for multiple futures
        var f1 = CompletableFuture.supplyAsync(() -> "Task 1 done");
        var f2 = CompletableFuture.supplyAsync(() -> "Task 2 done");
        var f3 = CompletableFuture.supplyAsync(() -> "Task 3 done");

        CompletableFuture.allOf(f1, f2, f3).join();
        System.out.println(f1.join());
        System.out.println(f2.join());
        System.out.println(f3.join());
    }

    static void simulateWork(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
