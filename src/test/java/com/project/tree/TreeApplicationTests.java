package com.project.tree;

import com.project.tree.model.Species;
import com.project.tree.service.conservationSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TreeApplicationTests {

    private conservationSystem conservationSystem;

    @BeforeEach
    public void setUp() {
        conservationSystem = new conservationSystem();
    }

    @Test
    public void testAddConservationArea() {
        conservationSystem.addConservationArea("Forest Reserve", "Tropical Forest", "Wetland");
        conservationSystem.addConservationArea("National Park", "Grassland", "Savanna");

        assertTrue(conservationSystem.searchConservationArea("Forest Reserve") != null);
        assertTrue(conservationSystem.searchConservationArea("National Park") != null);
    }

    @Test
    public void testAddSpecies() {
        conservationSystem.addConservationArea("Forest Reserve", "Tropical Forest", "Wetland");

        Species tiger = new Species("Tiger", 500);
        conservationSystem.addSpecies(tiger, "Tropical Forest");

        Species elephant = new Species("Elephant", 1200);
        conservationSystem.addSpecies(elephant, "Tropical Forest");

        List<Species> speciesList = conservationSystem.getSpeciesInOrder();
        assertTrue(speciesList.contains(tiger));
        assertTrue(speciesList.contains(elephant));
    }

    @Test
    public void testMakeConservationDecision() {
        conservationSystem.addConservationArea("Forest Reserve", "Tropical Forest", "Wetland");

        Species tiger = new Species("Tiger", 500);
        conservationSystem.addSpecies(tiger, "Tropical Forest");
        
        String expectedDecision = "Implement conservation measures for Tiger";
        String actualDecision = conservationSystem.makeConservationDecision(tiger);

        assertEquals(expectedDecision, actualDecision);
    }
}
