package com.example.beadndo;

import com.oanda.v20.Config;
import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.pricing.ClientPrice;
import com.oanda.v20.pricing.PricingGetRequest;
import com.oanda.v20.pricing.PricingGetResponse;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.oanda.v20.instrument.CandlestickGranularity.H1;

public class HistorikusArakController implements Initializable {
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

    public void mutat_click(ActionEvent event) {
        Context ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("HistorikusAdatok").build();
        if(devizaParok_choiceBox.getValue().equals("EUR - USD")) {
            try {
                InstrumentCandlesRequest request = new InstrumentCandlesRequest(new InstrumentName("EUR_USD"));
                request.setGranularity(H1);
                request.setCount(10L);    // 10 adat	L: long adattípus
                InstrumentCandlesResponse resp = ctx.instrument.candles(request);
                for (Candlestick candle : resp.getCandles())
                    legutobbi_label.setText(String.valueOf(candle));
                for (Candlestick candle : resp.getCandles())
                    arfolyam_label.setText(candle.getTime() + "\t" + candle.getMid().getC());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(devizaParok_choiceBox.getValue().equals("USD - JPY")) {
            try {
                InstrumentCandlesRequest request = new InstrumentCandlesRequest(new InstrumentName("USD_JPY"));
                request.setGranularity(H1);
                request.setCount(10L);    // 10 adat	L: long adattípus
                InstrumentCandlesResponse resp = ctx.instrument.candles(request);
                for (Candlestick candle : resp.getCandles())
                    legutobbi_label.setText(String.valueOf(candle));
                for (Candlestick candle : resp.getCandles())
                    arfolyam_label.setText(candle.getTime() + "\t" + candle.getMid().getC());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(devizaParok_choiceBox.getValue().equals("GBP - USD")) {
            try {
                InstrumentCandlesRequest request = new InstrumentCandlesRequest(new InstrumentName("GBP_USD"));
                request.setGranularity(H1);
                request.setCount(10L);    // 10 adat	L: long adattípus
                InstrumentCandlesResponse resp = ctx.instrument.candles(request);
                for (Candlestick candle : resp.getCandles())
                    legutobbi_label.setText(String.valueOf(candle));
                for (Candlestick candle : resp.getCandles())
                    arfolyam_label.setText(candle.getTime() + "\t" + candle.getMid().getC());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(devizaParok_choiceBox.getValue().equals("USD -CHF")) {
            try {
                InstrumentCandlesRequest request = new InstrumentCandlesRequest(new InstrumentName("USD_CHF"));
                request.setGranularity(H1);
                request.setCount(10L);    // 10 adat	L: long adattípus
                InstrumentCandlesResponse resp = ctx.instrument.candles(request);
                for (Candlestick candle : resp.getCandles())
                    legutobbi_label.setText(String.valueOf(candle));
                for (Candlestick candle : resp.getCandles())
                    arfolyam_label.setText(candle.getTime() + "\t" + candle.getMid().getC());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        /*Context ctx = new ContextBuilder(Config.URL).setToken(Config.TOKEN).setApplication("PricePolling").build();
        AccountID accountId = Config.ACCOUNTID;
        List<String> instruments = new ArrayList<>( Arrays.asList(devizaParok_choiceBox.getValue()));
        try {
            PricingGetRequest request = new PricingGetRequest(accountId, instruments);
            DateTime since = null;
            while (true) {
                if (since != null)
                {
                    legutobbi_label.setText("Polling since " + since);
                    request.setSince(since);
                }
                PricingGetResponse resp = ctx.pricing.get(request);
                for (ClientPrice price : resp.getPrices())
                    arfolyam_label.setText(String.valueOf(price));
                since = resp.getTime();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
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
        devizaParok_choiceBox.getItems().add("EUR - USD");
        devizaParok_choiceBox.getItems().add("USD - JPY");
        devizaParok_choiceBox.getItems().add("GBP - USD");
        devizaParok_choiceBox.getItems().add("USD - CHF");
    }
}
