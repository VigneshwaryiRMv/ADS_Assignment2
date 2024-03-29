package com.project.tree.controller;

import com.project.tree.model.conservationArea;
import com.project.tree.model.body.ConservationAreaDTO;
import com.project.tree.model.Species;
import com.project.tree.model.body.SpeciesDTO;
import com.project.tree.service.conservationSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class conservativeAreaController {
    @Autowired
    conservationSystem conservationSystemService;

    @PostMapping("/area")
    public ResponseEntity<String> addConservationArea(@RequestBody ConservationAreaDTO conservationAreaRequest) {
        try {
            conservationSystemService.addConservationArea(conservationAreaRequest.getName(), conservationAreaRequest.getHabitats());
            return new ResponseEntity<>("Conservation Area added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to add conservation area");
        }
    }

    @PostMapping("/species")
    public ResponseEntity<String> addSpecies(@RequestBody SpeciesDTO speciesRequest) {
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

    @GetMapping("/species/{name}")
    public Species getSpecies(@PathVariable String name) {
        return conservationSystemService.searchSpecies(name);
    }

    @GetMapping("/species")
    public List<Species> getAllSpecies() {
        return conservationSystemService.getSpeciesInOrder();
    }

    @GetMapping("/decision")
    public String makeConservationDecision(@RequestBody SpeciesDTO speciesRequest) {
        Species species = conservationSystemService.searchSpecies(speciesRequest.getSpecies().getName());
        if (species == null) {
            return "Given Species are not found here !";
        }
        return conservationSystemService.makeConservationDecision(species);
    }

    @GetMapping("/areas")
    public ResponseEntity<List<String>> getAllConservationAreas() {
        return ResponseEntity.ok(conservationSystemService.printConservationAreasInOrder());
    }
}
