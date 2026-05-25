package com.example.practice.system_design.java9_14example.java_date_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeExample3 {

    public static void main(String[] args) {
        // Meeting duration
        var start = LocalTime.of(9, 30);
        var end   = LocalTime.of(11, 45);
        var dur   = Duration.between(start, end);

        System.out.println("Meeting duration: "
                + dur.toHours() + " hours "
                + dur.toMinutesPart() + " minutes"); // 2 hours 15 minutes

        // Java 9 — datesUntil: stream a range of dates
        var from = LocalDate.of(2025, 1, 1);
        var to   = LocalDate.of(2025, 1, 6);

        System.out.println("\nDates from " + from + " to " + to + ":");
        from.datesUntil(to).forEach(d -> System.out.println("  " + d));
    }
}
