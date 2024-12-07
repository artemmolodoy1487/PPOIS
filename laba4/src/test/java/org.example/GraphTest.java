package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new Graph<>(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
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
        assertTrue(graph.checkForEdge(0, 1));
        assertFalse(graph.checkForEdge(0, 2));
        assertTrue(graph.checkForEdge(1, 2));
        assertFalse(graph.checkForEdge(2, 1));
    }

    @Test
    void testGetNumberOfNodes() {
        assertEquals(3, graph.getNumberOfNodes());
    }

    @Test
    void testGetNumberOfEdges() {
        assertEquals(3, graph.getNumberOfEdges());
    }

    @Test
    void testRemoveNode() {
        graph.removeNode(1);
        assertEquals(3, graph.getNumberOfNodes());
        assertTrue(graph.checkForNode(1));
    }

    @Test
    void testRemoveEdge() {
        graph.removeEdge(1, 2);
        assertEquals(2, graph.getNumberOfEdges());
        assertFalse(graph.checkForEdge(1, 2));
    }

    @Test
    void testVertexIterator() {
        ListIterator<Integer> iterator = graph.vertexIterator();
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testAdjacentVertexIterator() {
        ListIterator<Integer> iterator = graph.adjacentVertexIterator(1);
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
    }
}