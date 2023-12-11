package com.example.ambulancesystem;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//dinerahmed05
//crzgoxdgpzgugoog
public class Forgot_pass {
    @FXML
    private Button confirm;

    @FXML
    private TextField gmail;

    @FXML
    private TextField otp;
    public TextField provide_mail, auth_mail, auth_code, user_N;

    @FXML
    private PasswordField confirm_pass;

    @FXML
    private PasswordField new_pass;
    public Button log_in;
    public Label message, new_pass_message, auth_mail_message, code_message;
    public static int code;
    static String fp;
    static check_email checkEmail = new check_email();

    public boolean check_email(String u, String e) throws FileNotFoundException {
        File infoFile2 = new File("D:/Java Soft/diner_user/" + u + "/info.txt");

        Scanner sc = new Scanner(infoFile2);

        sc.useDelimiter("\n");

        String p = sc.next();
        p = sc.next();
        p = sc.next();


        check_email checkEmail = new check_email();
        return check_email.isEmailValid(p,  e);
    }
    public void BACK(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/userlogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void BACK_(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/FORGOT/forgetpassword.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void get_otp(ActionEvent event) throws IOException {

//        boolean check = checkEmail.isEmailValid(auth_mail.getText());

        if (gmail.getText().isBlank() || user_N.getText().isBlank()) {
            message.setText("Fill out all the fields to proceed.");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ev -> message.setText("")));
            timeline.play();
        }
        else {
            boolean p = check_email(user_N.getText(), gmail.getText());
            System.out.println(p);
            if (p) {
                    fp = user_N.getText();
                    Mail_background mail_background_task = new Mail_background();
                    code = mail_background_task.sendOTP(gmail.getText());

                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/FORGOT/otp.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else{
                    message.setText("Email not sent");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> message.setText("")));
                    timeline.play();
                }
            }

        }



        public void user_createPass (ActionEvent event) throws IOException {

            if (otp.getText().isBlank()) {
                code_message.setText("Code cannot be blank");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> code_message.setText("")));
                timeline.play();
            } else {
                if (otp.getText().equals(String.valueOf(code))) {
                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/FORGOT/confirmnewpass.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    code_message.setText("Code do not match");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> code_message.setText("")));
                    timeline.play();
                }
            }
        }


        public void user_sign_in (ActionEvent event) {

            String tnew = new_pass.getText();
            String tconfirm = confirm_pass.getText();

            if (new_pass.getText().isBlank() || confirm_pass.getText().isBlank()) {
                new_pass_message.setText("New password cannot be empty");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> new_pass_message.setText("")));
                timeline.play();
            } else if (!new_pass.getText().equals(confirm_pass.getText())) {
                new_pass_message.setText("Passwords do not match");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> new_pass_message.setText("")));
                timeline.play();
            } else {
                try {
                    File path = new File("D:/Java Soft/diner_user/" + fp + "/info.txt");
                    Scanner sc = new Scanner(path);
                    ArrayList<String> lines = new ArrayList<>();

                    sc.useDelimiter("\n");

                    String p = sc.next();
                    String l1 = p;
                    p = sc.next();
                    String l2 = p;
                    p = sc.next();
                    String l3 = p;
                    p = sc.next();
                    String l4 = p;
                    p = sc.next();
                    String l5 = p;
                    p = sc.next();
                    String l6 = p;
                    p = sc.next();
                    String l7 = p;
 



                    BufferedWriter writer = new BufferedWriter(new FileWriter(path));

                    writer.write(l1 + "\n");
                    writer.write(l2 + "\n");
                    writer.write(l3 + "\n");
                    writer.write(l4 + "\n");
                    writer.write(tnew + "\n");
                    writer.write(l5 + "\n");
                    writer.write(l6 + "\n");
                    writer.write(l7 + "\n");

                    writer.close();

                        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/USER/userlogin.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}

