package com.project.tree.model.body;

import com.project.tree.model.Species;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpeciesRequestTest {
	
	 @Test
	    void testGetSpecies() {
	        SpeciesDTO request = new SpeciesDTO();
	        Species species = new Species("Tiger");
	        request.setSpecies(species);
	        assertEquals(species, request.getSpecies());
	    }

	 @Test
	 	void testGetHabitatName() {
	        SpeciesDTO request = new SpeciesDTO();
	        String habitatName = "Forest";
	        request.setHabitatName(habitatName);
	        assertEquals(habitatName, request.getHabitatName());
	    }

    @Test
    void testSetSpecies() {
        SpeciesDTO request = new SpeciesDTO();
        Species species = new Species("Tiger");
        request.setSpecies(species);
        assertEquals(species, request.getSpecies());
    }

    @Test
    void testSetHabitatName() {
        SpeciesDTO request = new SpeciesDTO();
        String habitatName = "Forest";
        request.setHabitatName(habitatName);
        assertEquals(habitatName, request.getHabitatName());
    }
}
