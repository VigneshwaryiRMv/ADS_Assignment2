package com.project.tree.model.body;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConservationAreaRequestTest {

    @Test
    void testSetName() {
        ConservationAreaDTO request = new ConservationAreaDTO();
        request.setName("TestName");
        assertEquals("TestName", request.getName());
    }

    @Test
    void testSetHabitats() {
        ConservationAreaDTO request = new ConservationAreaDTO();
        String[] habitats = {"Forest", "Lake", "Mountain"};
        request.setHabitats(habitats);
        assertArrayEquals(habitats, request.getHabitats());
    }
}
