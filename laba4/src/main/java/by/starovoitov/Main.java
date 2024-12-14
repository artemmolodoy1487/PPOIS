package by.starovoitov;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Create a generic graph
        Graph<String> graph = new Graph<>();

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        // Add edges
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");

        // Print number of nodes and edges
        System.out.println("Number of nodes: " + graph.getNumberOfNodes());
        System.out.println("Number of edges: " + graph.getNumberOfEdges());

        // Print adjacent vertices for each node
        for (ListIterator<String> iterator = graph.vertexIterator(); iterator.hasNext(); ) {
            String node = iterator.next();
            System.out.print("Adjacent vertices for node " + node + ": ");
            ListIterator<String> adjIterator = graph.adjacentVertexIterator(node);
            while (adjIterator.hasNext()) {
                System.out.print(adjIterator.next() + " ");
            }
            System.out.println();
        }
    }
}