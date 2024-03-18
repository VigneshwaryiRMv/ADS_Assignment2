package com.project.tree.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class conservationArea {
    public String name;
    List<Habitat> habitats;
    Map<String, List<Species>> speciesInHabitats;

    public conservationArea(String name) {
        this.name = name;
        habitats = new ArrayList<>();
        speciesInHabitats = new HashMap<>();
    }

    public void addHabitat(String habitatName) {
        habitats.add(new Habitat(habitatName));
    }

    public List<Habitat> getHabitats() {
        return habitats;
    }

    public void addSpeciesToHabitat(String habitatName, Species species) {
        speciesInHabitats.computeIfAbsent(habitatName, k -> new ArrayList<>()).add(species);
    }

    public Map<String, List<Species>> getSpeciesInHabitats() {
        return speciesInHabitats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
