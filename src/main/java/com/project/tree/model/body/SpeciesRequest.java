package com.project.tree.model.body;

import com.project.tree.model.Species;

public class SpeciesRequest {
    private Species species;
    private String habitatName;

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getHabitatName() {
        return habitatName;
    }

    public void setHabitatName(String habitatName) {
        this.habitatName = habitatName;
    }
}
