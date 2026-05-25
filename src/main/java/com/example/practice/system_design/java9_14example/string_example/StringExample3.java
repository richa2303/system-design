package com.example.practice.system_design.java9_14example.string_example;

public class StringExample3 {

    public static void main(String[] args) {
        var text = """
                The quick brown fox
                jumps over the lazy dog

                Java 11 makes string handling
                much cleaner and more expressive

                """;

        long totalLines = text.lines().count();
        long blankLines = text.lines().filter(String::isBlank).count();
        long wordCount  = text.lines()
                .filter(l -> !l.isBlank())
                .mapToLong(l -> l.trim().split("\\s+").length)
                .sum();

        System.out.println("Total lines: " + totalLines); // 7
        System.out.println("Blank lines: " + blankLines); // 2
        System.out.println("Word count:  " + wordCount);  // 20
    }
}
