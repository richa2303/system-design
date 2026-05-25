package com.example.practice.system_design.java9_14example.collections_example;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExample1 {

    public static void main(String[] args) {
        // List.of — immutable, null-free
        var fruits = List.of("Apple", "Banana", "Cherry");
        System.out.println("Fruits:  " + fruits);
        System.out.println("Second:  " + fruits.get(1)); // Banana

        // Set.of — immutable, no duplicates, no nulls
        var methods = Set.of("GET", "POST", "PUT", "DELETE");
        System.out.println("Methods: " + methods);
        System.out.println("Has GET: " + methods.contains("GET")); // true

        // Map.of — immutable, up to 10 entries
        var codes = Map.of("OK", 200, "NOT_FOUND", 404, "ERROR", 500);
        System.out.println("OK code:  " + codes.get("OK"));  // 200
        System.out.println("Map size: " + codes.size());     // 3

        // Prove immutability
        try {
            fruits.add("Mango"); // throws!
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify List.of() — immutable!");
        }
    }
}
