package com.example.donalwall.Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayCaseTest {
    public DisplayCase dcIsValid, dcInvalidData;


    @BeforeEach
    void setUp() {
        dcIsValid = new DisplayCase(null,"22",false,true);
        dcInvalidData = new DisplayCase(null,null,false,false);
    }


    @AfterEach
    void tearDown() {
        dcIsValid = dcInvalidData = null;
    }

    @Test
    void getUID() {
        assertEquals("22",dcIsValid.getUID());
        assertEquals(null,dcInvalidData.getUID());
    }

    @Test
    void setUID() {
        dcIsValid.setUID("22");
        assertEquals("22",dcIsValid.getUID());
    }

    @Test
    void isLit() {
        assertEquals(false,dcIsValid.isLit);
        assertEquals(false,dcInvalidData.isLit);
    }

    @Test
    void setLit() {
        dcIsValid.setLit(false);
        assertEquals(false, dcIsValid.isLit()); //update
    }

    @Test
    void isWallMounted() {

        assertEquals(true,dcIsValid.isWallMounted);
        assertEquals(false,dcInvalidData.isWallMounted);
    }

    @Test
    void setWallMounted() {
        dcIsValid.setWallMounted(false);
        assertEquals(false,dcIsValid.isWallMounted);
    }

    @Test
    void toStringReturnsCorrectString() {
        DisplayCase dc = new DisplayCase(null,"23",false,true);
        String stringContents = dc.toString();

        assertTrue(stringContents.contains(" DisplayCaseUID( " + dc.getUID()));
        assertTrue(stringContents.contains(" ) Lit : " + dc.isLit()));
        assertTrue(stringContents.contains(" Wall Mounted : " + dc.isWallMounted() + " "));
    }
}