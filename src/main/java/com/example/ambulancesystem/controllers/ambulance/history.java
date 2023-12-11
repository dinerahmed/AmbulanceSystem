package com.example.ambulancesystem.controllers.ambulance;

import com.example.ambulancesystem.all_class.Ambulance;
import com.example.ambulancesystem.all_class.History;
import com.example.ambulancesystem.all_class.USER;
import com.example.ambulancesystem.all_class.process;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class history implements Initializable {

    @FXML
    private TableColumn<History, String> amount;

    @FXML
    private TableColumn<History, String> date;

    @FXML
    private TableView<History> hist;

    @FXML
    private TableColumn<History, String> location;

    @FXML
    private TableColumn<History, String> time;

    @FXML
    private TableColumn<History, String> user;

    ObservableList<History> view = FXCollections.observableArrayList();

    public void set_ambulance(Ambulance log)
    {
        use = log;
    }

    static Ambulance use = new Ambulance();
    void view_history() throws IOException {

        File infoFile2 = new File("D:/Java Soft/diner_history_ambulance/" + use.getUser() + "/info.csv");
        if (infoFile2.exists()) {

            BufferedReader r=new BufferedReader(new FileReader(infoFile2));

            String line="";

            while ((line=r.readLine())!=null)
            {
                String [] value=line.split(",");
                History p1 = new History(value[0], value[1], value[2], value[3], value[4], value[5]+","+value[6]);

                view.add(p1);
            }
            r.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));


        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        hist.setItems(view);
    }
}
