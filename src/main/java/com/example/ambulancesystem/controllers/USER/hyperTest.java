package com.example.ambulancesystem.controllers.USER;

import com.example.ambulancesystem.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;

import java.io.IOException;

public class hyperTest {

    @FXML
    private WebView web;
    @FXML
    public void open_web(ActionEvent event) throws URISyntaxException, IOException {
        web.getEngine().load("https://www.google.com.bd/maps/search/hospitals/@23.7811774,90.4193252,12z/data=!3m1!4b1?entry=ttu");
    }


}