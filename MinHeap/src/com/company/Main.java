package com.company;

public class Main {

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap();

        System.out.println(minHeap.isEmpty());

        for (int i = 1; i < 10; i++) {
            minHeap.insert(i, String.valueOf(i));
        }

        System.out.println(minHeap.size());
        System.out.println(minHeap.min());
        System.out.println(minHeap.isEmpty());

        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.min());
    }
}
