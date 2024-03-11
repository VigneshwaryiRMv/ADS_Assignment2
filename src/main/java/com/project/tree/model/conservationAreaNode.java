package com.project.tree.model;

public class conservationAreaNode {

    public conservationArea area;
    public conservationAreaNode left;
    public conservationAreaNode right;
    int height;

    public conservationAreaNode(conservationArea area) {
        this.area = area;
        left=null;
        right=null;
        height=1;
    }
}
