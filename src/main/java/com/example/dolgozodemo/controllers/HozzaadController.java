package com.example.dolgozodemo.controllers;

import com.example.dolgozodemo.core.Controller;
import com.example.dolgozodemo.models.DolgozoApi;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class HozzaadController extends Controller {
    @FXML private TextField nevField;
    @FXML private RadioButton radioFerfi;
    @FXML private RadioButton radioNo;
    @FXML private Spinner<Integer> korSpinner;
    @FXML private Spinner<Integer> fizetesSpinner;

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
            DolgozoApi.insertDolgozo(nev, nem, kor, fizetes);
            alert("Dolgozó sikeresen hozzáadva");
        } catch (Exception e) {
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
