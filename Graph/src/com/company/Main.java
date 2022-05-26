package com.company;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();


        graph.insertVertex("a");
        //1
        System.out.println(graph.numVertices());


        graph.removeVertex("a");
        //0
        System.out.println(graph.numVertices());


        graph.insertVertex("a");
        graph.insertVertex("b");
        graph.insertEdge("a", "b", "123");
        //1
        System.out.println(graph.numEdges());


        graph.removeEdge("123");
        //0
        System.out.println(graph.numEdges());


        graph.insertVertex("c");
        //a,b,c
        String[] result = graph.vertices();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.print("\n");


        graph.insertEdge("a", "b", "1");
        graph.insertEdge("b", "c", "2");
        graph.insertEdge("c", "a", "3");
        //1,2,3
        result = graph.edges();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.print("\n");


        //1
        System.out.println(graph.getEdge("a", "b"));


        //a,b
        result = graph.endVertices("1");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.print("\n");


        //b
        System.out.println(graph.opposite("a", "1"));
    }
}
