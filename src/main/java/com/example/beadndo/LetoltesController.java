package com.example.beadndo;

import csomag1.MNBArfolyamServiceSoap;
import csomag1.MNBArfolyamServiceSoapImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LetoltesController {
    @FXML
    public Button vissza_button;
    @FXML
    public Button letoltes_Button;
    @FXML
    public Label isConnected;

    public void vissza_click(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("fooldal-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 750, 350);
            Stage stage = new Stage();
            stage.setTitle("Netpizza");
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    public void letoltes_click(ActionEvent event) {
        MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
        MNBArfolyamServiceSoap service = impl.getCustomBindingMNBArfolyamServiceSoap();
        try {
            isConnected.setText(service.getInfo());
            //System.out.println(service.getInfo());
            //System.out.println(service.getCurrentExchangeRates());
            //System.out.println(service.getExchangeRates("2022-08-14","2022-09-14","EUR"));
        } catch (Exception e) {
            System.err.print(e);
        }


    }
}
