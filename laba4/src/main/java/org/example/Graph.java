package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Graph<T> {
    private List<List<Integer>> adjacencyList;
    private int nodeSize;

    public Graph(int nodeSize) {
        this.nodeSize = nodeSize;
        adjacencyList = new ArrayList<>(nodeSize);
        for (int i = 0; i < nodeSize; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        if (checkForNode(from) && checkForNode(to)) {
            adjacencyList.get(from).add(to);
        }
    }

    public boolean checkForNode(int node) {
        return node >= 0 && node < nodeSize;
    }

    public boolean checkForEdge(int from, int to) {
        return checkForNode(from) && checkForNode(to) && adjacencyList.get(from).contains(to);
    }

    public int getNumberOfNodes() {
        return nodeSize;
    }

    public int getNumberOfEdges() {
        int count = 0;
        for (List<Integer> edges : adjacencyList) {
            count += edges.size();
        }
        return count;
    }

    public void removeNode(int node) {
        if (!checkForNode(node)) {
            throw new IllegalArgumentException("Invalid node index for removal.");
        }
        for (List<Integer> edges : adjacencyList) {
            edges.remove((Integer) node); // Remove incoming edges
        }
        adjacencyList.set(node, new ArrayList<>()); // Remove outgoing edges
    }

    public void removeEdge(int from, int to) {
        if (!checkForEdge(from, to)) {
            throw new IllegalArgumentException("Invalid edge index for removal.");
        }
        adjacencyList.get(from).remove((Integer) to);
    }

    public ListIterator<Integer> vertexIterator() {
        return new ListIterator<Integer>() { // Specify <Integer> explicitly
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < nodeSize;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIndex++;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public Integer previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                return --currentIndex;
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(Integer integer) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void add(Integer integer) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public ListIterator<Integer> adjacentVertexIterator(int node) {
        if (!checkForNode(node)) {
            throw new IllegalArgumentException("Invalid node index.");
        }
        return adjacencyList.get(node).listIterator();
    }
}