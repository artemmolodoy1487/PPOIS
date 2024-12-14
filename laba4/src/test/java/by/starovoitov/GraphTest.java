package by.starovoitov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph<String> graph;

    @BeforeEach
    void setUp() {
        graph = new Graph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
    }

    @Test
    void testCheckForNode() {
        assertTrue(graph.checkForNode("A"));
        assertTrue(graph.checkForNode("B"));
        assertTrue(graph.checkForNode("C"));
        assertFalse(graph.checkForNode("D"));
    }

    @Test
    void testCheckForEdge() {
        assertTrue(graph.checkForEdge("A", "B"));
        assertFalse(graph.checkForEdge("A", "C"));
        assertTrue(graph.checkForEdge("B", "C"));
        assertFalse(graph.checkForEdge("C", "B"));
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
        graph.removeNode("B");
        assertEquals(2, graph.getNumberOfNodes());
        assertFalse(graph.checkForNode("B"));
    }

    @Test
    void testRemoveEdge() {
        graph.removeEdge("B", "C");
        assertEquals(2, graph.getNumberOfEdges());
        assertFalse(graph.checkForEdge("B", "C"));
    }

    @Test
    void testVertexIterator() {
        ListIterator<String> iterator = graph.vertexIterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testAdjacentVertexIterator() {
        ListIterator<String> iterator = graph.adjacentVertexIterator("B");
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }
}