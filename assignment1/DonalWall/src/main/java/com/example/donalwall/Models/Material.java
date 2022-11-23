package com.example.donalwall.Models;

public class Material {
    public Material nextMaterial;
    public String type;
    public String description;
    public int quality;
    public int amount;

    public Material(JewelleryItem ji, String type, String description, int quality, int amount) {
        this.type = type;
        this.description = description;
        this.quality = quality;
        this.amount = amount;

        this.nextMaterial=ji.firstMaterial;
        ji.firstMaterial=this;
    }

    public Material getNextMaterial() {
        return nextMaterial;
    }

    public void setNextMaterial(Material nextMaterial) {
        this.nextMaterial = nextMaterial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Material " +
                " type = " + type +
                " description = " + description +
                " quality = " + quality +
                " amount = " + amount +
                ' ';
    }
}

