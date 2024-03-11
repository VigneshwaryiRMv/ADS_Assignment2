package com.project.tree.model;

public class Species {
    public String name;
    public int population;

    public Species(String name,int population) {
        this.name = name;
        this.population = population;
        // Initialize other attributes as needed
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
