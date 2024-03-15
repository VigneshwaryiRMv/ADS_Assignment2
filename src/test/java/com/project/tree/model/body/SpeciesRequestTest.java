package com.project.tree.model.body;

import com.project.tree.model.Species;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpeciesRequestTest {
	
	 @Test
	    void testGetSpecies() {
	        SpeciesRequest request = new SpeciesRequest();
	        Species species = new Species("Tiger");
	        request.setSpecies(species);
	        assertEquals(species, request.getSpecies());
	    }

	 @Test
	 	void testGetHabitatName() {
	        SpeciesRequest request = new SpeciesRequest();
	        String habitatName = "Forest";
	        request.setHabitatName(habitatName);
	        assertEquals(habitatName, request.getHabitatName());
	    }

    @Test
    void testSetSpecies() {
        SpeciesRequest request = new SpeciesRequest();
        Species species = new Species("Tiger");
        request.setSpecies(species);
        assertEquals(species, request.getSpecies());
    }

    @Test
    void testSetHabitatName() {
        SpeciesRequest request = new SpeciesRequest();
        String habitatName = "Forest";
        request.setHabitatName(habitatName);
        assertEquals(habitatName, request.getHabitatName());
    }
}
