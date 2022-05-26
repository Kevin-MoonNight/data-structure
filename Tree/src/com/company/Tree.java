package com.company;

public class Tree {
    private String value;
    private Tree parent;
    private Tree[] child = new Tree[10];
    private int nodeCounter;

    public Tree(String value, Tree parent) {
        nodeCounter = 0;
        setValue(value);
        setParent(parent);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public void setChild(Tree child) {
        if (child != null) {
            this.child[nodeCounter] = child;
            nodeCounter++;
        }
    }
    public int getSize(){
        return nodeCounter;
    }
}
