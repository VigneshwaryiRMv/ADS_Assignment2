package com.project.tree.controller;

import com.project.tree.controller.conservativeAreaController;
import com.project.tree.model.body.ConservationAreaRequest;
import com.project.tree.model.conservationArea;
import com.project.tree.model.Species;
import com.project.tree.model.body.SpeciesRequest;
import com.project.tree.service.conservationSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class conservativeAreaControllerTest {

    private conservativeAreaController controller;

    @Mock
    private conservationSystem conservationSystemService;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        controller = new conservativeAreaController();
        controller.conservationSystemService = conservationSystemService;
    }

    @Test
    void testAddConservationArea() {
        ConservationAreaRequest request = new ConservationAreaRequest();
        request.setName("Forest");
        request.setHabitats(new String[]{"Forest"});

        ResponseEntity<String> response = controller.addConservationArea(request);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Conservation Area added successfully", response.getBody());
    }

    @Test
    void testGetConservationArea() {
        conservationArea area = new conservationArea("Forest");
        when(conservationSystemService.searchConservationArea("Forest")).thenReturn(area);

        ResponseEntity<conservationArea> response = controller.getConservationArea("Forest");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Forest", response.getBody().getName());
    }

    @Test
    void testGetAllConservationAreas() {
        List<String> areas = new ArrayList<>();
        areas.add("Forest");
        when(conservationSystemService.printConservationAreasInOrder()).thenReturn(areas);

        ResponseEntity<List<String>> response = controller.getAllConservationAreas();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Forest", response.getBody().get(0));
    }

    @Test
    void testAddSpecies() {
        SpeciesRequest request = new SpeciesRequest();
        request.setSpecies(new Species("Tiger"));
        request.setHabitatName("Forest");

        ResponseEntity<String> response = controller.addSpecies(request);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Species added successfully", response.getBody());
    }

    @Test
    void testGetSpecies() {
        Species expectedSpecies = new Species("Tiger");
        when(conservationSystemService.searchSpecies("Tiger")).thenReturn(expectedSpecies);

        Species returnedSpecies = controller.getSpecies("Tiger");
        assertEquals(expectedSpecies, returnedSpecies);
    }

    @Test
    void testGetAllSpecies() {
        List<Species> expectedSpeciesList = new ArrayList<>();
        expectedSpeciesList.add(new Species("Tiger"));
        expectedSpeciesList.add(new Species("Elephant"));
        when(conservationSystemService.getSpeciesInOrder()).thenReturn(expectedSpeciesList);

        List<Species> returnedSpeciesList = controller.getAllSpecies();
        assertEquals(expectedSpeciesList.size(), returnedSpeciesList.size());
        assertEquals(expectedSpeciesList.get(0).getName(), returnedSpeciesList.get(0).getName());
        assertEquals(expectedSpeciesList.get(1).getName(), returnedSpeciesList.get(1).getName());
    }

    @Test
    void testMakeConservationDecision() {
        SpeciesRequest request = new SpeciesRequest();
        Species species = new Species("Tiger");
        request.setSpecies(species);

        when(conservationSystemService.searchSpecies("Tiger")).thenReturn(species);
        when(conservationSystemService.makeConservationDecision(species)).thenReturn("Conservation Decision");

        String decision = controller.makeConservationDecision(request);
        assertEquals("Conservation Decision", decision);
    }
}
