package com.project.tree.service;

import com.project.tree.model.Species;
import com.project.tree.model.SpeciesAVLNode;

import java.util.ArrayList;
import java.util.List;

public class SpeciesAVLTree {
    SpeciesAVLNode root;

    public String habitatName;

    public SpeciesAVLTree() {
        root = null;
    }

    private int height(SpeciesAVLNode node) {
        return (node != null) ? node.height : 0;
    }

    private int getBalance(SpeciesAVLNode node) {
        return (node != null) ? height(node.left) - height(node.right) : 0;
    }

    private SpeciesAVLNode rotateRight(SpeciesAVLNode y) {
        SpeciesAVLNode x = y.left;
        SpeciesAVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private SpeciesAVLNode rotateLeft(SpeciesAVLNode x) {
        SpeciesAVLNode y = x.right;
        SpeciesAVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public Species search(String name) {
        return searchSpecies(root, name);
    }

    private Species searchSpecies(SpeciesAVLNode node, String name) {
        if (node == null || node.species.name.equals(name)) {
            return (node != null) ? node.species : null;
        }

        /**if (name.compareTo(node.species.name) < 0) {
            return searchSpecies(node.left, name);
        } else {
            return searchSpecies(node.right, name);
        }**/

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

    private void inOrderTraversal(SpeciesAVLNode node, List<Species> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(node.species);
            inOrderTraversal(node.right, result);
        }
    }
}
