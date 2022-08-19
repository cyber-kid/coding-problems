package com.home.data_structures.graph;

public class Solution {
    public static void main(String[] args) {
        UnweightedGraph graph = new UnweightedGraph();

        Vertex vertexA = graph.createAndReturnVertex("A");
        Vertex vertexB = graph.createAndReturnVertex("B");
        Vertex vertexC = graph.createAndReturnVertex("C");
        Vertex vertexD = graph.createAndReturnVertex("D");
        Vertex vertexE = graph.createAndReturnVertex("E");
        graph.addUndirectedEdge(vertexA, vertexB);
        graph.addUndirectedEdge(vertexA, vertexC);
        graph.addUndirectedEdge(vertexD, vertexC);
        graph.addUndirectedEdge(vertexE, vertexB);

        System.out.println(graph.breadthFirstScan());
        System.out.println(graph.depthFirstScan());
    }
}
