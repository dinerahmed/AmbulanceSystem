package com.example.ambulancesystem.controllers.ADMIN;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.all_class.Login;
import com.example.ambulancesystem.all_class.USER;
import com.example.ambulancesystem.all_class.amb_show;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class manage_amb implements Initializable {


    static Login login = new Login();

    public void setLogin(Login log)
    {
        login = log;
    }



    @FXML
    private TableView<amb_show> amb_view = new TableView<>();

    @FXML
    public TableColumn<amb_show,String> v_no ;
    @FXML
    private TableColumn<amb_show,String> user1;
    @FXML
    private TableColumn<amb_show,String> location;

    ObservableList<amb_show> view = FXCollections.observableArrayList();



    @FXML
    private Label error_text;


    @FXML
    void delete(ActionEvent event) {
        amb_show selected = amb_view.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String user = selected.getUser();

            view.remove(selected);

            deleteFiles(user);

        } else {

            error_text.setText("Please select a exam slot to delete.");
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
            timeline.play();
        }
    }

    private void deleteFiles(String no) {
        String directoryPath = "D:/Java Soft/diner_ambulance/" + no;
        File directory = new File(directoryPath);
        String directoryPath1 = "D:/Java Soft/diner_accept/" + no;
        File directory1 = new File(directoryPath1);

        if (directory.exists() && directory.isDirectory()) {

            deleteDirectory(directory);
        }
        if (directory1.exists() && directory1.isDirectory()) {

            deleteDirectory(directory1);
        }
    }

    private void deleteDirectory(File directory) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        directory.delete();
    }



    static amb_show amb = new amb_show();
    public void view_history() throws FileNotFoundException {

        String directoryPath = "D:/Java Soft/diner_ambulance/";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {

            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {

                    if (fileOrDir.isDirectory()) {
                        String c1= fileOrDir.getName();

                        get_items(c1);

                        view.add(amb);
                    }
                }
            }
        }
    }


    void get_items(String c) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Soft/diner_ambulance/" + c + "/info.txt");
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

            amb = new amb_show(p7,p2,p6);
            sc.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        v_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        user1.setCellValueFactory(new PropertyValueFactory<>("user"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));


        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        amb_view.setItems(view);
    }

}
