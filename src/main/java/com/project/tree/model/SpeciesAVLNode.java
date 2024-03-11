package com.project.tree.model;

public class SpeciesAVLNode {
    public Species species;
    public SpeciesAVLNode left;
    public SpeciesAVLNode right;
    public int height;

    public SpeciesAVLNode(Species species, String habitatName) {
        this.species = species;
        left = null;
        right = null;
        height = 1;
    }
}
