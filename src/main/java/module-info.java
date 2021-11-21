module com.example.dolgozodemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dolgozodemo to javafx.fxml;
    exports com.example.dolgozodemo;
    exports com.example.dolgozodemo.controllers;
    opens com.example.dolgozodemo.controllers to javafx.fxml;
    exports com.example.dolgozodemo.core;
    opens com.example.dolgozodemo.core to javafx.fxml;
}