package com.example.ambulancesystem.controllers.ADMIN;


import com.example.ambulancesystem.all_class.Login;
import com.example.ambulancesystem.all_class.USER;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class profile implements  javafx.fxml.Initializable{


    @FXML
    private AnchorPane danchore;

    @FXML
    private Label show_email;

    @FXML
    private Label show_number;

    @FXML
    private Label show_user;

    public void setAdmin(USER log)
    {
        user = log;
    }

    static USER user = new USER();


    public void set_profile()
    {
        show_email.setText(user.getEmail());
        show_number.setText(user.getPhn_number());
        show_user.setText(user.getName());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        set_profile();
    }

}

