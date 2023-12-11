package com.example.ambulancesystem.controllers.ADMIN;

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
import java.io.IOException;
import java.util.Scanner;

public class login {

    @FXML
    private PasswordField ad_login_pass;

    @FXML
    private TextField ad_login_username;

    @FXML
    private Label error_text2;


    static Login login = new Login();

    @FXML

    public void admin_login_dash(ActionEvent event) throws IOException {

        String atuser = ad_login_username.getText();
        String atpass = ad_login_pass.getText();



        if(atuser.isBlank() || atpass.isBlank())
        {
            error_text2.setText("Fill all the boxes");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text2.setText("")));
            timeline.play();

        }

        if (atuser.length() > 0 && atpass.length() > 0) {
            File infoFile2 = new File("D:/Java Soft/diner_admin/" + atuser+ "/info.txt");

            if (infoFile2.exists()) {
                Scanner sc = new Scanner(infoFile2);
                String p = sc.next();
                p = sc.next();
                p = sc.next();
                p = sc.next();
                p = sc.next();
                //   p = sc.next();

                System.out.println(p);
                if (p.equals(atpass)) {

                    login = new Login(atuser,atpass);

                    dashboard dash = new dashboard();
                    dash.setLogin(login);
                    manage_amb manageAmb = new manage_amb();
                    manageAmb.setLogin(login);

                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/ADMIN/admin_dash.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    error_text2.setText("Password doesn't match");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text2.setText("\0")));
                    timeline.play();
                }

            } else {
                error_text2.setText("Please check username/password");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text2.setText("\0")));
                timeline.play();
            }
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
