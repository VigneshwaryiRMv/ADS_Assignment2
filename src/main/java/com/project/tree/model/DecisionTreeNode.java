package com.project.tree.model;

public class DecisionTreeNode {
    public String question;
    public DecisionTreeNode yesChild;
    public DecisionTreeNode noChild;

    public DecisionTreeNode(String question) {
        this.question = question;
        yesChild = null;
        noChild = null;
    }
}
