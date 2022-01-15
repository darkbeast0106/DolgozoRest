module com.example.dolgozodemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.dolgozodemo to javafx.fxml, com.google.gson;
    exports com.example.dolgozodemo;
    exports com.example.dolgozodemo.controllers;
    opens com.example.dolgozodemo.controllers to javafx.fxml, com.google.gson;
    exports com.example.dolgozodemo.core;
    opens com.example.dolgozodemo.core to javafx.fxml, com.google.gson;
    exports com.example.dolgozodemo.models;
    opens com.example.dolgozodemo.models to com.google.gson;
}