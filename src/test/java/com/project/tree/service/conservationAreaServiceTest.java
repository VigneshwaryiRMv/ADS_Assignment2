package com.project.tree.service;

import com.project.tree.model.conservationArea;
import com.project.tree.service.conservationAreaService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class conservationAreaServiceTest {

    @Test
    public void testInsertAndSearch() {
        conservationAreaService areaService = new conservationAreaService();

        // Insert conservation areas
        areaService.insertArea("Forest Reserve", "Tropical Forest", "Wetland");
        areaService.insertArea("National Park", "Mountainous Region", "Grassland");
        areaService.insertArea("Wildlife Sanctuary", "Savanna", "Desert");

        // Search for existing conservation areas
        conservationArea foundForestReserve = areaService.search("Forest Reserve");
        conservationArea foundNationalPark = areaService.search("National Park");
        conservationArea foundWildlifeSanctuary = areaService.search("Wildlife Sanctuary");

        // Search for non-existing conservation areas
        conservationArea notFoundArea = areaService.search("Nature Reserve");

        // Assertions
        assertEquals("Forest Reserve", foundForestReserve.getName());
        assertEquals("National Park", foundNationalPark.getName());
        assertEquals("Wildlife Sanctuary", foundWildlifeSanctuary.getName());
        assertNull(notFoundArea);
    }

    @Test
    public void testPrintInOrder() {
        conservationAreaService areaService = new conservationAreaService();

        // Insert conservation areas
        areaService.insertArea("Forest Reserve", "Tropical Forest", "Wetland");
        areaService.insertArea("National Park", "Mountainous Region", "Grassland");
        areaService.insertArea("Wildlife Sanctuary", "Savanna", "Desert");

        // Print in order
        areaService.printInOrder(); // Output should be alphabetical order of area names
    }

    @Test
    public void testGetAllConservationAreas() {
        conservationAreaService areaService = new conservationAreaService();

        // Insert conservation areas
        areaService.insertArea("Forest Reserve", "Tropical Forest", "Wetland");
        areaService.insertArea("National Park", "Mountainous Region", "Grassland");
        areaService.insertArea("Wildlife Sanctuary", "Savanna", "Desert");

        // Get all conservation areas
        List<conservationArea> allAreas = areaService.getAllConservationAreas();

        // Assertions
        assertEquals(3, allAreas.size()); // Should contain all inserted areas
        assertEquals("Forest Reserve", allAreas.get(0).getName()); // First area should be Forest Reserve
        assertEquals("National Park", allAreas.get(1).getName()); // Second area should be National Park
        assertEquals("Wildlife Sanctuary", allAreas.get(2).getName()); // Third area should be Wildlife Sanctuary
    }
}
