package by.starovoitov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Graph<T> {
    private Map<T, List<T>> adjacencyList;
    private int nodeSize;

    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.nodeSize = 0;
    }

    public void addNode(T node) {
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new ArrayList<>());
            nodeSize++;
        }
    }

    public void addEdge(T from, T to) {
        if (checkForNode(from) && checkForNode(to)) {
            adjacencyList.get(from).add(to);
        } else {
            throw new IllegalArgumentException("One or both nodes do not exist.");
        }
    }

    public boolean checkForNode(T node) {
        return adjacencyList.containsKey(node);
    }

    public boolean checkForEdge(T from, T to) {
        return checkForNode(from) && checkForNode(to) && adjacencyList.get(from).contains(to);
    }

    public int getNumberOfNodes() {
        return nodeSize;
    }

    public int getNumberOfEdges() {
        int count = 0;
        for (List<T> edges : adjacencyList.values()) {
            count += edges.size();
        }
        return count;
    }

    public void removeNode(T node) {
        if (!checkForNode(node)) {
            throw new IllegalArgumentException("Invalid node index for removal.");
        }
        adjacencyList.remove(node);
        for (List<T> edges : adjacencyList.values()) {
            edges.remove(node); // Remove all incoming edges
        }
        nodeSize--;
    }

    public void removeEdge(T from, T to) {
        if (!checkForEdge(from, to)) {
            throw new IllegalArgumentException("Invalid edge index for removal.");
        }
        adjacencyList.get(from).remove(to);
    }

    public ListIterator<T> vertexIterator() {
        return new ArrayList<>(adjacencyList.keySet()).listIterator();
    }

    public ListIterator<T> adjacentVertexIterator(T node) {
        if (!checkForNode(node)) {
            throw new IllegalArgumentException("Invalid node index.");
        }
        return adjacencyList.get(node).listIterator();
    }
}