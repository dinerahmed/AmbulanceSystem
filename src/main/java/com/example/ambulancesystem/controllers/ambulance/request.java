package com.example.ambulancesystem.controllers.ambulance;

import com.example.ambulancesystem.all_class.Ambulance;
import com.example.ambulancesystem.all_class.amb_avail;
import com.example.ambulancesystem.all_class.requ;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import javafx.scene.control.Label;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class request implements Initializable
{

    @FXML
    private TableColumn<requ, String> amount;

    @FXML
    private TableColumn<requ, String> date;

    @FXML
    private TableColumn<requ, String> user;

    @FXML
    private TableView<requ> hist;

    @FXML
    private TableColumn<requ, String> location;

    @FXML
    private TableColumn<requ, String> time;


    static Ambulance ambulance = new Ambulance();
    public void set_ambulance(Ambulance am)
    {
        ambulance = am;
    }

    ObservableList<requ> view = FXCollections.observableArrayList();

    static requ amb = new requ();
    public void view_history() throws FileNotFoundException {

        String directoryPath = "D:/Java Soft/diner_book/";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {

            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {

                    if (fileOrDir.isDirectory()) {
                        String c1= fileOrDir.getName();
                        String c2=ambulance.getAddress();
                        String [] v1=c1.split(",");
                        String [] v2=c2.split(",");
                        if(v1[0].equals(v2[0])) {
                            get_items(c1);

                        }
                    }
                }
            }
        }
    }


    void get_items(String c) throws FileNotFoundException {

        File directory= new File("D:/Java Soft/diner_book/" + c );


        if (directory.exists() && directory.isDirectory()) {

            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {

                    if (fileOrDir.isDirectory()) {
                        String c1= fileOrDir.getName();

                        File infoFile2 = new File("D:/Java Soft/diner_book/" + c + "/" + c1 + "/info.txt");
                        if (infoFile2.exists()) {
                            Scanner sc = new Scanner(infoFile2);

                            sc.useDelimiter("\n");

                            String p1 = sc.next();
                            String p2 = sc.next();
                            String p3 = sc.next();
                            String p4 = sc.next();

                            amb = new requ(p1,p2,p3,p4,"",c1);
                            sc.close();
                        }

                    }

                    view.add(amb);
                }
            }
        }


    }




    @FXML
    private Label error_text;

    public boolean check_request()
    {
        String directoryPath = "D:/Java Soft/diner_accept/" + ambulance.getUser() ;
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {

            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {

                    if (fileOrDir.isDirectory()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @FXML
    void accept_request(ActionEvent event) throws IOException {
        requ selected = hist.getSelectionModel().getSelectedItem();
        if (selected != null) {

            if(check_request())
            {
                error_text.setText("You have already accepted a request.");
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
                timeline.play();
                return;
            }

            String loca = selected.getLocation();
            String user = selected.getUser();
            view.remove(selected);
            deleteFiles(loca,user);
            accept(selected);

        } else {
            error_text.setText("Please select a slot.");
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
            timeline.play();
        }
    }

    private void deleteFiles(String loc, String user) {
        String directoryPath = "D:/Java Soft/diner_book/" + loc + "/" + user;
        File directory = new File(directoryPath);
        String directoryPath1 = "D:/Java Soft/diner_book/" + loc;
        File directory1 = new File(directoryPath);

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


    public void accept(requ r) throws IOException {
        String directoryPath = "D:/Java Soft/diner_accept/" + ambulance.getUser() ;
        File directory = new File(directoryPath);
        directory.mkdir();
        File infoFile = new File("D:/Java Soft/diner_accept/" + ambulance.getUser() + "/" + r.getUser());
        infoFile.mkdir();

        String p = "D:/Java Soft/diner_accept/" + ambulance.getUser() + "/" + r.getUser();
        File infoFile2 = new File("D:/Java Soft/diner_accept/" + ambulance.getUser() + "/" + r.getUser()+"/info.txt");

        infoFile2.createNewFile();

        FileWriter writer = new FileWriter(infoFile2);

        writer.write(ambulance.getUser() + "\n");
        writer.write(r.getAmount() + "\n");
        writer.write(r.getDate() + "\n");
        writer.write(r.getUser() + "\n");
        writer.write(r.getTime() + "\n");
        writer.write(r.getLocation() + "\n");
        writer.write(ambulance.getV_no() + "\n");
        writer.close();

        update_user_book(p,r.getUser());
    }

    public void update_user_book(String p,String user) throws IOException {

        File infoFile2 = new File("D:/Java Soft/diner_user/" + user +"/book.txt");

        infoFile2.createNewFile();

        FileWriter writer = new FileWriter(infoFile2);

        writer.write(p + "\n");
        writer.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));

        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        hist.setItems(view);

    }

}
