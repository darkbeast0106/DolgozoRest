package com.example.dolgozodemo.core;

import com.example.dolgozodemo.DolgozoApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public abstract class Controller {
    protected Stage stage;
    protected Scene scene;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    protected void hibaKiir(Exception e) {
        String title = "Hiba";
        String header = "Hiba történt";
        if (e instanceof SQLException){
            title = "Adatbázis hiba";
            header = "Hiba történt az adatbázis kapcsolatban";
        }
        String message = e.getMessage();
        alert(AlertType.ERROR, title, header, message);
    }
    private Alert alertCreate(AlertType type, String title, String header, String message){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        if (type.equals(Alert.AlertType.NONE)){
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
        }
        return alert;
    }
    protected void alert(AlertType type, String title, String header, String message){
        alertCreate(type, title, header, message).show();
    }
    protected void alert(String title,String message){
        alert(AlertType.NONE, title, "", message);
    }
    protected void alert(String message){
        alert(AlertType.NONE, "", "", message);
    }
    protected void alertWait(String message){
        alertCreate(AlertType.NONE, "", "", message).showAndWait();
    }

    public static Controller newWindow(String fxml, String title, int width, int height) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DolgozoApp.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle(title);
        stage.setScene(scene);
        Controller controller = fxmlLoader.getController();
        controller.stage = stage;
        controller.scene = scene;
        return controller;
    }
}
