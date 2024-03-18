package com.project.tree.service;

import com.project.tree.model.Species;
import com.project.tree.model.SpeciesNodeAVL;

import java.util.ArrayList;
import java.util.List;

// Follows AVL tree concept
public class SpeciesTree {
    public String habitatName;
    SpeciesNodeAVL root;

    public SpeciesTree() {
        root = null;
    }

    private int height(SpeciesNodeAVL node) {
        return (node != null) ? node.height : 0;
    }

    private int getBalance(SpeciesNodeAVL node) {
        return (node != null) ? height(node.left) - height(node.right) : 0;
    }

    private SpeciesNodeAVL rotateRight(SpeciesNodeAVL y) {
        SpeciesNodeAVL x = y.left;
        SpeciesNodeAVL T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private SpeciesNodeAVL rotateLeft(SpeciesNodeAVL x) {
        SpeciesNodeAVL y = x.right;
        SpeciesNodeAVL T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public Species search(String name) {
        return searchSpecies(root, name);
    }

    private Species searchSpecies(SpeciesNodeAVL node, String name) {
        if (node == null || node.species.name.equals(name)) {
            return (node != null) ? node.species : null;
        }

        /*if (name.compareTo(node.species.name) < 0) {
            return searchSpecies(node.left, name);
        } else {
            return searchSpecies(node.right, name);
        }*/

        // Optimisation
        int compareResult = name.compareTo(node.species.name);

        if (compareResult < 0) {
            return searchSpecies(node.left, name);
        } else {
            return searchSpecies(node.right, name);
        }
    }

    public List<Species> inOrderTraversal() {
        List<Species> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(SpeciesNodeAVL node, List<Species> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(node.species);
            inOrderTraversal(node.right, result);
        }
    }

    public void insert(Species species, String habitatName) {
        root = insertSpecies(root, species, habitatName);
    }

    private SpeciesNodeAVL insertSpecies(SpeciesNodeAVL node, Species species, String habitatName) {
        if (node == null) {
            return new SpeciesNodeAVL(species, habitatName);
        }

        // To Compare species names for insertion
        int compareResult = species.name.compareTo(node.species.name);

        if (compareResult < 0) {
            node.left = insertSpecies(node.left, species, habitatName);
        } else if (compareResult > 0) {
            node.right = insertSpecies(node.right, species, habitatName);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && species.name.compareTo(node.left.species.name) < 0) {
            return rotateRight(node);
        }
        if (balance < -1 && species.name.compareTo(node.right.species.name) > 0) {
            return rotateLeft(node);
        }
        if (balance > 1 && species.name.compareTo(node.left.species.name) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && species.name.compareTo(node.right.species.name) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }

}
