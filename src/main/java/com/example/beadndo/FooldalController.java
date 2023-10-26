package com.example.beadndo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FooldalController implements Initializable {
    public ConnectionModel connectionModel = new ConnectionModel();

    @FXML
    private Label isConnected;
    @FXML
    public Button olvas_button;
    @FXML
    public Button olvas2_button;
    @FXML
    public Button ir_button;
    @FXML
    public Button modosit_button;
    @FXML
    public Button torol_button;

    @FXML
    public void olvas_click(ActionEvent event) {
    }

    @FXML
    public void olvas2_click(ActionEvent event) {
    }

    @FXML
    public void torol_click(ActionEvent event) {
    }

    @FXML
    public void ir_click(ActionEvent event) {
    }

    @FXML
    public void modosit_click(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(connectionModel.isDbConnected())
        {
            isConnected.setText("Sikerült kapcsolódni az adatbázishoz");
        }
        else{
            isConnected.setText("Nem sikerült kapcsolódni");
        }
    }
}