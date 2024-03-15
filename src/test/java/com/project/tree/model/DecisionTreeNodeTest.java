package com.project.tree.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionTreeNodeTest {

    @Test
    void testConstructor() {
        String question = "Is it a mammal?";
        DecisionTreeNode node = new DecisionTreeNode(question);

        assertEquals(question, node.question);
        assertNull(node.yesChild);
        assertNull(node.noChild);
    }
}
