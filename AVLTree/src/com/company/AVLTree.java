package com.company;

public class AVLTree {
    private Node root;

    public int max(int num1, int num2) {
        if (num1 >= num2) {
            return num1;
        } else {
            return num2;
        }
    }

    private int height(Node tempNode) {
        if (tempNode == null) {
            return -1;
        } else {
            return max(height(tempNode.getLeft()), height(tempNode.getRight())) + 1;
        }
    }

    public int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        } else {
            return height(node.getLeft()) - height(node.getRight());
        }
    }

    public void rebalance(Node node) {
        int bf = balanceFactor(node);

        if (bf < -1) {
            if (node.getRight() != null && node.getRight().getRight() != null) {
                rrRotation(node);
            } else {
                rlRotation(node);
            }
        } else if (bf > 1) {
            if (node.getLeft() != null && node.getLeft().getLeft() != null) {
                llRotation(node);
            } else {
                lrRotation(node);
            }
        }
    }

    private void leftRotation(Node node) {
        Node newNode = node.getRight();

        node.setRight(newNode.getLeft());
        newNode.setLeft(node);

        if (node.getParent() == null) {
            root = newNode;
        } else {
            node.getParent().setLeft(newNode);
        }
        newNode.setParent(node.getParent());
        node.setParent(newNode);
    }

    private void rightRotation(Node node) {
        Node newNode = node.getLeft();

        node.setLeft(newNode.getRight());
        newNode.setRight(node);

        if (node.getParent() == null) {
            root = newNode;
        } else {
            node.getParent().setRight(newNode);
        }
        newNode.setParent(node.getParent());
        node.setParent(newNode);
    }

    public void llRotation(Node node) {
        rightRotation(node);
    }

    public void rrRotation(Node node) {
        leftRotation(node);
    }

    public void lrRotation(Node node) {
        leftRotation(node.getLeft());
        rightRotation(node);
    }

    public void rlRotation(Node node) {
        rightRotation(node.getRight());
        leftRotation(node);
    }

    public void put(int value) {
        putNode(value, root, null);
    }

    public void putNode(int value, Node tempNode, Node parentNode) {
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

            return;
        } else if (value < tempNode.getValue()) {
            putNode(value, tempNode.getLeft(), tempNode);
        } else {
            putNode(value, tempNode.getRight(), tempNode);
        }

        //重新平衡
        rebalance(tempNode);
    }

    public Integer get(int value) {
        Node result = searchNode(root, value);

        if (result == null) {
            return null;
        }

        return result.getValue();
    }

    public Node searchNode(Node tempNode, int value) {
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
        return searchAndRemoveNode(root, value);
    }

    private Integer searchAndRemoveNode(Node tempNode, int value) {
        Integer result = null;
        if (tempNode == null) {
            return result;
        } else if (tempNode.getValue() == value) {
            //移除節點
            removeNode(tempNode);
            result = tempNode.getValue();
        } else if (value < tempNode.getValue()) {
            result = searchAndRemoveNode(tempNode.getLeft(), value);
        } else if (value > tempNode.getValue()) {
            result = searchAndRemoveNode(tempNode.getRight(), value);
        }

        //重新平衡
        rebalance(tempNode);

        return result;
    }

    private void removeNode(Node node) {
        Node leftNode = node.getLeft(), rightNode = node.getRight();

        if (leftNode == null && rightNode == null) {
            replaceNode(node, null);
        } else if (leftNode != null && rightNode != null) {
            Node minNode = searchMinNode(node.getRight());
            minNode.setLeft(node.getLeft());
            minNode.setRight(node.getRight());
            replaceNode(minNode, null);
            replaceNode(node, minNode);
        } else if (leftNode != null) {
            replaceNode(node, leftNode);
        } else if (rightNode != null) {
            replaceNode(node, rightNode);
        }
    }
}
