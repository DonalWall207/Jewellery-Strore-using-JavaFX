package com.example.donalwall.Models;

public class JewelleryItem {
    //fields
    public JewelleryItem nextItem;
    public Material firstMaterial;
    public String itemDescription;
    public String type;
    public String gender;
    public String URL;
    public int retailPrice;
    //constructors
    public JewelleryItem(DisplayTray dt,  String itemDescription, String type, String gender, String URL,int retailPrice) {
        this.itemDescription = itemDescription;
        this.type = type;
        this.gender = gender;
        this.URL = URL;
        this.retailPrice=retailPrice;
    //this ensures that my next item I add will be added on to the list from the start of the head display tray
        this.nextItem=dt.firstItem;
        dt.firstItem=this;
    }
    //basic getters and setters
    public JewelleryItem getNextItem() {
        return nextItem;
    }

    public void setNextItem(JewelleryItem nextItem) {
        this.nextItem = nextItem;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setRetailPrice(int retailPrice){
        this.retailPrice = retailPrice;
    }

    public int getRetailPrice() {
        return retailPrice;
    }
    // takes my variables and returns the values in a readable string format
    @Override
    public String toString() {
        return "JewelleryItem " +
                " itemDescription " + itemDescription  +
                " type = " + type  +
                " gender = " + gender +
                " Price = " + retailPrice +
                ' ';
    }
}
