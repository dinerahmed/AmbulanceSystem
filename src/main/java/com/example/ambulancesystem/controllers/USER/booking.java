package com.example.ambulancesystem.controllers.USER;

import com.example.ambulancesystem.HelloApplication;
import com.example.ambulancesystem.URISyntaxException;
import com.example.ambulancesystem.all_class.USER;
import com.example.ambulancesystem.all_class.amb_show;
import com.example.ambulancesystem.all_class.mring;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class booking implements Initializable {

    @FXML
    private TextField amount;

    @FXML
    private TableColumn<mring, String> c_inbox;
    @FXML
    private TableView<mring> inbox;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> sub_area = new ComboBox<>();
    private String[] area_value = {"Gulshan", "Baridhara", "Dhanmondi", "Mirpur", "Uttara", "Mohammadpur"};
    @FXML
    private ComboBox<String> area = new ComboBox<>();
    private String[] sub_value = {"Dhaka"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        c_inbox.setCellValueFactory(new PropertyValueFactory<>("msg"));

        area.getItems().addAll(area_value);
        sub_area.getItems().addAll(sub_value);

        try {
            update_your_book();
            try {
                update_message();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        inbox.setItems(view);

    }


    public void update_your_book() throws FileNotFoundException {

        String directoryPath = "D:/Java Soft/diner_user/" + user.getUser() + "/book.txt";
        File directory = new File(directoryPath);
        if (directory.exists()) {

            Scanner sc = new Scanner(directory);
            sc.useDelimiter("\n");

            String p1 = sc.next();

            File directory1 = new File(p1+"/info.txt");
            path = p1;

            if (directory1.exists()) {

                Scanner sc1 = new Scanner(directory1);
                sc1.useDelimiter("\n");
                String q1 = sc1.next();
                String q2 = sc1.next();
                String q3 = sc1.next();
                String q4 = sc1.next();
                String q5 = sc1.next();
                String q6 = sc1.next();
                String q7 = sc1.next();

                s_user.setText(q1);
                s_no.setText(q7);
                s_amount.setText(q2);
                s_location.setText(q6);

                sc.close();
            }

        }

    }


    @FXML
    private Label s_amount;

    @FXML
    private Label s_location;

    @FXML
    private Label s_no;

    @FXML
    private Label s_user;

    @FXML
    private TextField time;

    @FXML
    private Label msg_error;

    public String path = null;
    static USER user = new USER();

    public void setUser(USER user) {
        this.user = user;
    }

    @FXML
    void request(ActionEvent event) throws IOException {

        if (area.getValue()==null || sub_area.getValue()==null || amount.getText().isEmpty() || time.getText().isEmpty() || date.getValue() == null) {
            msg_error.setText("Fill All The Boxes");
        } else {

            String loc = area.getValue() + "," + sub_area.getValue();
            String am = amount.getText();
            String ti = time.getText();
            String da = date.getValue().toString();

            area.setValue(null);
            sub_area.setValue(null);
            amount.setText("");
            time.setText("");
            date.setValue(null);

            File user_folder10 = new File("D:/Java Soft/diner_payment/");
            boolean is_user_folder_created10 = user_folder10.mkdir();

            File user_folder1 = new File("D:/Java Soft/diner_payment/" + user.getUser() + "/info.txt");
            if(user_folder1.exists())
            {
                msg_error.setText("Please Pay Previous one First");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> msg_error.setText("")));
                timeline.play();
                return;
            }


            File user_folder = new File("D:/Java Soft/diner_book/");
            boolean is_user_folder_created = user_folder.mkdir();

            File[] files = user_folder.listFiles();

            assert files != null;
            for (File file : files) {

                File userFile1 = new File("D:/Java Soft/diner_book/" + file.getName() + "/");

                File[] files1 = userFile1.listFiles();

                assert files1 != null;
                for (File file1 : files1)
                {
                    if(user.getUser().equals(file1.getName()))
                    {
                        msg_error.setText("Already exists.");
                        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> msg_error.setText("")));
                        timeline.play();

                        return;
                    }
                }
            }



            File userFile = new File("D:/Java Soft/diner_book/" + loc);
            boolean is_user_file_created = userFile.mkdir();

            File userFile1 = new File("D:/Java Soft/diner_book/" + loc + "/"+ user.getUser());
                boolean is_user_file_created1 = userFile1.mkdir();

                File infoFile = new File("D:/Java Soft/diner_book/" + loc + "/" + user.getUser() + "/info.txt");
                infoFile.createNewFile();

                FileWriter writer = new FileWriter(infoFile);
                writer.write(loc + "\n");
                writer.write(am + "\n");
                writer.write(ti + "\n");
                writer.write(da + "\n");
                writer.close();


                msg_error.setText("Request Sent");

        }

    }

    ObservableList<mring> view = FXCollections.observableArrayList();

    @FXML
    private TextField msg_text;

    @FXML
    void message(ActionEvent event) throws IOException {

        String p =user.getUser()+ " : " + msg_text.getText();
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

}
