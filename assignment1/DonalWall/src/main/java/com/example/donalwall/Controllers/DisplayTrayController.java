package com.example.donalwall.Controllers;

import com.example.donalwall.Models.DisplayCase;
import com.example.donalwall.Models.DisplayTray;
import com.example.donalwall.Main;
import com.thoughtworks.xstream.XStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

public class DisplayTrayController {
    //fields for fxml
    public ChoiceBox<String> matColor;
    public TextField UID2, width, depth;
    public ListView<DisplayTray> dty;
//fields
    public static DisplayTray firstTray;
    public static DisplayTray selectedTray;

//this method is used when a tray is added
    public void addDisplayTray(String UID, String materialColour, String width, String depth) {
        DisplayTray dt1 = new DisplayTray(Controller.selectedCase, UID, materialColour, width, depth);
        //the necessary information needed to add a tray

        dt1.setUID(UID);
        dt1.setMaterialColour(materialColour);
        dt1.setWidth(width);
        dt1.setDepth(depth);
        populateListBox();
    }
    //this method allows me to display my linked list in a listview
    public void populateListBox(){
        DisplayTray temp = Controller.selectedCase.firstTray;
        dty.getItems().clear();
        while (temp != null) {
            System.out.println(temp.getUID());
            dty.getItems().add(temp);
            temp = temp.getNextTray();
        }
    }
    //this method adds my Tray to the listview
    public void addTray(ActionEvent actionEvent) {
            addDisplayTray(UID2.getText(), matColor.getValue(), width.getText(), depth.getText());
    }

    //method deletes a tray from the listview
    public void deleteTray(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.BACK_SPACE &&
                dty.getSelectionModel().getSelectedIndex() >= 0)
            dty.getItems().remove(dty.getSelectionModel()
                    .getSelectedIndex());

    }
    //code to change scene
    public void changeScene1(ActionEvent createTray) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("displayCase.fxml"));
        Scene scene1 = null;
        try {
            scene1 = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) ((Button) createTray.getSource()).getScene().getWindow();
        s.setScene(scene1);
    }


    public void changeScene2(ActionEvent createItem) throws IOException{
        Main.primaryStage.setScene(Main.scene1);
    }
    //this method initialises the choice box and loads my trays on startup
    public void initialize() {
        matColor.getItems().addAll("Red", "Green", "Blue", "Yellow");
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        //method states that if I click a tray it will go to the next scene
    public void selectItem(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2) {
            selectedTray = dty.getSelectionModel().getSelectedItem();
            Main.primaryStage.setScene(Main.scene3);
        }
    }
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{DisplayCase.class,DisplayTray.class};

        //setting up the XStream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(fileName()));
        firstTray = (DisplayTray) in.readObject();
        in.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(firstTray);
        out.close();
    }

    public String fileName(){
        return "trays.xml";
    }

    public void resetTrays(){
        firstTray=null;
        dty.getItems().clear();
        //by setting the head to null we delete the list all together
    }
}



