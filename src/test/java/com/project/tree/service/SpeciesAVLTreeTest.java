package com.project.tree.service;

import com.project.tree.model.Species;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SpeciesAVLTreeTest {

    @Test
    void testInsertAndSearch() {
        // Create a new instance of SpeciesTree
        SpeciesTree tree = new SpeciesTree();

        // Create sample species
        Species tiger = new Species();
        tiger.setName("Tiger");

        Species elephant = new Species();
        elephant.setName("Elephant");

        Species lion = new Species();
        lion.setName("Lion");

        // Insert species into the tree
        tree.insert(tiger, "Forest");
        tree.insert(elephant, "Savanna");

        // Search for inserted species
        assertEquals(tiger, tree.search("Tiger"));
        assertEquals(elephant, tree.search("Elephant"));

        // Search for non-existent species
        assertNull(tree.search("Lion"));
    }

    @Test
    void testInOrderTraversal() {
        // Create a new instance of SpeciesTree
        SpeciesTree tree = new SpeciesTree();

        // Create sample species
        Species tiger = new Species();
        tiger.setName("Tiger");

        Species elephant = new Species();
        elephant.setName("Elephant");

        Species lion = new Species();
        lion.setName("Lion");

        // Insert species into the tree
        tree.insert(tiger, "Forest");
        tree.insert(elephant, "Savanna");
        tree.insert(lion, "Grassland");

        // Perform in-order traversal
        List<Species> traversalResult = tree.inOrderTraversal();

        // Verify the order of traversal
        assertEquals(elephant, traversalResult.get(0));
        assertEquals(lion, traversalResult.get(1));
        assertEquals(tiger, traversalResult.get(2));
    }
}
