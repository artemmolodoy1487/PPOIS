package org.example;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Create a graph with 3 nodes
        Graph<Integer> graph = new Graph<>(3);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        // Print number of nodes and edges
        System.out.println("Number of nodes: " + graph.getNumberOfNodes());
        System.out.println("Number of edges: " + graph.getNumberOfEdges());

        // Print adjacent vertices for each node
        for (int i = 0; i < graph.getNumberOfNodes(); i++) {
            System.out.print("Adjacent vertices for node " + i + ": ");
            ListIterator<Integer> iterator = graph.adjacentVertexIterator(i);
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }
}