package com.project.tree.service;

import com.project.tree.model.conservationArea;
import com.project.tree.model.DecisionTreeNode;
import com.project.tree.model.Species;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

@Service
public class conservationSystem {
    conservationAreaService conservationAreaTree;
    SpeciesAVLTree speciesTree;
    DecisionTreeNode decisionTreeRoot;

    /**
     * public TreeMap<String, conservationArea> conservationAreas;
     * TreeSet<Species> speciesSet;
     * DecisionTreeNode decisionTreeRoot;
     **/

    public conservationSystem() {
        conservationAreaTree = new conservationAreaService();
        speciesTree = new SpeciesAVLTree();
        decisionTreeRoot = buildDecisionTree();
    }

    /**
     * public conservationSystem() {
     * conservationAreas = new TreeMap<>();
     * speciesSet = new TreeSet<>(Comparator.comparing(Species::getName));
     * decisionTreeRoot = buildDecisionTree();
     * }
     **/

    private DecisionTreeNode buildDecisionTree() {
        DecisionTreeNode root = new DecisionTreeNode("Is the species endangered?");
        DecisionTreeNode endangeredNode = new DecisionTreeNode("Focus on conservation efforts for endangered species.");
        DecisionTreeNode notEndangeredNode = new DecisionTreeNode("Monitor the species population.");

        root.yesChild = endangeredNode;
        root.noChild = notEndangeredNode;

        return root;
    }

    public void addConservationArea(String name, String... habitats) {
        conservationAreaTree.insertArea(name, habitats);
    }

    public void addSpecies(Species species, String habitatName) {
        speciesTree.insert(species, habitatName);
    }

    public conservationArea searchConservationArea(String name) {
        return conservationAreaTree.search(name);
    }


    public Species searchSpecies(String name) {
        return speciesTree.search(name);
    }

    public List<Species> getSpeciesInOrder() {
        return speciesTree.inOrderTraversal();
    }

    public String makeConservationDecision(Species species) {
        return traverseDecisionTree(decisionTreeRoot, species);
    }

    private String traverseDecisionTree(DecisionTreeNode node, Species species) {
        if (node == null) {
            return "No decision";
        }
        switch (node.question) {
            case "Is the species endangered?" -> {
                if (species.population < 1000) {
                    return traverseDecisionTree(node.yesChild, species);
                } else {
                    return traverseDecisionTree(node.noChild, species);
                }
            }
            case "Focus on conservation efforts for endangered species." -> {
                return "Implement conservation measures for " + species.name;
            }
            case "Monitor the species population." -> {
                return "Continue monitoring " + species.name + " population";
            }
        }
        return "No decision";
    }

    public List<String> printConservationAreasInOrder() {

        List<String> conservationAreasList = new ArrayList<>();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalStream = System.out;
        System.setOut(printStream);
        conservationAreaTree.printInOrder();
        System.setOut(originalStream);
        String[] lines = outputStream.toString().split("\\r?\\n");
        conservationAreasList.addAll(Arrays.asList(lines));
        return conservationAreasList;
    }

}
