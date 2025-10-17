package com.example.ollama.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;

public class OllamaService {

    public static String askOnce(String baseUrl, String model, String userQuestion, String systemPrompt)
            throws IOException, InterruptedException, HttpTimeoutException {

        if (systemPrompt == null || systemPrompt.isBlank()) {
            systemPrompt = "You are a helpful assistant. Answer in Portuguese when the user writes in Portuguese.";
        }

        String jsonBody = "{"
                + "\"model\":\"" + model + "\","
                + "\"stream\":false,"
                + "\"messages\":["
                + "{\"role\":\"system\",\"content\":\"" + systemPrompt + "\"},"
                + "{\"role\":\"user\",\"content\":\"" + userQuestion + "\"}"
                + "]"
                + "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl.endsWith("/") ? baseUrl + "api/chat" : baseUrl + "/api/chat"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
