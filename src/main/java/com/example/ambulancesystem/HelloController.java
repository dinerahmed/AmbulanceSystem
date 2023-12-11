package com.example.ambulancesystem;


import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


public class HelloController implements Initializable {

    public void admin_login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/ADMIN/admin_dash.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }





    public void get_otp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/USER/FORGOT/otp.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void user_createPass(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/USER/FORGOT/confirmnewpass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}