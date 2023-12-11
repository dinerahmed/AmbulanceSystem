package com.example.ambulancesystem.controllers.USER;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.all_class.USER;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class payment implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private TextField method;

    @FXML
    private TextField ref;

    @FXML
    private Label s_amount = new Label();

    @FXML
    private Label s_location;

    @FXML
    private Label s_no;

    @FXML
    private Label s_user;


    @FXML
    private Label error_text;
    @FXML
    private TextField trans;

    static USER user = new USER();

    public void setUser(USER user) {
        this.user = user;
    }

    @FXML
    void pay_now(ActionEvent event) throws IOException {

        if(method.getText().isBlank() || ref.getText().isBlank() || id.getText().isBlank() || trans.getText().isBlank())
        {
            error_text.setText("Please fill up all the field");
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
            timeline.play();
            return;
        }
        else {
            String m = method.getText();
            String r = ref.getText();
            String i = id.getText();
            String t = trans.getText();

            method.setText("");
            ref.setText("");
            id.setText("");
            trans.setText("");

            String directoryPath = "D:/Java Soft/diner_payment/" + user.getUser() + "/" + "info.txt";
            File directory = new File(directoryPath);

            if (directory.exists()) {

                Scanner sc = new Scanner(directory);
                sc.useDelimiter("\n");
                String p1 = sc.next();
                String p2 = sc.next();
                String p3 = sc.next();
                String p4 = sc.next();
                String p5 = sc.next();
                String p6 = sc.next();
                String p7 = sc.next();

                sc.close();

                File directory1 = new File("D:/Java Soft/diner_payment_process/" + user.getUser());
                boolean m1 = directory1.mkdir();

                File directory2 = new File("D:/Java Soft/diner_payment_process/" + user.getUser() + "/" + "info.txt");

                FileWriter writer = new FileWriter(directory2);
                writer.write(m + "\n");
                writer.write(t + "\n");
                writer.write(i + "\n");
                writer.write(r + "\n");
                writer.write(p1 + "\n");
                writer.write(p2 + "\n");
                writer.write(p3 + "\n");
                writer.write(p4 + "\n");
                writer.write(p5 + "\n");
                writer.write(p6 + "\n");
                writer.write(p7 + "\n");
                writer.close();

                error_text.setText("Payment Successful");
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
                timeline.play();

            } else {
                error_text.setText("Don't have any pending payment");
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
                timeline.play();

            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            try {
                get_info();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
    }

    public void get_info() throws FileNotFoundException {

        String directoryPath = "D:/Java Soft/diner_payment/" + user.getUser() + "/" + "info.txt";
        File directory = new File(directoryPath);

        if (directory.exists()){

            Scanner sc = new Scanner(directory);
            sc.useDelimiter("\n");
            String p1 = sc.next();
            String p2 = sc.next();
            String p3 = sc.next();
            String p4 = sc.next();
            String p5 = sc.next();
            String p6 = sc.next();
            String p7 = sc.next();

            sc.close();

            s_amount.setText(p2);
            s_location.setText(p6);
            s_no.setText(p7);
            s_user.setText(p1);
        }
        else {
            error_text.setText("Don't have any pending payment");
        }

    }
    public void pay(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/bkash.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
