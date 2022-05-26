package com.company;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println(binarySearchTree.get(99));

        binarySearchTree.put(6);
        binarySearchTree.put(2);
        binarySearchTree.put(1);
        binarySearchTree.put(4);
        binarySearchTree.put(9);
        binarySearchTree.put(8);

        //左右為空
        System.out.println(binarySearchTree.remove(1));
        //左為空 右不為空
        binarySearchTree.put(5);
        System.out.println(binarySearchTree.remove(4));
        //左不為空 右為空
        System.out.println(binarySearchTree.remove(9));
        //左右都不為空
        System.out.println(binarySearchTree.remove(6));
    }
}

