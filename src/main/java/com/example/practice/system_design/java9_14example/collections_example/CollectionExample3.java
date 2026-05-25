package com.example.practice.system_design.java9_14example.collections_example;

import java.util.Map;

public class CollectionExample3 {

    public static void main(String[] args) {
        // Map.of() only supports up to 10 entries
        // Use Map.ofEntries() for larger maps
        var httpCodes = Map.ofEntries(
                Map.entry("200_OK",              200),
                Map.entry("201_CREATED",         201),
                Map.entry("204_NO_CONTENT",      204),
                Map.entry("400_BAD_REQUEST",     400),
                Map.entry("401_UNAUTHORIZED",    401),
                Map.entry("403_FORBIDDEN",       403),
                Map.entry("404_NOT_FOUND",       404),
                Map.entry("409_CONFLICT",        409),
                Map.entry("422_UNPROCESSABLE",   422),
                Map.entry("429_RATE_LIMIT",      429),
                Map.entry("500_SERVER_ERROR",    500),
                Map.entry("503_UNAVAILABLE",     503)
        );

        System.out.println("Total codes: " + httpCodes.size()); // 12
        System.out.println("200 OK:      " + httpCodes.get("200_OK"));
        System.out.println("404:         " + httpCodes.get("404_NOT_FOUND"));
        System.out.println("500:         " + httpCodes.get("500_SERVER_ERROR"));

        // Stream over the map
        httpCodes.entrySet().stream()
                .filter(e -> e.getValue() >= 400)
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println("  " + e.getValue() + " " + e.getKey()));
    }
}
