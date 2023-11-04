package com.example.beadndo;

import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.account.AccountSummary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.beadndo.SqliteConnection.Connector;


public class SzamlainfoController implements Initializable {


    @FXML
    public TableColumn id_column;
    @FXML
    public TableColumn alias_column;
    @FXML
    public TableColumn currency_column;
    @FXML
    public TableColumn balance_column;
    @FXML
    public TableColumn created_column;
    @FXML
    public TableColumn created_time_column;
    @FXML
    public TableColumn open_trade_column;
    @FXML
    public TableColumn last_trans_column;
    @FXML
    public TableView szamlainfo_tablazat;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Context ctx = new Context("https://api-fxpractice.oanda.com","de7895a23b01d7cc4c8896d1139e706b-2daacfbab11b921a924b461a8e2a7438");
        try {
            AccountSummary summary = ctx.account.summary(new AccountID("101-004-27326966-001")).getAccount();
            System.out.println(summary);
            ObservableList <szamlainfo> account = Arrays.asList(summary.getId(), summary.getAlias(), summary.getCurrency(), summary.getBalance(), summary.getCreatedByUserID(), summary.getCreatedTime(), summary.getOpenTradeCount(), summary.getLastTransactionID());
            /*account[0].id = summary.getId();
            account.alias = summary.getAlias();
            account.balance = summary.getBalance();
            account.createdByUserId = summary.getCreatedByUserID();
            account.currency = summary.getCurrency();
            account.createdTime = summary.getCreatedTime();
            account.lastTransactionID = summary.getLastTransactionID();
            account.openTradeCount = summary.getOpenTradeCount();*/

            id_column.setCellValueFactory(new PropertyValueFactory<osszesites, Integer>("az"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
