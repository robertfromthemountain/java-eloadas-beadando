package com.example.beadndo;

import com.oanda.v20.Config;
import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import com.oanda.v20.account.AccountID;

import com.oanda.v20.trade.TradeCloseRequest;
import com.oanda.v20.trade.TradeSpecifier;
import com.oanda.v20.transaction.TransactionID;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZarasController implements Initializable {
    @FXML
    public Button mutat_button;
    @FXML
    public Label arfolyam_label;
    @FXML
    public Button vissza_button;
    @FXML
    public ChoiceBox<String> devizaParok_choiceBox;
    @FXML
    public Label legutobbi_label;
    static Context ctx;
    static AccountID accountId;


    public void mutat_click(ActionEvent event) {

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
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("StepByStepOrder").build();
        accountId = Config.ACCOUNTID;
        TransactionID tradeId = new TransactionID("25");
        try {
            ctx.trade.close(new TradeCloseRequest(accountId, new TradeSpecifier(tradeId.toString())));
        } catch (Exception e) {   throw new RuntimeException(e);   }
        //.out.println("Done");

    }


}
