package com.example.donalwall.Models;

import com.example.donalwall.Controllers.Controller;
import com.example.donalwall.Controllers.DisplayTrayController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTrayTest {
    public DisplayTray dtIsValid, dtInvalidData;

    @BeforeEach
    void setUp() {
        DisplayCase dc = new DisplayCase(null,"23",false,true);
        dtIsValid = new DisplayTray(dc,"23","Green","23","44");
        dtInvalidData = new DisplayTray(dc,null,null,null,null);
    }

    @AfterEach
    void tearDown() {
        dtInvalidData = dtIsValid = null;
    }

    @Test
    void getUID() {
        assertEquals("23",dtIsValid.getUID());
        assertEquals(null,dtInvalidData.getUID());
    }

    @Test
    void setUID() {
        dtIsValid.setUID("23");
        assertEquals("23",dtIsValid.getUID());
    }

    @Test
    void getMaterialColour() {
        assertEquals("Green",dtIsValid.getMaterialColour());
        assertEquals(null,dtInvalidData.getMaterialColour());
    }

    @Test
    void setMaterialColour() {
        dtIsValid.setMaterialColour("Green");
        assertEquals("Green",dtIsValid.getMaterialColour());
    }

    @Test
    void getWidth() {
        assertEquals("23",dtIsValid.getWidth());
        assertEquals(null,dtInvalidData.getWidth());
    }

    @Test
    void setWidth() {
        dtIsValid.setWidth("23");
        assertEquals("23",dtIsValid.getWidth());
    }

    @Test
    void getDepth() {
        assertEquals("44",dtIsValid.getDepth());
        assertEquals(null,dtInvalidData.getDepth());
    }

    @Test
    void setDepth() {
        dtIsValid.setDepth("44");
        assertEquals("44",dtIsValid.getDepth());
    }
}