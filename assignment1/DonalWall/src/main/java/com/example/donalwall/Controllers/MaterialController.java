package com.example.donalwall.Controllers;

import com.example.donalwall.Main;
import com.example.donalwall.Models.DisplayCase;
import com.example.donalwall.Models.JewelleryItem;
import com.example.donalwall.Models.Material;
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

public class MaterialController {
    //Add fields for my items in FXML
    public ChoiceBox<Integer> quality,amount;
    public TextField description,type;
    public ListView<Material> mt;
    //for linked list
    public static Material firstMaterial;
    public static Material selectedMaterial;
//verifies my material added has the correct information
    public void addMaterial(String type, String description, int quality, int amount) {
        Material ma = new Material(JewelleryItemController.selectedItem, type, description, quality, amount);
    //information needed for a material to be added
        ma.setType(type);
        ma.setDescription(description);
        ma.setQuality(quality);
        ma.setAmount(amount);
        populateListBox();

    }
// populates my listview with my linked list
    public void populateListBox(){
        Material temp = JewelleryItemController.selectedItem.firstMaterial;
        while (temp != null) {
            mt.getItems().clear();
            System.out.println(temp.getType());
            mt.getItems().add(temp);
            temp = temp.getNextMaterial();
        }
    }
//adds a material to my linked lists nd mt list view
    public void addMat(ActionEvent actionEvent) {

        addMaterial(type.getText(),description.getText(),quality.getValue(),amount.getValue());
    }
// deletes a material from the listview
    public void deleteMat(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.BACK_SPACE &&
                mt.getSelectionModel().getSelectedIndex() >= 0)
            mt.getItems().remove(mt.getSelectionModel()
                    .getSelectedIndex());

    }
// initialises my linked list items and my choice box options on startup
    public void initialize() {
        quality.getItems().addAll(1,2,3,4,5);
        amount.getItems().addAll(1,2,3,4,5,6);
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // code that changes scene
    public void changeScene2(ActionEvent createItem) throws IOException {
        Main.primaryStage.setScene(Main.scene3);
    }
//allows me to select a certain material for deletion
    public void selectMaterial(MouseEvent mouseEvent) {
        selectedMaterial = mt.getSelectionModel().getSelectedItem();
    }

    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{Material.class};

        //setting up the XStream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(fileName()));
        firstMaterial = (Material) in.readObject();
        in.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(firstMaterial);
        out.close();
    }

    public String fileName(){
        return "materials.xml";
    }

    public void resetMaterials(){
        firstMaterial=null;
        mt.getItems().clear();
        //by setting the head to null we delete the list all together
    }
}
