package com.company;

import java.util.Arrays;

public class MinHeap {
    private Node[] nodes;
    private int size;

    public MinHeap() {
        nodes = new Node[100];
        Arrays.fill(nodes, null);
        size = 0;
    }

    public void insert(int key, String value) {
        //插入節點
        nodes[size] = new Node(key, value);

        int temp = size, parent = (size - 1) / 2;

        while (nodes[temp].getKey() < nodes[parent].getKey()) {

            //交換
            Node tempValue = nodes[parent];
            nodes[parent] = nodes[temp];
            nodes[temp] = tempValue;

            temp = parent;

            parent = (parent - 1) / 2;
        }

        size++;
    }

    public String removeMin() {
        String result = nodes[0].getValue();

        nodes[0] = nodes[size - 1];
        nodes[size - 1] = null;

        size--;

        //換位置 遞迴
        shift(0);

        return result;
    }

    public void shift(int position) {
        int left = 2 * position + 1, right = 2 * position + 2;

        if (nodes[left] != null && (nodes[right] == null || nodes[left].getKey() <= nodes[right].getKey())) {
            Node tempValue = nodes[left];
            nodes[left] = nodes[position];
            nodes[position] = tempValue;
            shift(left);
        } else if (nodes[right] != null && (nodes[left] == null || nodes[left].getKey() > nodes[right].getKey())) {
            Node tempValue = nodes[right];
            nodes[right] = nodes[position];
            nodes[position] = tempValue;
            shift(right);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String min() {
        return nodes[0].getValue();
    }
}
