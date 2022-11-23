package com.example.donalwall;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //loads the fxml screen that i will start on
    public static Scene scene1,scene2,scene3,scene4;
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("displayCase.fxml"));
        scene1 = new Scene(fxmlLoader.load(), 500, 250);
        stage.setTitle("Jewellery Store");
        stage.setScene(scene1);
        stage.show();

        fxmlLoader = new FXMLLoader(Main.class.getResource("displayTray.fxml"));
        scene2 = new Scene(fxmlLoader.load(), 500, 250);

        fxmlLoader = new FXMLLoader(Main.class.getResource("jewelleryItem.fxml"));
        scene3 = new Scene(fxmlLoader.load(), 500, 250);

        fxmlLoader = new FXMLLoader(Main.class.getResource("material.fxml"));
        scene4 = new Scene(fxmlLoader.load(), 500, 250);
    }

    public static void main(String[] args) {
        launch();
    }
}