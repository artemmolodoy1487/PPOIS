package org.example;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Graph {

    private int[][] matrix;
    private int node_size;
    private int edge_size;

    public Graph() {
        int[][] staticArray = {
                {1, 0},
                {1, 1},
                {0, 1}
        };

        matrix = staticArray;
        node_size = staticArray.length;
        edge_size = staticArray[0].length;

        displayMatrix();
    }

    private void displayMatrix() {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public boolean checkForNode(int node) {
        return node >= 0 && node < node_size;
    }

    public boolean checkForEdge(int from, int to) {
        return from >= 0 && from < node_size && to >= 0 && to < node_size && matrix[from][to] == 1;
    }

    public int getNumberOfNodes() {
        return node_size;
    }

    public int getNumberOfEdges() {
        return edge_size;
    }

    public int getNodeDegree(int node) {
        int degree = 0;
        for (int val : matrix[node]) {
            if (val == 1) {
                degree++;
            }
        }
        return degree;
    }

    public int getEdgeDegree(int edge) {
        int degree = 0;
        for (int i = 0; i < node_size; i++) {
            if (matrix[i][edge] == 1) {
                degree += getNodeDegree(i);
            }
        }
        return degree;
    }

    public void removeNode(int node) {
        if (!checkForNode(node)) {
            throw new IllegalArgumentException("Invalid node index for removal.");
        }

        int[][] newMatrix = new int[node_size - 1][edge_size];
        for (int i = 0, k = 0; i < node_size; i++) {
            if (i == node) continue;
            newMatrix[k++] = matrix[i];
        }
        node_size--;
        matrix = newMatrix;
    }

    public void removeEdge(int edge) {
        if (edge < 0 || edge >= edge_size) {
            throw new IllegalArgumentException("Invalid edge index for removal.");
        }

        int[][] newMatrix = new int[node_size][edge_size - 1];
        for (int i = 0; i < node_size; i++) {
            for (int j = 0, k = 0; j < edge_size; j++) {
                if (j == edge) continue;
                newMatrix[i][k++] = matrix[i][j];
            }
        }
        edge_size--;
        matrix = newMatrix;
    }

    // Iterator for vertices
    public ListIterator<Integer> vertexIterator() {
        return new ListIterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < node_size;
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
                removeNode(currentIndex - 1);
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

    // Iterator for edges
    public ListIterator<int[]> edgeIterator() {
        return new ListIterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < edge_size;
            }

            @Override
            public int[] next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int[] edge = new int[node_size];
                for (int i = 0; i < node_size; i++) {
                    edge[i] = matrix[i][currentIndex];
                }
                currentIndex++;
                return edge;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public int[] previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                int[] edge = new int[node_size];
                for (int i = 0; i < node_size; i++) {
                    edge[i] = matrix[i][--currentIndex];
                }
                return edge;
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
                removeEdge(currentIndex - 1);
            }

            @Override
            public void set(int[] ints) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void add(int[] ints) {
                throw new UnsupportedOperationException();
            }
        };
    }

    // Iterator for incident edges of a vertex
    public ListIterator<Integer> incidentEdgeIterator(int node) {
        if (!checkForNode(node)) {
            throw new IllegalArgumentException("Invalid node index.");
        }

        return new ListIterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                while (currentIndex < edge_size && matrix[node][currentIndex] == 0) {
                    currentIndex++;
                }
                return currentIndex < edge_size;
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
                while (currentIndex > 0 && matrix[node][currentIndex - 1] == 0) {
                    currentIndex--;
                }
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
                throw new UnsupportedOperationException("Cannot remove incident edges directly.");
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

    // Iterator for adjacent vertices of a vertex
    public ListIterator<Integer> adjacentVertexIterator(int node) {
        if (!checkForNode(node)) {
            throw new IllegalArgumentException("Invalid node index.");
        }

        return new ListIterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                while (currentIndex < node_size && matrix[currentIndex][node] == 0) {
                    currentIndex++;
                }
                return currentIndex < node_size;
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
                while (currentIndex > 0 && matrix[currentIndex - 1][node] == 0) {
                    currentIndex--;
                }
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
                throw new UnsupportedOperationException("Cannot remove adjacent vertices directly.");
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
}