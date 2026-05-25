package com.example.practice.system_design.java9_14example.collections_example;

import java.util.ArrayList;
import java.util.List;

public class CollectionsExample2 {

    public static void main(String[] args) {
        var original = new ArrayList<>(List.of("Alice", "Bob", "Carol"));
        System.out.println("Original before: " + original);

        // Java 10 — defensive immutable snapshot
        var snapshot = List.copyOf(original);

        // Mutate original
        original.add("Dave");
        original.set(0, "MODIFIED");

        System.out.println("Original after:  " + original); // [MODIFIED, Bob, Carol, Dave]
        System.out.println("Snapshot:        " + snapshot); // [Alice, Bob, Carol] — unchanged!
        System.out.println("Snapshot size:   " + snapshot.size()); // 3
    }
}
