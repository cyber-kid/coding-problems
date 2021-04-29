package com.home.common.graphs;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class UnweightedGraphTest {
    @Test
    public void addVertexTest_happyPath() {
        UnweightedGraph graph = new UnweightedGraph();

        UnweightedGraph.Vertex newVertex = graph.createAndReturnVertex("A");

        Assertions.assertThat(graph.toString()).isEqualTo("Vertices: A\nEdges: ");
        Assertions.assertThat(newVertex).isNotNull();
    }

    @Test(expected = RuntimeException.class)
    public void addVertexTest_duplicateVertex() {
        UnweightedGraph graph = new UnweightedGraph();

        try {
            graph.createAndReturnVertex("A");
            graph.createAndReturnVertex("A");
        } catch (RuntimeException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("Vertex with name A exists");
            throw e;
        }
    }

    @Test
    public void addEdgeTest_directedGraphHappyPath() {
        UnweightedGraph graph = new UnweightedGraph();

        UnweightedGraph.Vertex newVertexA = graph.createAndReturnVertex("A");
        UnweightedGraph.Vertex newVertexB = graph.createAndReturnVertex("B");

        graph.addEdge(newVertexA, newVertexB);

        Assertions.assertThat(graph.toString()).isEqualTo("Vertices: A, B\nEdges: [AB]");
    }

    @Test
    public void addEdgeTest_undirectedGraphHappyPath() {
        UnweightedGraph graph = new UnweightedGraph();

        UnweightedGraph.Vertex newVertexA = graph.createAndReturnVertex("A");
        UnweightedGraph.Vertex newVertexB = graph.createAndReturnVertex("B");

        graph.addUndirectedEdge(newVertexA, newVertexB);

        Assertions.assertThat(graph.toString()).isEqualTo("Vertices: A, B\nEdges: [AB], [BA]");
    }

    @Test
    public void addEdgeTest_noDuplicates() {
        UnweightedGraph graph = new UnweightedGraph();

        UnweightedGraph.Vertex newVertexA = graph.createAndReturnVertex("A");
        UnweightedGraph.Vertex newVertexB = graph.createAndReturnVertex("B");

        graph.addUndirectedEdge(newVertexA, newVertexB);
        graph.addUndirectedEdge(newVertexB, newVertexA);

        Assertions.assertThat(graph.toString()).isEqualTo("Vertices: A, B\nEdges: [AB], [BA]");
    }

    @Test
    public void depthFirstSearchTest_happyPath() {
        UnweightedGraph graph = new UnweightedGraph();

        UnweightedGraph.Vertex newVertexA = graph.createAndReturnVertex("A");
        UnweightedGraph.Vertex newVertexB = graph.createAndReturnVertex("B");
        UnweightedGraph.Vertex newVertexC = graph.createAndReturnVertex("C");
        UnweightedGraph.Vertex newVertexD = graph.createAndReturnVertex("D");
        UnweightedGraph.Vertex newVertexE = graph.createAndReturnVertex("E");
        UnweightedGraph.Vertex newVertexF = graph.createAndReturnVertex("F");
        UnweightedGraph.Vertex newVertexZ = graph.createAndReturnVertex("Z");

        graph.addUndirectedEdge(newVertexA, newVertexB);
        graph.addUndirectedEdge(newVertexB, newVertexC);
        graph.addUndirectedEdge(newVertexA, newVertexD);
        graph.addUndirectedEdge(newVertexD, newVertexZ);
        graph.addUndirectedEdge(newVertexA, newVertexE);
        graph.addUndirectedEdge(newVertexE, newVertexF);
        graph.addUndirectedEdge(newVertexB, newVertexD);

        String result = graph.depthFirstSearch();

        Assertions.assertThat(result).isEqualTo("DFS results: A, B, C, D, Z, E, F");
    }

    @Test
    public void depthFirstSearchTest_emptyGraph() {
        UnweightedGraph graph = new UnweightedGraph();

        String result = graph.depthFirstSearch();

        Assertions.assertThat(result).isEqualTo("DFS results: graph is empty");
    }

    @Test
    public void breadthFirstSearchTest_happyPath() {
        UnweightedGraph graph = new UnweightedGraph();

        UnweightedGraph.Vertex newVertexA = graph.createAndReturnVertex("A");
        UnweightedGraph.Vertex newVertexB = graph.createAndReturnVertex("B");
        UnweightedGraph.Vertex newVertexC = graph.createAndReturnVertex("C");
        UnweightedGraph.Vertex newVertexD = graph.createAndReturnVertex("D");
        UnweightedGraph.Vertex newVertexE = graph.createAndReturnVertex("E");
        UnweightedGraph.Vertex newVertexF = graph.createAndReturnVertex("F");
        UnweightedGraph.Vertex newVertexZ = graph.createAndReturnVertex("Z");

        graph.addUndirectedEdge(newVertexA, newVertexB);
        graph.addUndirectedEdge(newVertexB, newVertexC);
        graph.addUndirectedEdge(newVertexA, newVertexD);
        graph.addUndirectedEdge(newVertexD, newVertexZ);
        graph.addUndirectedEdge(newVertexA, newVertexE);
        graph.addUndirectedEdge(newVertexE, newVertexF);
        graph.addUndirectedEdge(newVertexB, newVertexD);

        String result = graph.breadthFirstSearch();

        Assertions.assertThat(result).isEqualTo("BFS results: A, B, D, E, C, Z, F");
    }
}
