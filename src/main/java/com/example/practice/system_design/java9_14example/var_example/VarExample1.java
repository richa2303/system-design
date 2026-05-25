package com.example.practice.system_design.java9_14example.var_example;

import java.util.ArrayList;
import java.util.Arrays;

public class VarExample1 {

    public static void main(String[] args) {
        // Refactor these to use var
        var greeting = "Hello, Java 10!";
        var count = 42;
        var fruits = new ArrayList<>(
                Arrays.asList("Apple", "Banana", "Cherry"));

        System.out.println(greeting);       // Hello, Java 10!
        System.out.println(count);          // 42
        System.out.println(fruits.get(1));  // Banana
    }
}
