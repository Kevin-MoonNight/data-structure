package com.company;

public class BinarySearchTree {
    private Node root;

    public void put(int value) {
        putNode(value, root, null);
    }

    private void putNode(int value, Node tempNode, Node parentNode) {
        if (tempNode == null) {
            Node newNode = new Node(value);
            if (parentNode == null) {
                root = newNode;
            } else if (value > parentNode.getValue()) {
                newNode.setParent(parentNode);
                parentNode.setRight(newNode);
            } else {
                newNode.setParent(parentNode);
                parentNode.setLeft(newNode);
            }
        } else if (value < tempNode.getValue()) {
            putNode(value, tempNode.getLeft(), tempNode);
        } else {
            putNode(value, tempNode.getRight(), tempNode);
        }
    }

    public Integer get(int value) {
        Node result = searchNode(root, value);

        if (result == null) {
            return null;
        }

        return result.getValue();
    }

    private Node searchNode(Node tempNode, int value) {
        if (tempNode == null) {
            return null;
        } else if (tempNode.getValue() == value) {
            return tempNode;
        } else if (value < tempNode.getValue()) {
            return searchNode(tempNode.getLeft(), value);
        } else if (value > tempNode.getValue()) {
            return searchNode(tempNode.getRight(), value);
        }

        return null;
    }

    public Node searchMinNode(Node tempNode) {
        if (tempNode.getLeft() == null) {
            return tempNode;
        } else {
            return searchMinNode(tempNode.getLeft());
        }
    }

    public void replaceNode(Node oldNode, Node newNode) {
        Node parentNode = oldNode.getParent(), leftNode = oldNode.getLeft(), rightNode = oldNode.getRight();

        if (rightNode != null) {
            rightNode.setParent(newNode);
        }

        if (leftNode != null) {
            leftNode.setParent(newNode);
        }

        if (newNode != null) {
            newNode.setParent(parentNode);
        }

        if (parentNode != null) {
            if (oldNode.getValue() < parentNode.getValue()) {
                parentNode.setLeft(newNode);
            } else {
                parentNode.setRight(newNode);
            }
        } else {
            root = newNode;
        }
    }

    public Integer remove(int value) {
        Node node = searchNode(root, value);

        if (node == null) {
            return null;
        } else {
            //移除節點
            removeNode(node);
            return node.getValue();
        }
    }

    private void removeNode(Node node) {
        Node leftNode = node.getLeft(), rightNode = node.getRight();

        if (leftNode == null && rightNode == null) {
            replaceNode(node, null);
        } else if (leftNode != null && rightNode != null) {
            Node minNode = searchMinNode(rightNode);

            if (leftNode == minNode) {
                minNode.setLeft(null);
            } else {
                minNode.setLeft(leftNode);
            }

            if (rightNode == minNode) {
                minNode.setRight(null);
            } else {
                minNode.setRight(rightNode);
            }

            replaceNode(minNode, null);
            replaceNode(node, minNode);
        } else if (leftNode != null) {
            replaceNode(node, leftNode);
        } else if (rightNode != null) {
            replaceNode(node, rightNode);
        }
    }
}
