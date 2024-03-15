package com.project.tree.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HabitatTest {

    @Test
    void testConstructor() {
        String name = "Forest";
        Habitat habitat = new Habitat(name);

        assertEquals(name, habitat.getName());
    }
}
