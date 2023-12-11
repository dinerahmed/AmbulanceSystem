package com.example.ambulancesystem.controllers.ambulance;

import com.example.ambulancesystem.all_class.Ambulance;
import com.example.ambulancesystem.all_class.mring;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class status implements Initializable {

    @FXML
    private Label amount;

    @FXML
    private Label date;

    @FXML
    private Label location;

    @FXML
    private Label time;

    @FXML
    private Label user;
    public Label error_text;

    @FXML
    private TableColumn<mring, String> c_inbox;
    @FXML
    private TableView<mring> inbox;

    public String path = null;
    ObservableList<mring> view = FXCollections.observableArrayList();

    @FXML
    private TextField msg_text;

    @FXML
    void message(ActionEvent event) throws IOException {

        String p =ambulance.getUser()+ " : " + msg_text.getText();
        if(path!=null && p!=null){
            File f = new File(path);
            if (f.exists()) {
                String directoryPath = path + "/msg.txt";
                File directory = new File(directoryPath);
                directory.createNewFile();

                if (directory.exists()) {
                    BufferedWriter writer=new BufferedWriter(new FileWriter(directory,true));
                    writer.write(p + "\n");
                    writer.close();

                    mring m = new mring(p);
                    view.add(m);
                }
            }
        }
    }


    public void update_message() throws IOException {

        if(path!=null) {
            File f = new File(path);
            if (f.exists()) {

                String directoryPath = path + "/msg.txt";
                File directory = new File(directoryPath);

                if (directory.exists()) {
                    BufferedReader r = new BufferedReader(new FileReader(directory));
                    String line = "";

                    while ((line = r.readLine()) != null) {
                        mring m = new mring(line);
                        view.add(m);
                    }
                }
            }
        }
    }


    static Ambulance ambulance = new Ambulance();
    public void set_ambulance(Ambulance am)
    {
        ambulance = am;
    }

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
    void work_done(ActionEvent event) throws IOException {

        if(check_request())
        {
            String directoryPath = "D:/Java Soft/diner_accept/" + ambulance.getUser() ;
            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {

                File[] filesAndDirs = directory.listFiles();

                if (filesAndDirs != null) {
                    for (File fileOrDir : filesAndDirs) {

                        if (fileOrDir.isDirectory()) {

                            String directoryPath2 = "D:/Java Soft/diner_accept/" + ambulance.getUser() + "/" + fileOrDir.getName() + "/" + "info.txt";
                            File directory2 = new File(directoryPath2);

                            Scanner sc = new Scanner(directory2);
                            sc.useDelimiter("\n");
                            String p1 = sc.next();
                            String p2 = sc.next();
                            String p3 = sc.next();
                            String p4 = sc.next();
                            String p5 = sc.next();
                            String p6 = sc.next();
                            String p7 = sc.next();

                            user.setText("");
                            location.setText("");
                            date.setText("");
                            time.setText("");
                            amount.setText("");
                            sc.close();


                            File directory4 = new File("D:/Java Soft/diner_payment/" + p4);
                            boolean m = directory4.mkdir();

                            String directoryPath3 = "D:/Java Soft/diner_payment/" + p4 + "/" + "info.txt";
                            File directory3 = new File(directoryPath2);
                            boolean n = directory3.createNewFile();

                            FileWriter writer = new FileWriter(directoryPath3);
                            writer.write(p1 + "\n");
                            writer.write(p2 + "\n");
                            writer.write(p3 + "\n");
                            writer.write(p4 + "\n");
                            writer.write(p5 + "\n");
                            writer.write(p6 + "\n");
                            writer.write(p7 + "\n");
                            writer.close();


                            File directory5 = new File("D:/Java Soft/diner_history_user/" + p4);
                            boolean m5 = directory5.mkdir();

                            String directoryPath6 = "D:/Java Soft/diner_history_user/" + p4 + "/" + "info.csv";
                            File directory6 = new File(directoryPath6);
                            boolean n6 = directory6.createNewFile();

                            BufferedWriter writer6=new BufferedWriter(new FileWriter(directoryPath6,true));
                            writer6.write(p1 + ",");
                            writer6.write(p2 + ",");
                            writer6.write(p3 + ",");
                            writer6.write(p4 + ",");
                            writer6.write(p5 + ",");
                            writer6.write(p6 + ",");
                            writer6.write(p7 + "\n");
                            writer6.close();


                            File directory7 = new File("D:/Java Soft/diner_history_ambulance/" + ambulance.getUser());
                            boolean m7 = directory7.mkdir();

                            String directoryPath8 = "D:/Java Soft/diner_history_ambulance/" + ambulance.getUser() + "/" + "info.csv";
                            File directory8 = new File(directoryPath8);
                            boolean n8 = directory8.createNewFile();

                            BufferedWriter writer8=new BufferedWriter(new FileWriter(directoryPath8,true));
                            writer8.write(p1 + ",");
                            writer8.write(p2 + ",");
                            writer8.write(p3 + ",");
                            writer8.write(p4 + ",");
                            writer8.write(p5 + ",");
                            writer8.write(p6 + ",");
                            writer8.write(p7 + "\n");
                            writer8.close();

                            deleteFiles(p4);

                            delete_user_book(p4);



                            view.clear();
                            path = null;

                            error_text.setText("Work Done");
                            Timeline timeline = new Timeline();
                            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
                            timeline.play();

                            return;
                        }

                    }
                }
            }
        }
        else {
            error_text.setText("No work pending");
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000), ae -> error_text.setText("\0")));
            timeline.play();

        }

    }

    public void delete_user_book(String p4) {
        String directoryPath = "D:/Java Soft/diner_user/" + p4 +"/book.txt";
        File directory = new File(directoryPath);
        directory.delete();
    }

    private void deleteFiles(String user) {
        // Constants for directory paths
        String baseDirectoryPath = "D:/Java Soft/diner_accept/";
        String userDirectoryPath = baseDirectoryPath + ambulance.getUser() + "/" + user;

        // Delete the entire user directory
        File userDirectory = new File(userDirectoryPath);
        if (userDirectory.exists() && userDirectory.isDirectory()) {
            deleteDirectory(userDirectory);
            System.out.println(userDirectoryPath + " deleted");
        } else {
            System.out.println(userDirectoryPath + " not found");
        }


        File userDirectory1 = new File(baseDirectoryPath + ambulance.getUser());
        if (userDirectory1.exists() && userDirectory1.isDirectory()) {
            deleteDirectory(userDirectory1);
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




    public void update_status() throws FileNotFoundException {

        String directoryPath = "D:/Java Soft/diner_accept/" + ambulance.getUser() ;
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {

            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {

                    if (fileOrDir.isDirectory()) {

                        String p = "D:/Java Soft/diner_accept/" + ambulance.getUser() + "/" + fileOrDir.getName();
                        path = p;

                        String directoryPath2 = "D:/Java Soft/diner_accept/" + ambulance.getUser() + "/" + fileOrDir.getName() + "/" + "info.txt";
                        File directory2 = new File(directoryPath2);

                        Scanner sc = new Scanner(directory2);
                        sc.useDelimiter("\n");
                        String p1 = sc.next();
                        String p2 = sc.next();
                        String p3 = sc.next();
                        String p4 = sc.next();
                        String p5 = sc.next();
                        String p6 = sc.next();
                        String p7 = sc.next();

                        user.setText(p4);
                        location.setText(p6);
                        date.setText(p3);
                        time.setText(p5);
                        amount.setText(p2);

                        sc.close();
                        return;

                    }
                }
            }
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        c_inbox.setCellValueFactory(new PropertyValueFactory<>("msg"));

        try {
            update_status();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            update_message();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        inbox.setItems(view);
    }

}

