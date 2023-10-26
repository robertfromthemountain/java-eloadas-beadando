package com.example.beadndo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.beadndo.SqliteConnection.Connector;

public class ModositController implements Initializable {
    public ConnectionModel connectionModel = new ConnectionModel();
    @FXML
    public ChoiceBox<Integer> azonosito_choiceBox;
    @FXML
    public TextField pizza_nev_textField;
    @FXML
    public TextField mennyiseg_textField;
    @FXML
    public TextField felvetel_textField;
    @FXML
    public TextField kiszallitas_textField;
    @FXML
    public Button modositas_button;
    @FXML
    public Label isConnected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(connectionModel.isDbConnected())
        {
            isConnected.setText("Sikerült kapcsolódni az adatbázishoz");
            getOsszAzonosito();
        }
        else{
            isConnected.setText("Nem sikerült kapcsolódni");
        }
    }
    public void modosit_click(ActionEvent event) {
        String query = "update rendeles set pizzanev = '" + pizza_nev_textField.getText() + "', darab = '" + mennyiseg_textField.getText() + "', felvetel = '" + felvetel_textField.getText() + "', kiszallitas = '" + kiszallitas_textField.getText() + "'" + " Where az = " + (int) azonosito_choiceBox.getValue();
        executeQuery(query);
        isConnected.setText("Rendelés módosítás sikeres");
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
    public ArrayList<Integer> getOsszAzonosito()
    {
        ArrayList<Integer> osszAzLista = new ArrayList<>();
        Connection connection = Connector();
        String query = "select az from rendeles";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            int azonositok;
            while(rs.next())
            {
                azonositok = rs.getInt("az");
                osszAzLista.add(azonositok);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int var : osszAzLista) {
            azonosito_choiceBox.getItems().add(var);
        }
        return osszAzLista;
    }
}
