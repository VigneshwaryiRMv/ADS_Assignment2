package com.project.tree.model;

public class SpeciesNodeAVL {
    public Species species;
    public SpeciesNodeAVL left;
    public SpeciesNodeAVL right;
    public int height;

    public SpeciesNodeAVL(Species species, String habitatName) {
        this.species = species;
        left = null;
        right = null;
        height = 1;
    }
}
