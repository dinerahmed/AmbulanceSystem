package com.example.ambulancesystem.controllers.USER;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.check_email;
import com.example.ambulancesystem.check_mobile;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class registration implements Initializable {

    @FXML
    private ComboBox<String> sub_area = new ComboBox<>();
    private String[] area_value = {"Gulshan", "Baridhara", "Dhanmondi", "Mirpur", "Uttara", "Mohammadpur"};
    @FXML
    private ComboBox<String> area = new ComboBox<>();
    private String[] sub_value = {"Dhaka"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        area.getItems().addAll(area_value);
        sub_area.getItems().addAll(sub_value);

    }

    @FXML
    private DatePicker birth;

    @FXML
    private TextField email;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private Label msg_error;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField phn_number;

    @FXML
    private PasswordField repass;



    static check_email checkEmail =new check_email();
    static check_mobile checkMobile= new check_mobile();


    @FXML
    public void reg_complete(ActionEvent event) throws IOException {

        boolean check = checkEmail.isEmailValid(email.getText());
        boolean check2 = checkMobile.isValid(phn_number.getText());

        String p1 = pass.getText();
        String r1 = repass.getText();

        if(phn_number.getText().isBlank() || repass.getText().isBlank() || pass.getText().isBlank() || email.getText().isBlank()
                || area.getValue()==null || sub_area.getValue()==null|| birth.getValue()==null || first_name.getText().isBlank() ||
                last_name.getText().isBlank())
        {
            msg_error.setText("Fill All The Boxes");
        } else if (!check) {
            msg_error.setText("Invalid  Email");
        }
        else if (!check2) {
            msg_error.setText("Invalid  Phn number");


        } else {
            System.out.println(p1);
            System.out.println(r1);
            if(!p1.equals(r1))
            {
                msg_error.setText("Password Is Not Same");
                return;
            }
            boolean isUserCreated = create_user();
            if (!isUserCreated)
                return;

            Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/SignUp.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }



    public boolean create_user() throws IOException
    {
        String tphn_number = phn_number.getText();
        String trepass = repass.getText();
        String tpass = pass.getText();
        String temail = email.getText();
        String tlast = last_name.getText();
        String tfirst_name = first_name.getText();
        String tarea = area.getValue();
        String tsub_area = sub_area.getValue();
        String taddress = tarea + "," + tsub_area;
        String tbirth=birth.getValue().toString();


        File user_folder = new File("D:/Java Soft/diner_user/");
        boolean is_user_folder_created = user_folder.mkdir();

        File[] files = user_folder.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.getName().equals(tlast)) {
                System.out.println("Account already exists");
                msg_error.setText("Account already exists.");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent-> msg_error.setText("")));
                timeline.play();
            }
        }

        File userFile = new File("D:/Java Soft/diner_user/" + tlast);
        boolean is_user_file_created = userFile.mkdir();

        File infoFile = new File("D:/Java Soft/diner_user/" + tlast+ "/info.txt");
        infoFile.createNewFile();
        System.out.println(tlast);
        FileWriter writer = new FileWriter(infoFile);
        writer.write(tfirst_name + "\n");
        writer.write(tlast + "\n");
        writer.write(temail + "\n");
        writer.write(tphn_number + "\n");
        writer.write(tpass + "\n");
        writer.write(taddress+"\n");
        writer.write(tbirth+"\n");
        writer.close();

        return true;
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
