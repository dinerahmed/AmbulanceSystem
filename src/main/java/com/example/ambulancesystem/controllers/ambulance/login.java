package com.example.ambulancesystem.controllers.ambulance;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.all_class.Login;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class login {

    @FXML
    private PasswordField am_pass;

    @FXML
    private TextField am_username;

    @FXML
    private Label error_text1;

    @FXML
    void amdash(ActionEvent event) throws IOException {

        String tuser = am_username.getText();
        String tpass = am_pass.getText();

        if (tuser.length() > 0 && tpass.length() > 0) {
            File infoFile2 = new File("D:/Java Soft/diner_ambulance/" + tuser+ "/info.txt");

            if (infoFile2.exists()) {
                Scanner sc = new Scanner(infoFile2);
                sc.useDelimiter("\n");
                String p = sc.next();
                p = sc.next();
                p = sc.next();
                p = sc.next();
                p = sc.next();
                //   p = sc.next();

                System.out.println(p);
                if (p.equals(tpass)) {

                    dashboard amb = new dashboard();
                    Login login = new Login();
                    login.setUser(tuser);
                    login.setPass(tpass);
                    amb.setLogin(login);

                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/ambulance/dashboard.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    error_text1.setText("Password doesn't match");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
                    timeline.play();
                }
            }
        }
        else if (tuser.isBlank() || tpass.isBlank()){
            error_text1.setText("Fill out all the fields to proceed");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
            timeline.play();
        }
    }



    @FXML
    public void switch_welcome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/SignUp.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}