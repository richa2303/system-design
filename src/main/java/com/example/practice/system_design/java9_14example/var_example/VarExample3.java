package com.example.practice.system_design.java9_14example.var_example;

import java.io.*;

public class VarExample3 {

    public static void main(String[] args) throws Exception {
        // Create a temp file to demo try-with-resources
        var file = File.createTempFile("demo", ".txt");
        file.deleteOnExit();

        // Write using var
        try (var writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Hello from var!");
        }

        // Read using var
        try (var reader = new BufferedReader(new FileReader(file))) {
            var line = reader.readLine();
            System.out.println(line); // Hello from var!
        }
    }
}
