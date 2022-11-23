package com.example.donalwall.Controllers;

import com.example.donalwall.Main;
import com.example.donalwall.Models.DisplayCase;
import com.example.donalwall.Models.DisplayTray;
import com.example.donalwall.Models.JewelleryItem;
import com.example.donalwall.Models.Material;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


import java.io.*;

public class Controller {
    //Add fields for my items in FXML
    public ChoiceBox<String> wall;
    public ChoiceBox<String> light;
    public TextField UID;
    public ListView<DisplayCase> dc;
//for linked list
    public static DisplayCase firstCase;
    public static DisplayCase selectedCase;

    //this method is used when a display case is added
    public void addDisplayCase(String UID, boolean isLit, boolean isWallMounted) {
        DisplayCase dc1 = new DisplayCase(null, UID, isLit, isWallMounted);
        //when display case is created it must have to following
        dc1.setUID(UID);
        dc1.setLit(isLit);
        dc1.setWallMounted(isWallMounted);
        dc1.nextCase = Controller.firstCase;
        Controller.firstCase = dc1;
        populateListBox();

    }
    //this method allows me to display my linked list in a listview
    public void populateListBox(){
        DisplayCase temp = firstCase;
        dc.getItems().clear();
        while (temp != null) {
            System.out.println(temp.getUID());
            dc.getItems().add(temp);
            temp = temp.getNextCase();
        }
    }

    //this method adds my Case to the listview
    public void addCase(ActionEvent actionEvent) {
        boolean wallMounted = false;
        boolean lightUp = false;
        if (wall.getValue().equals("Wall Mounted")){
            wallMounted = true;
        }
        if (light.getValue().equals("Lit")){
            lightUp = true;
        }


        addDisplayCase(UID.getText(),wallMounted,lightUp);

    }
//allows me to delete a case using a button
    public void deleteCase(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.BACK_SPACE &&
                dc.getSelectionModel().getSelectedIndex() >= 0)
            dc.getItems().remove(dc.getSelectionModel()
                    .getSelectedIndex());

    }
//initialises my choice box items and loads my list on startup
    public void initialize() {
        wall.getItems().addAll("Wall Mounted", "Free Standing");
        light.getItems().addAll("Lit", "Unlit");
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //code that allows me to change scene
    public void changeScene(ActionEvent createCase) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("displayTray.fxml"));
        UID.getScene().setRoot(fxmlLoader.load());
    }

    //code to load my saves cases to a xml file
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{DisplayCase.class, DisplayTray.class, JewelleryItem.class, Material.class};

        //setting up the XStream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(fileName()));
        firstCase = (DisplayCase) in.readObject();
        in.close();
        populateListBox();
    }
    //code to save my cases to a xml file
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(firstCase);
        out.close();
    }

    public String fileName(){
        return "cases.xml";
    }

//method states that if I click a tray it will go to the next scene
    public void selectTray(MouseEvent mouseEvent) throws IOException{
        if (mouseEvent.getClickCount() == 2) {
            selectedCase = dc.getSelectionModel().getSelectedItem();
            Main.primaryStage.setScene(Main.scene2);
        }
    }
    //this method removes all cases
    public void resetCases(){
        firstCase=null;
        dc.getItems().clear();
        //by setting the head to null we delete the list all together
    }
}



