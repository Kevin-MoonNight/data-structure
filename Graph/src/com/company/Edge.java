package com.company;

public class Edge extends GraphObject {
    private Vertex origin, destination;

    public Edge(String element) {
        super(element);
    }

    public Vertex getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }
}
