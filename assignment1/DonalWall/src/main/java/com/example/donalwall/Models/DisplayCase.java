package com.example.donalwall.Models;

public class DisplayCase {
    //my fields
    public DisplayCase nextCase;
    public String UID;
    public boolean isLit;
    public boolean isWallMounted;
    public DisplayTray firstTray;
//basic constructor
    public DisplayCase(DisplayCase nextCase, String UID, boolean isLit, boolean isWallMounted) {
        this.nextCase = nextCase;
        this.UID = UID;
        this.isLit = isLit;
        this.isWallMounted = isWallMounted;

    }
//basic getters and setter for all my fields
    public DisplayCase getNextCase() {
        return nextCase;
    }

    public void setNextCase(DisplayCase nextCase) {
        this.nextCase = nextCase;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public boolean isLit() {
        return isLit;
    }

    public void setLit(boolean lit) {
        isLit = lit;
    }

    public boolean isWallMounted() {
        return isWallMounted;
    }

    public void setWallMounted(boolean wallMounted) {
        isWallMounted = wallMounted;
    }
//To string which displays my variables in a readable string format
    @Override
    public String toString() {
        return " DisplayCaseUID( " + UID +
                " ) Lit : " + isLit +
                " Wall Mounted : " + isWallMounted +
                " ";
    }
}