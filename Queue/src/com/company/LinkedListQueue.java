package com.company;

public class LinkedListQueue implements IQueue {
    private Node node = null;

    public void Enqueue(int value) {
        if (IsEmpty()) {
            node = new Node(value);
        } else {
            Node tempNode = node;

            while (tempNode.GetNextNode() != null) {
                tempNode = tempNode.GetNextNode();
            }
            tempNode.SetNextNode(value);
        }
    }

    public int Dequeue() {
        if (IsEmpty()) {
            return 0;
        }

        int result = node.GetValue();

        node = node.GetNextNode();

        return result;
    }

    public int First() {
        if (IsEmpty()) {
            return 0;
        }

        return node.GetValue();
    }

    public int Size() {
        int result = 0;
        Node tempNode = node;

        while (tempNode != null) {
            result++;
            tempNode = tempNode.GetNextNode();
        }

        return result;
    }

    public boolean IsEmpty() {
        return node == null;
    }
}
