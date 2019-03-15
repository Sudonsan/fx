package com.forex.forex;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView<Candles> testTableID;

    @FXML
    private TableColumn<Candles, String> HDate;

    @FXML
    private TableColumn<Candles, Double> BOpen;

   /* @FXML
    private TableColumn<?, ?> BClose;

    @FXML
    private TableColumn<?, ?> BHigh;

    @FXML
    private TableColumn<?, ?> BLow;

    @FXML
    private TableColumn<?, ?> AOpen;

    @FXML
    private TableColumn<?, ?> AClose;

    @FXML
    private TableColumn<?, ?> AHigh;

    @FXML
    private TableColumn<?, ?> ALow;

    @FXML
    private TableColumn<?, ?> Ticket;*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


