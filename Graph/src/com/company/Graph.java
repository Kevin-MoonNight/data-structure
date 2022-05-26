package com.company;

public class Graph {
    private Vertex[] vertexSequence;
    private Edge[] edgeSequence;
    private int vertexCounter, edgeCounter;

    public Graph() {
        vertexSequence = new Vertex[100];
        edgeSequence = new Edge[100];
    }

    public int numVertices() {
        return vertexCounter;
    }

    public String[] vertices() {
        String[] result = new String[vertexCounter];

        for (int i = 0; i < vertexCounter; i++) {
            result[i] = vertexSequence[i].getElement();
        }

        return result;
    }

    public int numEdges() {
        return edgeCounter;
    }

    public String[] edges() {
        String[] result = new String[edgeCounter];

        for (int i = 0; i < edgeCounter; i++) {
            result[i] = edgeSequence[i].getElement();
        }

        return result;
    }

    public String getEdge(String u, String v) {
        for (int i = 0; i < edgeCounter; i++) {
            String origin = edgeSequence[i].getOrigin().getElement(), destination = edgeSequence[i].getDestination().getElement();

            if (origin.equals(u) && destination.equals(v)) {
                return edgeSequence[i].getElement();
            } else if (origin.equals(v) && destination.equals(u)) {
                //because is undirected so need to add this statement
                return edgeSequence[i].getElement();
            }
        }

        return null;
    }

    public String[] endVertices(String e) {
        for (int i = 0; i < edgeCounter; i++) {
            if (edgeSequence[i].getElement().equals(e)) {
                return new String[]{
                        edgeSequence[i].getOrigin().getElement(),
                        edgeSequence[i].getDestination().getElement()
                };
            }
        }

        return null;
    }

    public String opposite(String v, String e) {
        //find edge
        Edge edge = null;
        for (int i = 0; i < edgeCounter; i++) {
            if (edgeSequence[i].getElement().equals(e)) {
                edge = edgeSequence[i];
                break;
            }
        }


        if (edge != null) {
            if (edge.getOrigin().getElement().equals(v)) {
                return edge.getDestination().getElement();
            } else if (edge.getDestination().getElement().equals(v)) {
                return edge.getOrigin().getElement();
            }
        }

        return null;
    }

    public Vertex insertVertex(String x) {
        Vertex newVertex = new Vertex(x);

        vertexSequence[vertexCounter] = newVertex;

        vertexCounter++;

        return newVertex;
    }

    public Edge insertEdge(String u, String v, String x) {
        //if had edge
        if (hasEdge(u, v)) {
            return null;
        } else {
            Vertex origin = findVertex(u), destination = findVertex(v);

            //if hadn't Vertex
            if (origin == null || destination == null) {
                return null;
            } else {
                Edge newEdge = new Edge(x);

                newEdge.setOrigin(origin);
                newEdge.setDestination(destination);

                edgeSequence[edgeCounter] = newEdge;

                edgeCounter++;

                return newEdge;
            }
        }
    }

    private Vertex findVertex(String value) {
        for (int i = 0; i < vertexCounter; i++) {
            if (vertexSequence[i].getElement().equals(value)) {
                return vertexSequence[i];
            }
        }

        return null;
    }

    private boolean hasEdge(String u, String v) {
        for (int i = 0; i < edgeCounter; i++) {
            String origin = edgeSequence[i].getOrigin().getElement(), destination = edgeSequence[i].getDestination().getElement();

            if (origin.equals(u) && destination.equals(v)) {
                return true;
            } else if (origin.equals(v) && destination.equals(u)) {
                //because is undirected so need to add this statement
                return true;
            }
        }

        return false;
    }

    public void removeVertex(String v) {
        //remove Vertex
        for (int i = 0; i < vertexCounter; i++) {
            if (vertexSequence[i].getElement().equals(v)) {
                //use last vertex to replace removed vertex
                Vertex tempVertex = vertexSequence[vertexCounter];

                vertexSequence[i] = tempVertex;
                vertexSequence[vertexCounter] = null;

                vertexCounter--;
                break;
            }
        }

        //remove incident edges
        for (int i = 0; i < edgeCounter; i++) {
            if (edgeSequence[i].getOrigin().getElement().equals(v) || edgeSequence[i].getDestination().getElement().equals(v)) {
                removeEdge(edgeSequence[i].getElement());
            }
        }
    }

    public void removeEdge(String e) {
        for (int i = 0; i < edgeCounter; i++) {
            if (edgeSequence[i].getElement().equals(e)) {
                //use last edge to replace removed edge
                Edge tempEdge = edgeSequence[edgeCounter];

                edgeSequence[i] = tempEdge;
                edgeSequence[edgeCounter] = null;

                edgeCounter--;
                break;
            }
        }
    }
}
