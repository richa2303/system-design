package com.example.practice.system_design.java9_14example.HttpExample;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientExample2 {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        CompletableFuture<String> future = CLIENT
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> body.substring(0, Math.min(body.length(), 100)) + "...");

        // Non-blocking — do other work here
        System.out.println("Request sent, doing other work...");

        // Get result when ready
        System.out.println("Response: " + future.get());
    }
}
