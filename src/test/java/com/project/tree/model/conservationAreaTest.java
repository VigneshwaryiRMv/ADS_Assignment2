package com.project.tree.model;

import com.project.tree.model.Habitat;
import com.project.tree.model.Species;
import com.project.tree.model.conservationArea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class conservationAreaTest {

    private conservationArea area;

    @BeforeEach
    void setUp() {
        area = new conservationArea("TestArea");
    }

    @Test
    void testAddHabitat() {
        area.addHabitat("Forest");
        area.addHabitat("Lake");
        List<Habitat> habitats = area.getHabitats();
        assertEquals(2, habitats.size());
        assertEquals("Forest", habitats.get(0).getName());
        assertEquals("Lake", habitats.get(1).getName());
    }

    @Test
    void testAddSpeciesToHabitat() {
        Species species1 = new Species("Tiger");
        Species species2 = new Species("Elephant");

        area.addHabitat("Forest");
        area.addSpeciesToHabitat("Forest", species1);
        area.addSpeciesToHabitat("Forest", species2);

        Map<String, List<Species>> speciesInHabitats = area.getSpeciesInHabitats();
        assertTrue(speciesInHabitats.containsKey("Forest"));
        List<Species> forestSpecies = speciesInHabitats.get("Forest");
        assertEquals(2, forestSpecies.size());
        assertTrue(forestSpecies.contains(species1));
        assertTrue(forestSpecies.contains(species2));
    }

    @Test
    void testAddHabitatDuplicate() {
        area.addHabitat("Forest");
        area.addHabitat("Forest"); // Adding duplicate habitat
        List<Habitat> habitats = area.getHabitats();
        assertEquals(2, habitats.size()); // Expecting two habitats after adding duplicate
        assertEquals("Forest", habitats.get(0).getName());
        assertEquals("Forest", habitats.get(1).getName());
    }


    @Test
    void testAddSpeciesToNonexistentHabitat() {
        Species species = new Species("Lion");
        area.addSpeciesToHabitat("Savanna", species);
        Map<String, List<Species>> speciesInHabitats = area.getSpeciesInHabitats();
        assertTrue(speciesInHabitats.containsKey("Savanna")); // Expecting species added to non-existent habitat
    }

    @Test
    void testAddSpeciesToMultipleHabitats() {
        Species species = new Species("Leopard");
        area.addHabitat("Forest");
        area.addHabitat("Savanna");
        area.addSpeciesToHabitat("Forest", species);
        area.addSpeciesToHabitat("Savanna", species);
        Map<String, List<Species>> speciesInHabitats = area.getSpeciesInHabitats();
        assertTrue(speciesInHabitats.containsKey("Forest"));
        assertTrue(speciesInHabitats.containsKey("Savanna"));
        List<Species> forestSpecies = speciesInHabitats.get("Forest");
        List<Species> savannaSpecies = speciesInHabitats.get("Savanna");
        assertEquals(1, forestSpecies.size());
        assertEquals(1, savannaSpecies.size());
        assertTrue(forestSpecies.contains(species));
        assertTrue(savannaSpecies.contains(species));
    }

    @Test
    void testGetSpeciesInHabitatsEmpty() {
        Map<String, List<Species>> speciesInHabitats = area.getSpeciesInHabitats();
        assertTrue(speciesInHabitats.isEmpty());
    }

    @Test
    void testGetHabitatsEmpty() {
        List<Habitat> habitats = area.getHabitats();
        assertTrue(habitats.isEmpty());
    }

    @Test
    void testSetName() {
        area.setName("NewTestArea");
        assertEquals("NewTestArea", area.getName());
    }

}
