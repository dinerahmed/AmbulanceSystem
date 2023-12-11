package com.example.ambulancesystem.controllers.ADMIN;

import com.example.ambulancesystem.all_class.amb_show;
import com.example.ambulancesystem.all_class.process;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class payment implements Initializable {

    @FXML
    private TableColumn<process, String> amount;

    @FXML
    private TableColumn<process, String> driver;

    @FXML
    private TableColumn<process, String> id;

    @FXML
    private TableColumn<process, String> method;

    @FXML
    private TableView<process> pay;

    @FXML
    private TableColumn<process, String> ref;

    @FXML
    private TableColumn<process, String> trans;

    @FXML
    private TableColumn<process, String> user;

    @FXML
    private Label error_text;

    ObservableList<process> view = FXCollections.observableArrayList();

    @FXML
    void confirm(ActionEvent event) {

        process selected = pay.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String user = selected.getUser();

            view.remove(selected);
            deleteFiles(user);

            deleteFiles2(user);

        } else {

            error_text.setText("Please select a slot to delete.");
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
            timeline.play();
        }
    }



    private void deleteFiles(String no) {
        String directoryPath = "D:/Java Soft/diner_payment_process/" + no;
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            deleteDirectory(directory);
        }
    }

    private void deleteFiles2(String no) {
        String directoryPath = "D:/Java Soft/diner_payment/" + no;
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            deleteDirectory(directory);
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


    @FXML
    void delete(ActionEvent event) {

        process selected = pay.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String user = selected.getUser();

            view.remove(selected);
            deleteFiles(user);

        } else {

            error_text.setText("Please select a slot to delete.");
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
            timeline.play();
        }
    }

    public void view_history() throws FileNotFoundException {

        String directoryPath = "D:/Java Soft/diner_payment_process/";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {

            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {

                    if (fileOrDir.isDirectory()) {
                        String c1= fileOrDir.getName();

                        get_items(c1);

                    }
                }
            }
        }
    }

    void get_items(String c) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Soft/diner_payment_process/" + c + "/info.txt");
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
            String p8 = sc.next();
            String p9 = sc.next();
            String p10 = sc.next();
            String p11 = sc.next();

            process pro = new process(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);

            view.add(pro);

            sc.close();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        method.setCellValueFactory(new PropertyValueFactory<>("method"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        trans.setCellValueFactory(new PropertyValueFactory<>("trans"));
        ref.setCellValueFactory(new PropertyValueFactory<>("ref"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        driver.setCellValueFactory(new PropertyValueFactory<>("driver"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));


        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        pay.setItems(view);

    }
}
