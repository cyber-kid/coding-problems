package com.home.common.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;

public class UnweightedGraph {
    private List<Vertex> vertices = new ArrayList<>();

    Vertex createAndReturnVertex(String name) {
        Vertex newVertex = new Vertex(name);

        if (vertices.contains(newVertex)) {
            throw new RuntimeException("Vertex with name " + name + " exists");
        } else {
            vertices.add(newVertex);

            return newVertex;
        }
    }

    void addEdge(Vertex sourceVertex, Vertex destinationVertex) {
        sourceVertex.addNeighbor(destinationVertex);
    }

    void addUndirectedEdge(Vertex firstVertex, Vertex secondVertex) {
        firstVertex.addNeighbor(secondVertex);
        secondVertex.addNeighbor(firstVertex);
    }

    String breadthFirstSearch() {
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

        Vertex firstVertex = vertices.get(0);
        firstVertex.visit();
        result.add(firstVertex.getName());
        verticesWithUnVisitedNeighbors.offer(firstVertex);

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

    String depthFirstSearch() {
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

        return String.format("Vertices: %s\nEdges: %s", verticesStringJoiner.toString(), edgesStringJoiner.toString());
    }

    class Vertex {
        private String name;
        private Set<Vertex> adjacencyList = new HashSet<>();
        private boolean isVisited;

        Vertex(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }

        void addNeighbor(Vertex neighbor) {
            adjacencyList.add(neighbor);
        }

        private Collection<Vertex> getNeighbors() {
            return adjacencyList;
        }

        private Optional<Vertex> getUnvisitedNeighbor() {
            return adjacencyList.stream()
                    .filter(vertex -> !vertex.isVisited())
                    .findFirst();
        }

        private boolean isVisited() {
            return isVisited;
        }

        private void visit() {
            isVisited = true;
        }

        private void unVisit() {
            isVisited = false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return name.equals(vertex.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}

