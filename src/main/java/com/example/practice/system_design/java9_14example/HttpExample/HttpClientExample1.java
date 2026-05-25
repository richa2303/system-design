package com.example.practice.system_design.java9_14example.HttpExample;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientExample1 {

    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    public static void main(String[] args) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .header("Accept", "application/json")
                .GET()
                .build();

        var response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode()); // 200
        System.out.println("Body:   " + response.body());
    }
}
