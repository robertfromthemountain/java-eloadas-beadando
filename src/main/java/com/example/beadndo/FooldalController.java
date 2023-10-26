package com.example.beadndo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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


    public void olvas_click(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("olvas-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            Stage stage = new Stage();
            stage.setTitle("Olvas");
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }


    @FXML
    public void olvas2_click(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("olvas2-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            Stage stage = new Stage();
            stage.setTitle("Olvas2");
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    public void torol_click(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("torol-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 300, 285);
            Stage stage = new Stage();
            stage.setTitle("Rendelés törlés");
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    public void ir_click(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ir-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 172);
            Stage stage = new Stage();
            stage.setTitle("Pizza beszúrás");
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    public void modosit_click(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("modosit-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 300, 300);
            Stage stage = new Stage();
            stage.setTitle("Rendelés módosítás");
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (connectionModel.isDbConnected()) {
            isConnected.setText("Sikerült kapcsolódni az adatbázishoz");
        } else {
            isConnected.setText("Nem sikerült kapcsolódni");
        }
    }

}