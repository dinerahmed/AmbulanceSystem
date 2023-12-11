package com.example.ambulancesystem.controllers.ambulance;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.all_class.Ambulance;
import com.example.ambulancesystem.all_class.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class dashboard implements Initializable {


    @FXML
    private AnchorPane danchore;

    @FXML
    private Label show_email;

    @FXML
    private Label show_number;

    @FXML
    private Label show_user;



    static Login login = new Login();

    public void setLogin(Login log)
    {
        login = log;
    }

    static Ambulance user = new Ambulance();

    public void set_profile()
    {
        show_email.setText(user.getEmail());
        show_number.setText(user.getPhn_number());
        show_user.setText(user.getName());
    }

    @FXML
    public void get_admin_info() throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Soft/diner_ambulance/" + login.getUser() + "/info.txt");

        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);
            sc.useDelimiter("\n");

            String p1 = sc.next();
            String p2 = sc.next();
            String p3 = sc.next();
            String p4 = sc.next();
            String p5 = sc.next();
            String p6 = sc.next();
            String p7 = sc.next();

            user = new Ambulance(p1, p2, p3, p4, p5, p6, p7);

        }
    }


    private void send_user() {

        profile pro = new profile();
        pro.set_ambulance(user);
        request req = new request();
        req.set_ambulance(user);
        status sta = new status();
        sta.set_ambulance(user);
        history his = new history();
        his.set_ambulance(user);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            get_admin_info();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        set_profile();
        send_user();
    }


    @FXML
    public void profile(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/ambulance/profile.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    public void historyy(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/ambulance/amb_history.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }
    public void status(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/ambulance/status.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    public void request(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/ambulance/request.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    @FXML
    public void payment(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/ambulance/payment.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }
    @FXML
    public void user_sign_in(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/ambulance/amlogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
