package com.example.ollama.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ollama/app/chat-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(getClass().getResource("/com/example/ollama/app/styles.css").toExternalForm());
        stage.setTitle("Ollama Chat — Modern");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
