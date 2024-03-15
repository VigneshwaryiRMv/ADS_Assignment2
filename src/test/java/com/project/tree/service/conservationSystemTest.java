package com.project.tree.service;

import com.project.tree.model.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class conservationSystemTest {

    private conservationSystem conservationSystem;

    @BeforeEach
    public void setUp() {
        conservationSystem = new conservationSystem();
    }

    @Test
    public void testAddConservationArea() {
        conservationSystem.addConservationArea("Forest Reserve", "Tropical Forest", "Wetland");
        assertNotNull(conservationSystem.searchConservationArea("Forest Reserve"));
    }

    @Test
    public void testAddSpecies() {
        Species tiger = new Species("Tiger", 500);
        conservationSystem.addSpecies(tiger, "Tropical Forest");
        assertNotNull(conservationSystem.searchSpecies("Tiger"));
    }

    @Test
    public void testSearchConservationArea() {
        conservationSystem.addConservationArea("Forest Reserve", "Tropical Forest", "Wetland");
        assertNotNull(conservationSystem.searchConservationArea("Forest Reserve"));
    }

    @Test
    public void testSearchSpecies() {
        Species tiger = new Species("Tiger", 500);
        conservationSystem.addSpecies(tiger, "Tropical Forest");
        assertNotNull(conservationSystem.searchSpecies("Tiger"));
    }

    @Test
    public void testMakeConservationDecisionEndangered() {
        Species endangeredSpecies = new Species("EndangeredSpecies", 500);
        String decision = conservationSystem.makeConservationDecision(endangeredSpecies);
        assertEquals("Monitor the species population.", decision);
    }

    @Test
    public void testMakeConservationDecisionNonEndangered() {
        Species nonEndangeredSpecies = new Species("NonEndangeredSpecies", 1500);
        String decision = conservationSystem.makeConservationDecision(nonEndangeredSpecies);
        assertEquals("No decision", decision);
    }
}
