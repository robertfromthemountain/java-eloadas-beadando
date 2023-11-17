package com.example.beadndo;

import com.oanda.v20.Config;
import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import com.oanda.v20.ExecuteException;
import com.oanda.v20.RequestException;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.primitives.InstrumentName;
import com.oanda.v20.trade.Trade;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NyitottPoziciokController implements Initializable {
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
        InstrumentName instrument = new InstrumentName("NZD_USD");
        //System.out.println("Nyitott tradek:");
        List<Trade> trades = null;
        try {
            trades = ctx.trade.listOpen(accountId).getTrades();
        } catch (RequestException e) {
            throw new RuntimeException(e);
        } catch (ExecuteException e) {
            throw new RuntimeException(e);
        }
        for(Trade trade: trades)
            System.out.println(trade);
        for(Trade trade: trades)
            System.out.println(trade.getId()+"\t"+trade.getInstrument()+"\t"+trade.getOpenTime()+"\t"+trade.getCurrentUnits()+"\t"+trade.getPrice()+"\t"+trade.getUnrealizedPL());
    }

}
