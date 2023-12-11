package com.example.ambulancesystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/SignUp.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/hyperTEST.fxml"));
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 650);
        stage.setTitle("Hello!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}