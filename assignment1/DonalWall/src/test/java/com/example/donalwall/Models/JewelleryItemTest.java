package com.example.donalwall.Models;

import com.example.donalwall.Controllers.DisplayTrayController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JewelleryItemTest {

    private JewelleryItem jiIsValid,jiInvalidData;

    @BeforeEach
    void setUp() {
        DisplayCase dc = new DisplayCase(null,"22",false,true);
        DisplayTray dt = new DisplayTray(dc,"23","Green","11","14");
       jiIsValid = new JewelleryItem(dt,"Cool","Epic","Male","www.god.com",23);
       jiInvalidData = new JewelleryItem(dt,null,null,null,null,0);
    }

    @AfterEach
    void tearDown() {
        jiIsValid = jiInvalidData = null;
    }

    @Test
    void getItemDescription() {
        assertEquals("Cool",jiIsValid.getItemDescription());
        assertEquals(null,jiInvalidData.getItemDescription());
    }

    @Test
    void setItemDescription() {
        jiIsValid.setItemDescription("Cool");
        assertEquals("Cool",jiIsValid.getItemDescription());
    }

    @Test
    void getType() {
        assertEquals("Epic",jiIsValid.getType());
        assertEquals(null,jiInvalidData.getType());
    }

    @Test
    void setType() {
        jiIsValid.setType("Epic");
        assertEquals("Epic",jiIsValid.getType());
    }

    @Test
    void getGender() {
        assertEquals("Male",jiIsValid.getGender());
        assertEquals(null,jiInvalidData.getGender());
    }

    @Test
    void setGender() {
        jiIsValid.setGender("Male");
        assertEquals("Male",jiIsValid.getGender());
    }

    @Test
    void getURL() {
        assertEquals("www.god.com",jiIsValid.getURL());
        assertEquals(null,jiInvalidData.getURL());
    }

    @Test
    void setURL() {
        jiIsValid.setURL("www.god.com");
        assertEquals("www.god.com",jiIsValid.getURL());
    }

    @Test
    void setRetailPrice() {
        jiIsValid.setRetailPrice(23);
        assertEquals(23,jiIsValid.getRetailPrice());
    }

    @Test
    void getRetailPrice() {
        assertEquals(23,jiIsValid.getRetailPrice());
        assertEquals(0,jiInvalidData.getRetailPrice());
    }
}