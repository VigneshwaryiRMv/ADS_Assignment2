package com.project.tree.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpeciesTest {

    @Test
    void testConstructorWithNameAndPopulation() {
        String name = "Tiger";
        int population = 1000;
        Species species = new Species(name, population);

        assertEquals(name, species.getName());
        assertEquals(population, species.getPopulation());
    }

    @Test
    void testConstructorWithName() {
        String name = "Elephant";
        Species species = new Species(name);

        assertEquals(name, species.getName());
        assertEquals(0, species.getPopulation()); // Default population value
    }

    @Test
    void testSettersAndGetters() {
        String name = "Lion";
        int population = 1500;
        Species species = new Species();

        species.setName(name);
        species.setPopulation(population);

        assertEquals(name, species.getName());
        assertEquals(population, species.getPopulation());
    }
}
