package com.home.topic_011_graphs.number_of_connected_components_in_an_undirected_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int countComponents(int n, int[][] edges) {
//        Map<Integer, List<Integer>> adjacencyList = buildGraph(n, edges);
//        Set<Integer> visited = new HashSet<>();
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (!visited.contains(i)) {
//                count++;
//
//                dfsRec(i, adjacencyList, visited);
//            }
//        }
//
//        return count;

        return unionFind(n, edges);
    }

    private int unionFind(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge: edges) {
            int parent = edge[0];
            int child = edge[1];

            if (parents[child] != parents[parent]) {
                n -= 1;
                parents[child] = parents[parent];
            }
        }

        return n;
    }

    public void dfsRec(int edge, Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited) {
        if (visited.contains(edge)) {
            return;
        }

        visited.add(edge);

        for (int neighbor : adjacencyList.get(edge)) {
            dfsRec(neighbor, adjacencyList, visited);
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return adjacencyList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution.countComponents(5, edges)); // 1

        edges = new int[][]{{0,1},{1,2},{3,4}};
        System.out.println(solution.countComponents(5, edges)); // 2

        edges = new int[][]{{1,0}};
        System.out.println(solution.countComponents(2, edges)); // 1
    }
}
