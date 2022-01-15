package com.example.dolgozodemo.controllers;

import com.example.dolgozodemo.core.Controller;
import com.example.dolgozodemo.models.Dolgozo;
import com.example.dolgozodemo.models.DolgozoApi;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class ModositController extends Controller {
    @FXML private TextField nevField;
    @FXML private RadioButton radioFerfi;
    @FXML private RadioButton radioNo;
    @FXML private Spinner<Integer> korSpinner;
    @FXML private Spinner<Integer> fizetesSpinner;
    private Dolgozo modositando;

    public Dolgozo getModositando() {
        return modositando;
    }

    public void setModositando(Dolgozo modositando) {
        this.modositando = modositando;
        init();
    }

    private void init(){
        nevField.setText(modositando.getNev());
        if (modositando.getNem().equals("férfi")){
            radioFerfi.setSelected(true);
            radioNo.setSelected(false);
        } else{
            radioFerfi.setSelected(false);
            radioNo.setSelected(true);
        }
        korSpinner.getValueFactory().setValue(modositando.getKor());
        fizetesSpinner.getValueFactory().setValue(modositando.getFizetes());
    }

    @FXML private void modositClick(){
        String nev = nevField.getText();
        String nem = radioFerfi.isSelected()? "férfi" : "nő";
        int kor = korSpinner.getValue();
        int fizetes = fizetesSpinner.getValue();
        if (nev.isEmpty()){
            alert("Név megadása kötelező");
            return;
        }
        try {
            DolgozoApi.updateDolgozo(modositando.getId(), nev, nem, kor, fizetes);
            modositando.setNev(nev);
            modositando.setNem(nem);
            modositando.setKor(kor);
            modositando.setFizetes(fizetes);
            alertWait("Dolgozó sikeresen módosítva");
            this.stage.close();
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
