package com.example.dolgozodemo.controllers;

import com.example.dolgozodemo.core.Controller;
import com.example.dolgozodemo.models.Dolgozo;
import com.example.dolgozodemo.models.DolgozoDB;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class HozzaadController extends Controller {
    @FXML private TextField nevField;
    @FXML private RadioButton radioFerfi;
    @FXML private RadioButton radioNo;
    @FXML private Spinner<Integer> korSpinner;
    @FXML private Spinner<Integer> fizetesSpinner;
    private DolgozoDB db;

    @FXML public void initialize() {
        try {
            db = new DolgozoDB();
        } catch (SQLException e) {
            hibaKiir(e);
        }
    }

    @FXML private void hozzaadClick(){
        String nev = nevField.getText();
        String nem = radioFerfi.isSelected()? "férfi" : "nő";
        int kor = korSpinner.getValue();
        int fizetes = fizetesSpinner.getValue();
        if (nev.isEmpty()){
            alert("Név megadása kötelező");
            return;
        }
        try {
            db.insertDolgozo(nev, nem, kor, fizetes);
            alert("Dolgozó sikeresen hozzáadva");
        } catch (SQLException e) {
            hibaKiir(e);
        }
    }

    @FXML private void ferfiClick(){
        radioFerfi.setSelected(true);
        radioNo.setSelected(false);
    }

    @FXML private void noClick(){
        radioFerfi.setSelected(false);
        radioNo.setSelected(true);
    }
}
