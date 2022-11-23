package com.example.donalwall.Models;

public class DisplayTray {
    //fields
    public DisplayTray nextTray;
    public String UID;
    public String materialColour;
    public String width;
    public String depth;
    public JewelleryItem firstItem;

//constructor
    public DisplayTray(DisplayCase dc, String UID, String materialColour, String width, String depth) {
        this.UID = UID;
        this.materialColour = materialColour;
        this.width = width;
        this.depth = depth;
//this ensures that my next tray I add will be added on to the list from the start of the head display case
        this.nextTray=dc.firstTray;
        dc.firstTray=this;

    }
//basic getters and setters for my methods
    public DisplayTray getNextTray() {
        return nextTray;
    }

    public void setNextTray(DisplayTray nextTray) {
        this.nextTray = nextTray;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getMaterialColour() {
        return materialColour;
    }

    public void setMaterialColour(String materialColour) {
        this.materialColour = materialColour;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }
// takes my variables and returns the values in a readable string format
    @Override
    public String toString() {
        return " DisplayTrayUID( " + UID +
                " ) Colour : " + materialColour  +
                " width :" + width  +
                " mm and depth :" + depth  +
                " mm ";
    }
}
