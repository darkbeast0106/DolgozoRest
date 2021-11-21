package com.example.dolgozodemo;

import com.example.dolgozodemo.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DolgozoApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DolgozoApp.class.getResource("views/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 240);
        stage.setTitle("Dolgozók");
        stage.setScene(scene);
        stage.show();
        MainController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}