package com.example.ambulancesystem.controllers.USER;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.URISyntaxException;
import com.example.ambulancesystem.all_class.Login;
import com.example.ambulancesystem.all_class.USER;
import com.example.ambulancesystem.all_class.change;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.scene.layout.AnchorPane;
public class dashboard implements Initializable, change {




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

    static USER user = new USER();


    public void set_profile()
    {
        show_email.setText(user.getEmail());
        show_number.setText(user.getPhn_number());
        show_user.setText(user.getName());
    }

    @FXML
    public void get_admin_info() throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Soft/diner_user/" + login.getUser() + "/info.txt");

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

            user = new USER(p1, p2, p3, p4, p5, p6, p7);

        }
    }


    private void send_user() {

        booking book = new booking();
        book.setUser(user);
        profile pro = new profile();
        pro.setUser(user);
        payment pay = new payment();
        pay.setUser(user);
        history his = new history();
        his.setUser(user);
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


    public void history(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/USER/userhistory.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }
    public void available_ambu(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/USER/availableambulance.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    public void booking(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/USER/booking.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    @FXML

    public void near_hospital(ActionEvent event) throws IOException {

        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/USER/hyperTEST.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    @FXML
    public void payment(ActionEvent event) throws Exception {
        String fxml = "FXML/USER/payment.fxml";
        changeScene(fxml);
    }

    @FXML
    public void user_profile(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("FXML/USER/profile.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    @FXML
    public void user_sign_in(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/userlogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void changeScene(String fxml) throws Exception {
        AnchorPane fxm = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxm);
    }


}
