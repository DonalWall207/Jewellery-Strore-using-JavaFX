package com.example.donalwall.Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {

    private Material mtIsValid,mtInvalidData;

    @BeforeEach
    void setUp() {
        DisplayCase dc = new DisplayCase(null,"21",true,true);
        DisplayTray dt = new DisplayTray(dc,"22","Green","33","44");
        JewelleryItem ji = new JewelleryItem(dt,"cool","epic","Female","www.donal.com",12);
        mtIsValid = new Material(ji,"poor","great",3,4);
        mtInvalidData = new Material(ji,null,null,20,9);
    }

    @AfterEach
    void tearDown() {
        mtIsValid = mtInvalidData = null;
    }

    @Test
    void getType() {
        assertEquals("poor",mtIsValid.getType());
        assertEquals(null,mtInvalidData.getType());
    }

    @Test
    void setType() {
        mtIsValid.setType("poor");
        assertEquals("poor",mtIsValid.getType());
    }

    @Test
    void getDescription() {
        assertEquals("great",mtIsValid.getDescription());
        assertEquals(null,mtInvalidData.getDescription());
    }

    @Test
    void setDescription() {
        mtIsValid.setDescription("nice");
        assertEquals("nice",mtIsValid.getDescription());
    }

    @Test
    void getQuality() {
        assertEquals(3,mtIsValid.getQuality());
        assertEquals(20,mtInvalidData.getQuality());
    }

    @Test
    void setQuality() {
        mtIsValid.setQuality(3);
        assertEquals(3,mtIsValid.getQuality());
    }

    @Test
    void getAmount() {
        assertEquals(4,mtIsValid.getAmount());
        assertEquals(9,mtInvalidData.getAmount());
    }

    @Test
    void setAmount() {
        mtIsValid.setAmount(4);
        assertEquals(4,mtIsValid.getAmount());
    }
}