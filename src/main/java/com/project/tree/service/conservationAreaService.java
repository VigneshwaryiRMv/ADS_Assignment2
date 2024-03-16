package com.project.tree.service;

import com.project.tree.model.conservationArea;
import com.project.tree.model.conservationAreaNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//BST
public class conservationAreaService {
    conservationAreaNode root;


    public conservationAreaService() {
        root = null;
    }

    public void insertArea(String areaName, String... habitatNames) {
        // Iterative insertion
        if (null == root) {
            root = new conservationAreaNode(new conservationArea(areaName));
            conservationArea area = root.area;
            for (String habitatName : habitatNames) {
                area.addHabitat(habitatName);
            }
            return;
        }
        conservationAreaNode currentNode = root;
        while (true) {
            if (areaName.compareTo(currentNode.area.name) < 0) {
                if (currentNode.left == null) {
                    currentNode.left = new conservationAreaNode(new conservationArea(areaName));
                    conservationArea area = currentNode.left.area;
                    for (String habitatName : habitatNames) {
                        area.addHabitat(habitatName);
                    }
                    return;
                }
                currentNode = currentNode.left;
            } else if (areaName.compareTo(currentNode.area.name) > 0) {
                if (currentNode.right == null) {
                    currentNode.right = new conservationAreaNode(new conservationArea(areaName));
                    conservationArea area = currentNode.right.area;
                    for (String habitatName : habitatNames) {
                        area.addHabitat(habitatName);
                    }
                    return;
                }
                currentNode = currentNode.right;
            } else {
                System.out.println("No area recorded");
                return;
            }
        }
    }


    /** traditional method
    public conservationAreaNode  insertConservationArea(conservationAreaNode node, String areaName) {
        if (node == null) {
            return new conservationAreaNode(new conservationArea(areaName));
        }

        if (areaName.compareTo(node.area.areaName) < 0) {
            node.left = insertConservationArea(node.left, areaName);
        } else if (areaName.compareTo(node.area.areaName) > 0) {
            node.right = insertConservationArea(node.right, areaName);
        }

        return node;
    }
     **/


    public conservationArea search(String areaName) {
        //return searchConservationArea(root, areaName);

        // improvised search
        conservationAreaNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.area.name.equals(areaName)) {
                return currentNode.area;
            } else if (areaName.compareTo(currentNode.area.name) < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    /** traditional method
    private conservationArea searchConservationArea(conservationAreaNode node, String name) {
        if (node == null || node.area.name.equals(name)) {
            return (node != null) ? node.area : null;
        }

        if (name.compareTo(node.area.name) < 0) {
            return searchConservationArea(node.left, name);
        } else {
            return searchConservationArea(node.right, name);
        }
    }
     **/

    public void printInOrder() {

        if (root == null) {
            return;
        }

        Stack<conservationAreaNode> stack = new Stack<>();
        conservationAreaNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            System.out.println(currentNode.area.name);

            currentNode = currentNode.right;
        }
    }

    public List<conservationArea> getAllConservationAreas() {
        List<conservationArea> allAreas = new ArrayList<>();
        Stack<conservationAreaNode> stack = new Stack<>();
        conservationAreaNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            allAreas.add(currentNode.area);

            currentNode = currentNode.right;
        }

        return allAreas;
    }

    /**
    private void printInOrder(conservationAreaNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.area.name);
            printInOrder(node.right);
        }
    }
     **/

}
