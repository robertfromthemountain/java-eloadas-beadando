package com.example.beadndo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import static com.example.beadndo.SqliteConnection.Connector;
import static com.example.beadndo.netPizzaApplication.*;

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
    public Button vissza_button;
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

        }
        else{

        }
    }

    public void vissza_click(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("fooldal-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
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
    public void postapi_click(ActionEvent event) throws IOException {
        POST("Horváth János", "male", "kalpat_example@data.hu","active");

    }
}
