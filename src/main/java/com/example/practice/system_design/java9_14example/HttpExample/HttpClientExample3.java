package com.example.practice.system_design.java9_14example.HttpExample;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientExample3 {

    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws Exception {
        var jsonBody = """
                {
                  "title":  "Learn Java 11",
                  "body":   "HttpClient is great",
                  "userId": 1
                }
                """;

        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        var response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode()); // 201
        System.out.println("Created: " + response.body());
    }
}
