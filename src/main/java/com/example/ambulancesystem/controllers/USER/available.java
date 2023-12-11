package com.example.ambulancesystem.controllers.USER;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.URISyntaxException;
import com.example.ambulancesystem.all_class.amb_avail;
import com.example.ambulancesystem.all_class.amb_show;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class available implements Initializable {

    @FXML
    private TableView<amb_avail> avail;

    @FXML
    private TableColumn<amb_avail, String> location;

    @FXML
    private TableColumn<amb_avail, String> no;

    @FXML
    private TableColumn<amb_avail, String> user;


    ObservableList<amb_avail> view = FXCollections.observableArrayList();

    static amb_avail amb = new amb_avail();
    public void view_history() throws FileNotFoundException {

        String directoryPath = "D:/Java Soft/diner_ambulance/";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {

            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {

                    if (fileOrDir.isDirectory()) {
                        String c1= fileOrDir.getName();

                        if(!avail(c1)){
                            get_items(c1);
                            view.add(amb);
                        }
                    }
                }
            }
        }
    }


    public boolean avail(String p) {
        String directoryPath = "D:/Java Soft/diner_accept/" + p;
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] allContents = directory.listFiles();

            if (allContents != null && allContents.length > 0) {

                return true;
            }
        }

        return false;
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

            amb = new amb_avail(p2,p7,p6);
            sc.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));

        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        avail.setItems(view);
    }
}
