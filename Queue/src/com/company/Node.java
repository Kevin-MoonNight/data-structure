package com.company;

public class Node {
    private int value;

    private Node nextNode = null;

    public Node(int value) {
        this.value = value;
    }
    public int GetValue(){
        return value;
    }

    public void SetNextNode(int value) {
        nextNode = new Node(value);
    }
    public Node GetNextNode(){
        return nextNode;
    }
}
