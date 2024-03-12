package com.project.tree.controller;

import com.project.tree.model.conservationArea;
import com.project.tree.model.body.ConservationAreaRequest;
import com.project.tree.model.Species;
import com.project.tree.model.body.SpeciesRequest;
import com.project.tree.service.conservationSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class conservativeAreaController {
    @Autowired
    private conservationSystem conservationSystemService;

    @PostMapping("/area")
    public ResponseEntity<String> addConservationArea(@RequestBody ConservationAreaRequest conservationAreaRequest) {
        try {
            conservationSystemService.addConservationArea(conservationAreaRequest.getName(), conservationAreaRequest.getHabitats());
            return new ResponseEntity<>("Conservation Area added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to add conservation area");
        }
    }

    @PostMapping("/species")
    public ResponseEntity<String> addSpecies(@RequestBody SpeciesRequest speciesRequest) {
        try {
            conservationSystemService.addSpecies(speciesRequest.getSpecies(), speciesRequest.getHabitatName());
            return new ResponseEntity<>("Species added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to add Species");
        }
    }

    @GetMapping("/area/{name}")
    public ResponseEntity<conservationArea> getConservationArea(@PathVariable String name) {
       return ResponseEntity.ok(conservationSystemService.searchConservationArea(name));
    }

    @GetMapping("/areas")
    public ResponseEntity<List<String>> getAllConservationAreas() {
        return ResponseEntity.ok(conservationSystemService.printConservationAreasInOrder());
    }

    @GetMapping("/species/{name}")
    public Species getSpecies(@PathVariable String name) {
        return conservationSystemService.searchSpecies(name);
    }

    @GetMapping("/species")
    public List<Species> getAllSpecies() {
        return conservationSystemService.getSpeciesInOrder();
    }

    @GetMapping("/decision")
    public String makeConservationDecision(@RequestBody SpeciesRequest speciesRequest) {
        Species species = conservationSystemService.searchSpecies(speciesRequest.getSpecies().getName());
        if (species == null) {
            return "Given Species are not found here !";
        }
        return conservationSystemService.makeConservationDecision(species);
    }
}
