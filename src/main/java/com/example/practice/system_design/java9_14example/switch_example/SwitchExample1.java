package com.example.practice.system_design.java9_14example.switch_example;

public class SwitchExample1 {

    public static void main(String[] args) {
        // Old style — fall-through trap with break
        String status = "ACTIVE";
        String oldLabel;
        switch (status) {
            case "NEW":    oldLabel = "Created"; break;
            case "ACTIVE": oldLabel = "Running"; break;
            default:       oldLabel = "Unknown";
        }
        System.out.println("Old: " + oldLabel);

        // New style — switch expression, no break, returns value directly
        String newLabel = switch (status) {
            case "NEW"    -> "Created";
            case "ACTIVE" -> "Running";
            case "PAUSED" -> "On Hold";
            case "CLOSED" -> "Done";
            default       -> "Unknown";
        };
        System.out.println("New: " + newLabel); // Running
    }
}
