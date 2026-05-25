package com.example.practice.system_design.java9_14example.var_example;

import java.util.HashMap;

public class VarExampe2 {

    public static void main(String[] args) {
        var scores = new HashMap<String, Integer>();
        scores.put("Alice", 95);
        scores.put("Bob",   88);
        scores.put("Carol", 72);

        // var used in for-each — no need to write Map.Entry<String,Integer>
        for (var entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
