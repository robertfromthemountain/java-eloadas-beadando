package com.example.beadndo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.beadndo.SqliteConnection.Connector;
import static com.example.beadndo.netPizzaApplication.*;

public class TorolController implements Initializable {
    public ConnectionModel connectionModel = new ConnectionModel();
    @FXML
    public Button torles_button;
    @FXML
    public ChoiceBox azonosito_choiceBox;
    @FXML
    public Button vissza_button;
    @FXML
    public Button deleteapi_button;
    @FXML
    private Label isConnected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (connectionModel.isDbConnected()) {
            getOsszAzonosito();
        } else {

        }
    }

    public void torles_click(ActionEvent event) {
        String query = "delete from rendeles where az = " + (int) azonosito_choiceBox.getValue();
        executeQuery(query);
        isConnected.setText("Rendelés törlés sikeres");
    }

    private void executeQuery(String query) {
        Connection connection = Connector();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getOsszAzonosito() {
        ArrayList<Integer> osszAzLista = new ArrayList<>();
        Connection connection = Connector();
        String query = "select az from rendeles";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            int azonositok;
            while (rs.next()) {
                azonositok = rs.getInt("az");
                osszAzLista.add(azonositok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int var : osszAzLista) {
            azonosito_choiceBox.getItems().add(var);
        }
        return osszAzLista;
    }

    public void vissza_click(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("fooldal-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 750, 350);
            Stage stage = new Stage();
            stage.setTitle("Netpizza");
            stage.setScene(scene);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    public void deleteapi_click(ActionEvent event) throws IOException {
        String ID = "3399";
        DELETE(ID);
        GET(ID);

    }
}
