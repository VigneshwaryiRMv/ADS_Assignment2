package com.project.tree.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class conservationAreaNodeTest {

    @Test
    void testConstructor() {
        conservationArea area = new conservationArea("TestArea");
        conservationAreaNode node = new conservationAreaNode(area);

        assertEquals(area, node.area);
        assertNull(node.left);
        assertNull(node.right);
        assertEquals(1, node.height);
    }
}
