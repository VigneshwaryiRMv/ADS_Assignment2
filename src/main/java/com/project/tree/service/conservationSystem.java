package com.project.tree.service;

import com.project.tree.model.conservationArea;
import com.project.tree.model.DecisionTreeNode;
import com.project.tree.model.Habitat;
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
    public TreeMap<String, conservationArea> conservationAreas;
    TreeSet<Species> speciesSet;
    DecisionTreeNode decisionTreeRoot;**/

    public conservationSystem() {
        conservationAreaTree = new conservationAreaService();
        speciesTree = new SpeciesAVLTree();
        decisionTreeRoot = buildDecisionTree();
    }

//    public conservationSystem() {
//        conservationAreas = new TreeMap<>();
//        speciesSet = new TreeSet<>(Comparator.comparing(Species::getName));
//        decisionTreeRoot = buildDecisionTree();
//    }

    /**public conservationSystem() {
        conservationAreas = new TreeMap<>();
        speciesSet = new TreeSet<>(Comparator.comparing(Species::getName));
        decisionTreeRoot = buildDecisionTree();
    }**/

    private DecisionTreeNode buildDecisionTree() {
        DecisionTreeNode root = new DecisionTreeNode("Is the species endangered?");
        DecisionTreeNode endangeredNode = new DecisionTreeNode("Focus on conservation efforts for endangered species.");
        DecisionTreeNode notEndangeredNode = new DecisionTreeNode("Monitor the species population.");

        root.yesChild = endangeredNode;
        root.noChild = notEndangeredNode;

        return root;
    }

    public void addConservationArea(String name ,String...  habitats) {
        conservationAreaTree.insertArea(name,habitats);
        /**conservationAreas.put(name, new conservationArea(name));
        conservationArea area = new conservationArea(name);
        for (String habitat : habitats) {
            area.addHabitat(habitat);
        }
        conservationAreas.put(name, area);**/
    }

    public void addSpecies(Species species, String habitatName) {
        /**speciesSet.add(species);
        conservationArea area = findConservationAreaForHabitat(habitatName);
        if (area != null) {
            area.addSpeciesToHabitat(habitatName, species);
        }**/
        speciesTree.insert(species,habitatName);
    }

    public conservationArea findConservationAreaForSpecies(Species species) {
        for (conservationArea area : conservationAreaTree.getAllConservationAreas()) {
            Map<String, List<Species>> speciesInHabitats = area.getSpeciesInHabitats();
            for (List<Species> speciesList : speciesInHabitats.values()) {
                if (speciesList.contains(species)) {
                    return area;
                }
            }
        }
        return null; // Conservation area not found for the species
    }


    public conservationArea searchConservationArea(String name) {
        return conservationAreaTree.search(name);
        //return conservationAreas.get(name);
    }


    public Species searchSpecies(String name) {
        return speciesTree.search(name);
//        for (Species species : speciesSet) {
//            if (species.getName().equals(name)) {
//                return species;
//            }
//        }
//        return null;
    }

    public List<Species> getSpeciesInOrder() {
        return speciesTree.inOrderTraversal();
        //return new ArrayList<>(speciesSet);
    }

    public String makeConservationDecision(Species species) {
        return traverseDecisionTree(decisionTreeRoot, species);
    }

    private String traverseDecisionTree(DecisionTreeNode node, Species species) {
        if (node == null) {
            return "No decision";
        }

        if(node.question.equals("Is the species endangered?")) {
            if (species.population < 1000) {
                return traverseDecisionTree(node.yesChild, species);
            } else {
                return traverseDecisionTree(node.noChild, species);
            }
        } else if (node.question.equals("Focus on conservation efforts for endangered species.")) {
            return "Implement conservation measures for " + species.name;
        } else if (node.question.equals("Monitor the species population")) {
            return "Continue monitoring "+ species.name + " population";
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
