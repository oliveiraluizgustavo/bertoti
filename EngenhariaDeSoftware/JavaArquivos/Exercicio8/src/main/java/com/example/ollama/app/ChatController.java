package com.example.ollama.app;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.http.HttpTimeoutException;

public class ChatController {

    @FXML
    private TextField txtHost;

    @FXML
    private TextField txtQuestion;

    @FXML
    private ComboBox<String> cboModel;

    @FXML
    private ListView<TextFlow> listView;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnSend;

    public void initialize() {
        txtHost.setText("http://localhost:11434"); // ajuste se necessário

        cboModel.getItems().add("Qwen-3:4B");
        cboModel.setValue("Qwen-3:4B");

        lblStatus.setText("Pronto");
    }

    @FXML
    private void onSend() {
        String question = txtQuestion.getText().trim();
        if (question.isEmpty()) return;

        appendMessage("Você", question, Color.BLACK);
        txtQuestion.clear();
        lblStatus.setText("Aguardando resposta...");

        new Thread(() -> {
            try {
                String response = OllamaService.askOnce(txtHost.getText(), cboModel.getValue(), question, null);
                Platform.runLater(() -> {
                    appendMessage("Assistente", response, Color.BLACK);
                    lblStatus.setText("Pronto");
                });
            } catch (HttpTimeoutException e) {
                Platform.runLater(() -> {
                    appendMessage("Assistente", "Erro: Timeout", Color.RED);
                    lblStatus.setText("Erro");
                });
            } catch (IOException | InterruptedException e) {
                Platform.runLater(() -> {
                    appendMessage("Assistente", "Erro: " + e.getMessage(), Color.RED);
                    lblStatus.setText("Erro");
                });
            }
        }).start();
    }

    private void appendMessage(String sender, String message, Color color) {
        Text senderText = new Text(sender + ": ");
        senderText.setFill(Color.DARKBLUE);
        senderText.setStyle("-fx-font-weight: bold;");

        Text msgText = new Text(message + "\n");
        msgText.setFill(color);

        TextFlow textFlow = new TextFlow(senderText, msgText);
        listView.getItems().add(textFlow);
        listView.scrollTo(listView.getItems().size() - 1);
    }
}
