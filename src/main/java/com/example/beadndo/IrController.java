package com.example.beadndo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


import static com.example.beadndo.SqliteConnection.Connector;

public class IrController implements Initializable {
    public ConnectionModel connectionModel = new ConnectionModel();
    @FXML
    public TextField pizza_nev_textField;
    @FXML
    public TextField kategoria_nev_textField;
    @FXML
    public CheckBox vega_Button;
    @FXML
    public Button beszuras_Button;
    @FXML
    private Label isConnected;

    public void beszuras_click(ActionEvent event) {
        String query = "insert into pizza values (\"" + pizza_nev_textField.getText() + "\",\"" + kategoria_nev_textField.getText() + "\"," + vega_Button.isSelected() + ")";
        executeQuery(query);
        isConnected.setText("Pizza beszúrása sikeres");
    }

    private void executeQuery(String query) {
        Connection connection = Connector();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);
        }catch (Exception e){e.printStackTrace();}

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
