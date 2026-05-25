package com.example.practice.system_design.java9_14example.java_date_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeExample2 {

    public static void main(String[] args) {
        // Parse input string
        var inputFmt  = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var outputFmt = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

        var date = LocalDate.parse("25-12-2025", inputFmt);
        System.out.println("Parsed:    " + date);                   // 2025-12-25
        System.out.println("Formatted: " + date.format(outputFmt)); // December 25, 2025
    }
}
