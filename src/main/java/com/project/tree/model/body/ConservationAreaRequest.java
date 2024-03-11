package com.project.tree.model.body;

public class ConservationAreaRequest {
    private String name;
    private String[] habitats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getHabitats() {
        return habitats;
    }

    public void setHabitats(String[] habitats) {
        this.habitats = habitats;
    }
}
