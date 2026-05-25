package com.example.practice.system_design.java9_14example.switch_example;

public class SwitchExample2 {

    public static void main(String[] args) {
        // Test all 12 months
        for (int month = 1; month <= 12; month++) {
            int days = switch (month) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 4, 6, 9, 11            -> 30;
                case 2                       -> 28;
                default -> throw new IllegalArgumentException(
                        "Invalid month: " + month);
            };
            System.out.printf("Month %2d has %d days%n", month, days);
        }
    }
}
