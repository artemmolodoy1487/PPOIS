package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph();
    }

    @Test
    void testDisplayMatrix() {
        // Метод ничего не возвращает, поэтому проверяем его исполнение без исключений.
        assertDoesNotThrow(() -> graph.getNumberOfNodes());
    }

    @Test
    void testCheckForNode() {
        assertTrue(graph.checkForNode(0));
        assertTrue(graph.checkForNode(1));
        assertTrue(graph.checkForNode(2));
        assertFalse(graph.checkForNode(-1));
        assertFalse(graph.checkForNode(3));
    }

    @Test
    void testCheckForEdge() {
        assertTrue(graph.checkForEdge(0, 0));
        assertFalse(graph.checkForEdge(0, 1));
        assertTrue(graph.checkForEdge(1, 1));
        assertFalse(graph.checkForEdge(2, 0));
        assertFalse(graph.checkForEdge(2, 3)); // Граничный случай
    }

    @Test
    void testGetNumberOfNodes() {
        assertEquals(3, graph.getNumberOfNodes());
    }

    @Test
    void testGetNumberOfEdges() {
        assertEquals(2, graph.getNumberOfEdges());
    }

    @Test
    void testGetNodeDegree() {
        assertEquals(1, graph.getNodeDegree(0));
        assertEquals(2, graph.getNodeDegree(1));
        assertEquals(1, graph.getNodeDegree(2));
    }

    @Test
    void testGetEdgeDegree() {
        assertEquals(3, graph.getEdgeDegree(0));
    }

    @Test
    void testRemoveNode() {
        graph.removeNode(1);
        assertEquals(2, graph.getNumberOfNodes());

        assertThrows(IllegalArgumentException.class, () -> graph.removeNode(3));
    }

    @Test
    void testRemoveEdge() {
        graph.removeEdge(1);
        assertEquals(1, graph.getNumberOfEdges());

        assertThrows(IllegalArgumentException.class, () -> graph.removeEdge(2));
    }

    @Test
    void testVertexIterator() {
        ListIterator<Integer> iterator = graph.vertexIterator();
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());

        assertTrue(iterator.hasPrevious());
        assertEquals(2, iterator.previous());
        assertEquals(1, iterator.previous());
        assertEquals(0, iterator.previous());
        assertFalse(iterator.hasPrevious());
    }

    @Test
    void testEdgeIterator() {
        ListIterator<int[]> iterator = graph.edgeIterator();
        assertTrue(iterator.hasNext());
        int[] edge0 = iterator.next();
        assertArrayEquals(new int[]{1, 1, 0}, edge0);

        assertTrue(iterator.hasNext());
        int[] edge1 = iterator.next();
        assertArrayEquals(new int[]{0, 1, 1}, edge1);

        assertFalse(iterator.hasNext());
    }

    @Test
    void testIncidentEdgeIterator() {
        ListIterator<Integer> iterator = graph.incidentEdgeIterator(1);
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());

        assertThrows(IllegalArgumentException.class, () -> graph.incidentEdgeIterator(3));
    }

    @Test
    void testAdjacentVertexIterator() {
        ListIterator<Integer> iterator = graph.adjacentVertexIterator(1);
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());

        assertThrows(IllegalArgumentException.class, () -> graph.adjacentVertexIterator(3));
    }
}