package com.example.donalwall.Controllers;

import com.example.donalwall.Models.DisplayCase;
import com.example.donalwall.Models.DisplayTray;
import com.example.donalwall.Models.JewelleryItem;
import com.example.donalwall.Main;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
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

import java.io.*;
import java.util.Locale;

import static com.example.donalwall.Controllers.Controller.firstCase;
import static com.example.donalwall.Controllers.DisplayTrayController.firstTray;

public class JewelleryItemController {
//fields for fxml
    public ChoiceBox<String> gender;
    public TextField description, type, URL, retailPrice;
    public ListView<JewelleryItem> ji;
//fields
    public static JewelleryItem firstItem;
    public static JewelleryItem selectedItem;
    //this method is used when an item is added
    public void addJewelleryItem(String itemDescription, String type, String gender, String URL, int retailPrice) {
        JewelleryItem ji1 = new JewelleryItem(DisplayTrayController.selectedTray, itemDescription, type, gender, URL, retailPrice);
//when an item is created it must have to following
        ji1.setItemDescription(itemDescription);
        ji1.setType(type);
        ji1.setGender(gender);
        ji1.setURL(URL);
        ji1.setRetailPrice(retailPrice);
        populateListBox();
    }
    //this method allows me to display my linked list in a listview
    public void populateListBox(){
        JewelleryItem temp = DisplayTrayController.selectedTray.firstItem;
        ji.getItems().clear();
        while (temp != null) {
            System.out.println(temp.getURL());
            ji.getItems().add(temp);
            temp = temp.getNextItem();
        }
    }
//this method adds my item to the listview
    public void addItem(ActionEvent actionEvent) {

        addJewelleryItem(description.getText(),type.getText(),gender.getValue(),URL.getText(),retailPrice.getPrefColumnCount());

    }
//this method allows me to delete an item from my listview
    public void deleteItem(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.BACK_SPACE &&
                ji.getSelectionModel().getSelectedIndex() >= 0)
            ji.getItems().remove(ji.getSelectionModel()
                    .getSelectedIndex());

    }
//these 2 methods changes scenes

    public void changeScene(ActionEvent createCase) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("displayTray.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) ((Button) createCase.getSource()).getScene().getWindow();
        s.setScene(scene);

    }

    public void changeScene3(ActionEvent createMaterial) {
        Main.primaryStage.setScene(Main.scene4);
    }
//initialises my linked list items and my choice box options on startup
    public void initialize() {
        gender.getItems().addAll("Male", "Female");
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//allows me to drill down through the items
    public void selectItem(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2) {
            selectedItem = ji.getSelectionModel().getSelectedItem();
            Main.primaryStage.setScene(Main.scene4);
        }
    }

    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{JewelleryItem.class};

        //setting up the XStream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(fileName()));
        firstItem = (JewelleryItem) in.readObject();
        in.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(firstItem);
        out.close();
    }

    public String fileName(){
        return "items.xml";
    }
    //creates a method to search for an item of jewellery

    public ListView<String> searchListView;
    public TextField search;

    public void searchJewelleryItem() {
        //have the button set the search variable to what's written
        DisplayCase temp1 = firstCase;
        DisplayTray temp2 = firstTray;
        JewelleryItem temp3 = firstItem;
        while(temp1 != null) {
            temp2=temp1.firstTray;
            while (temp2 != null) {
                temp3=temp2.firstItem;
                while (temp3 != null) {
                    if (temp3.itemDescription.contains(search.getText()))
                        searchListView.getItems().add(String.valueOf(temp3));
                    temp3 = temp3.nextItem;
                }
                temp2 = temp2.nextTray;
            }
            temp1 = temp1.nextCase;
        }
    }

    public void resetItems(){
        firstItem=null;
        ji.getItems().clear();
        //by setting the head to null we delete the list all together
    }

}
