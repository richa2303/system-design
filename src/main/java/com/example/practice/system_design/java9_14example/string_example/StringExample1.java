package com.example.practice.system_design.java9_14example.string_example;

public class StringExample1 {

    public static void main(String[] args) {
        // isBlank vs isEmpty
        System.out.println("isEmpty:  " + "   ".isEmpty());  // false
        System.out.println("isBlank:  " + "   ".isBlank());  // true

        // strip vs trim (Unicode-aware)
        var padded = "  \u2003 hello \u2003  "; // em-space padding
        System.out.println("trim:   [" + padded.trim()   + "]"); // misses em-space
        System.out.println("strip:  [" + padded.strip()  + "]"); // correct

        // repeat
        System.out.println("-".repeat(30));

        // lines — stream over each line
        var text = "Alice\nBob\n\nCarol";
        text.lines()
                .filter(l -> !l.isBlank())
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
