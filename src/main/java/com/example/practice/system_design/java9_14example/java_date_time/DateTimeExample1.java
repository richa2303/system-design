package com.example.practice.system_design.java9_14example.java_date_time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateTimeExample1 {

    public static void main(String[] args) {
        var today   = LocalDate.now();
        var newYear = LocalDate.of(2026, 1, 1);

        long days = ChronoUnit.DAYS.between(today, newYear);
        System.out.println("Today: " + today);
        System.out.println("Days until 2026: " + days);
    }
}
