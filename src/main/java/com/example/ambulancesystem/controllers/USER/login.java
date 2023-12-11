package com.example.ambulancesystem.controllers.USER;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.all_class.Login;
import com.example.ambulancesystem.controllers.StringMatchException;
import com.example.ambulancesystem.controllers.StringMatcher;
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

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class login {

    @FXML
    private Label error_text1;

    @FXML
    private PasswordField user_pass;

    @FXML
    private TextField user_username;

    @FXML
    public void switch_user_dashboard(ActionEvent event) throws IOException {

        String tuser = user_username.getText();
        String tpass = user_pass.getText();

        System.out.println(tuser);
        System.out.println(tpass);

        if (tuser.length() > 0 && tpass.length() > 0) {
            File infoFile2 = new File("D:/Java Soft/diner_user/" + tuser+ "/info.txt");

            if (infoFile2.exists()) {
                Scanner sc = new Scanner(infoFile2);
                sc.useDelimiter("\n");
                String p = sc.next();
                p = sc.next();
                p = sc.next();
                p = sc.next();
                p = sc.next();
                //   p = sc.next();

                StringMatcher StringMatcher = new StringMatcher();

                boolean result = false;
                try {
                   result = StringMatcher.StringMatch(tpass,p);
                } catch (StringMatchException e) {
                    System.out.println("Exception: " + e.getMessage());
                }

                System.out.println(p);

                if (result) {

                    Login login = new Login();
                    login.setUser(tuser);
                    login.setPass(tpass);

                    dashboard user = new dashboard();
                    user.setLogin(login);

                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/dashboard.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }

                else {
                    error_text1.setText("Password doesn't match");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
                    timeline.play();
                }
            }
else {
                error_text1.setText("Account doesn't exist");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
                timeline.play();
            }

        }
        else if (tuser.isBlank() || tpass.isBlank()){
            error_text1.setText("Fill out all the fields to proceed.");
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

    @FXML
    public void user_forgot_password(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/FORGOT/forgetpassword.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
