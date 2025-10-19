package com.example.ollama.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController {

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtQuestion;

    @FXML
    private Button btnEnviar;

    // Agora usamos o construtor padrão (sem parâmetros)
    private final OllamaService ollamaService = new OllamaService();

    @FXML
    public void onEnviar() {
        String pergunta = txtQuestion.getText().trim();

        if (!pergunta.isEmpty()) {
            listView.getItems().add("Você: " + pergunta);
            txtQuestion.clear();

            // Envia a pergunta em uma thread separada
            new Thread(() -> {
                try {
                    String resposta = ollamaService.enviarPergunta(pergunta);
                    javafx.application.Platform.runLater(() ->
                            listView.getItems().add("Ollama: " + resposta)
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                    javafx.application.Platform.runLater(() ->
                            listView.getItems().add("Erro: " + e.getMessage())
                    );
                }
            }).start();
        }
    }
}