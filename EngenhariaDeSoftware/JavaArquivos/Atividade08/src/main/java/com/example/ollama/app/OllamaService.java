package com.example.ollama.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Serviço para conectar-se à API OpenRouter e enviar mensagens para modelos hospedados (ex: Llama 3, Mistral etc.).
 */
public class OllamaService {

    // Endpoint da API OpenRouter
    private static final String API_URL = "https://openrouter.ai/api/v1/chat/completions";

    // Coloque aqui a sua chave da OpenRouter
    private static final String API_KEY = "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"; // ex: sk-or-123abc...

    // Modelo a ser usado — você pode trocar para outro disponível na OpenRouter
    private static final String MODEL = "meta-llama/llama-3-8b-instruct";

    public String enviarPergunta(String pergunta) throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
        conn.setDoOutput(true);

        String jsonInput = """
        {
          "model": "%s",
          "messages": [
            {"role": "user", "content": "%s"}
          ]
        }
        """.formatted(MODEL, pergunta.replace("\"", "\\\""));

        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes(StandardCharsets.UTF_8));
        }

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Erro HTTP: " + responseCode);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(conn.getInputStream());

        // A resposta vem em: choices[0].message.content
        return response.path("choices").get(0).path("message").path("content").asText("Sem resposta");
    }
}