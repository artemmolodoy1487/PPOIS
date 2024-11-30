package org.example;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Iterate over vertices
        System.out.println("Vertices:");
        ListIterator<Integer> vertexIterator = graph.vertexIterator();
        while (vertexIterator.hasNext()) {
            System.out.println("Vertex: " + vertexIterator.next());
        }

        // Iterate over edges
        System.out.println("\nEdges:");
        ListIterator<int[]> edgeIterator = graph.edgeIterator();
        while (edgeIterator.hasNext()) {
            int[] edge = edgeIterator.next();
            System.out.print("Edge: ");
            for (int vertex : edge) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }

        // Iterate over incident edges of a vertex
        int nodeToCheck = 1;
        System.out.println("\nIncident Edges of vertex " + nodeToCheck + ":");
        ListIterator<Integer> incidentEdgeIterator = graph.incidentEdgeIterator(nodeToCheck);
        while (incidentEdgeIterator.hasNext()) {
            System.out.println("Incident Edge: " + incidentEdgeIterator.next());
        }

        // Iterate over adjacent vertices
        System.out.println("\nAdjacent Vertices of vertex " + nodeToCheck + ":");
        ListIterator<Integer> adjacentVertexIterator = graph.adjacentVertexIterator(nodeToCheck);
        while (adjacentVertexIterator.hasNext()) {
            System.out.println("Adjacent Vertex: " + adjacentVertexIterator.next());
        }

        // Remove a vertex
        System.out.println("\nRemoving vertex 0:");
        vertexIterator = graph.vertexIterator();
        if (vertexIterator.hasNext()) {
            vertexIterator.next(); // Move to the first vertex
            vertexIterator.remove();
        }
        System.out.println("Vertices after removal:");
        vertexIterator = graph.vertexIterator();
        while (vertexIterator.hasNext()) {
            System.out.println("Vertex: " + vertexIterator.next());
        }

        // Remove an edge
        System.out.println("\nRemoving edge 0:");
        edgeIterator = graph.edgeIterator();
        if (edgeIterator.hasNext()) {
            edgeIterator.next(); // Move to the first edge
            edgeIterator.remove();
        }
        System.out.println("Edges after removal:");
        edgeIterator = graph.edgeIterator();
        while (edgeIterator.hasNext()) {
            int[] edge = edgeIterator.next();
            System.out.print("Edge: ");
            for (int vertex : edge) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}