package com.example.practice.system_design.java9_14example.switch_example;

public class SwitchExample3 {

    static void log(String msg) { System.out.println("[LOG] " + msg); }

    public static void main(String[] args) {
        int[] codes = {200, 301, 404, 500, 999};

        for (int code : codes) {
            String category = switch (code / 100) {
                case 2 -> "SUCCESS";
                case 3 -> "REDIRECT";
                case 4 -> {
                    log("Client error: " + code);
                    yield "CLIENT_ERROR";
                }
                case 5 -> {
                    log("Server error: " + code);
                    yield "SERVER_ERROR";
                }
                default -> {
                    log("Unknown code: " + code);
                    yield "UNKNOWN";
                }
            };
            System.out.println(code + " -> " + category);
        }
    }
}
