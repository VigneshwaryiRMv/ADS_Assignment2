package com.project.tree.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpeciesAVLNodeTest {

    @Test
    void testConstructor() {
        Species species = new Species("Tiger");
        SpeciesNodeAVL node = new SpeciesNodeAVL(species, "Forest");

        assertEquals(species, node.species);
        assertNull(node.left);
        assertNull(node.right);
        assertEquals(1, node.height);
    }
}
