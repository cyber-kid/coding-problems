package com.home.data_structures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;

public class UnweightedGraph {
    private final List<Vertex> vertices = new ArrayList<>();

    public Vertex createAndReturnVertex(String name) {
        Vertex newVertex = new Vertex(name);

        if (vertices.contains(newVertex)) {
            throw new RuntimeException("Vertex with name " + name + " exists");
        } else {
            vertices.add(newVertex);

            return newVertex;
        }
    }

    public void addDirectedEdge(Vertex sourceVertex, Vertex destinationVertex) {
        sourceVertex.addNeighbor(destinationVertex);
    }

    public void addUndirectedEdge(Vertex firstVertex, Vertex secondVertex) {
        firstVertex.addNeighbor(secondVertex);
        secondVertex.addNeighbor(firstVertex);
    }

    public String breadthFirstScan() {
        String result;

        if (vertices.isEmpty()) {
            result = "graph is empty";
        } else {
            result = executeBFS();
        }

        return String.format("BFS results: %s", result);
    }

    private String executeBFS() {
        Queue<Vertex> verticesWithUnVisitedNeighbors = new LinkedList<>();
        StringJoiner result = new StringJoiner(", ");

        Vertex currentVertex = vertices.get(0);
        currentVertex.visit();
        result.add(currentVertex.getName());
        verticesWithUnVisitedNeighbors.offer(currentVertex);

        while (!verticesWithUnVisitedNeighbors.isEmpty()) {
            Optional<Vertex> unvisitedNeighborOptional = verticesWithUnVisitedNeighbors.peek().getUnvisitedNeighbor();
            if (unvisitedNeighborOptional.isPresent()) {
                Vertex unvisitedNeighbor = unvisitedNeighborOptional.get();
                unvisitedNeighbor.visit();
                result.add(unvisitedNeighbor.getName());
                verticesWithUnVisitedNeighbors.offer(unvisitedNeighbor);
            } else {
                verticesWithUnVisitedNeighbors.poll();
            }
        }

        reset();

        return result.toString();
    }

    public String depthFirstScan() {
        String result;

        if (vertices.isEmpty()) {
            result = "graph is empty";
        } else {
            result = executeDFS();
        }

        return String.format("DFS results: %s", result);
    }

    private String executeDFS() {
        Stack<Vertex> verticesWithUnVisitedNeighbors = new Stack<>();
        StringJoiner result = new StringJoiner(", ");

        Vertex firstVertex = vertices.get(0);
        firstVertex.visit();
        result.add(firstVertex.getName());
        verticesWithUnVisitedNeighbors.push(firstVertex);

        while (!verticesWithUnVisitedNeighbors.empty()) {
            Optional<Vertex> unvisitedNeighborOptional = verticesWithUnVisitedNeighbors.peek().getUnvisitedNeighbor();
            if (unvisitedNeighborOptional.isPresent()) {
                Vertex unvisitedNeighbor = unvisitedNeighborOptional.get();
                unvisitedNeighbor.visit();
                result.add(unvisitedNeighbor.getName());
                verticesWithUnVisitedNeighbors.push(unvisitedNeighbor);
            } else {
                verticesWithUnVisitedNeighbors.pop();
            }
        }

        reset();

        return result.toString();
    }

    private void reset() {
        vertices.forEach(Vertex::unVisit);
    }

    @Override
    public String toString() {
        StringJoiner verticesStringJoiner = new StringJoiner(", ");
        StringJoiner edgesStringJoiner = new StringJoiner(", ");

        for (Vertex vertex : vertices) {
            verticesStringJoiner.add(vertex.getName());

            for (Vertex neighbor : vertex.getNeighbors()) {
                String edge = String.format("[%s%s]", vertex.getName(), neighbor.getName());
                edgesStringJoiner.add(edge);
            }
        }

        return String.format("Vertices: %s\nEdges: %s", verticesStringJoiner, edgesStringJoiner);
    }
}

