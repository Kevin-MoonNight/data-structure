package com.company;

public class Main {

    public static void main(String[] args) {
        Tree[] node = new Tree[10];
        for (int i = 0; i < node.length; i++) {
            node[i] = new Tree("節點" + i, null);
        }
        for (int i = 1; i < node.length; i++) {
            node[0].setChild(node[i]);
        }

        System.out.println(node[0].getSize());

    }
}
