package com.example.beadndo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GrafikonController implements Initializable {

    @FXML
    private ChoiceBox<?> deviza_ChoiceBox;

    @FXML
    private Button keres_Button;

    @FXML
    private LineChart<?, ?> linechart;

    @FXML
    private Button vissza_button;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    void keres_click(ActionEvent event) {

    }

    @FXML
    void vissza_click(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1",23));
        linechart.getData().addAll(series);

    }
}
