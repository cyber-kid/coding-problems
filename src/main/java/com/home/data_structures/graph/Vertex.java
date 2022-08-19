package com.home.data_structures.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Vertex {
    private final String name;
    private final Set<Vertex> adjacencyList = new HashSet<>();
    private boolean isVisited;

    protected Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addNeighbor(Vertex neighbor) {
        adjacencyList.add(neighbor);
    }

    public Collection<Vertex> getNeighbors() {
        return adjacencyList;
    }

    public Optional<Vertex> getUnvisitedNeighbor() {
        return adjacencyList.stream()
                .filter(vertex -> !vertex.isVisited())
                .findFirst();
    }

    private boolean isVisited() {
        return isVisited;
    }

    public void visit() {
        isVisited = true;
    }

    public void unVisit() {
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
