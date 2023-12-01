package com.home.topic_011_graphs.graph_valid_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, List<Integer>> adjacencyList = buildGraph(n, edges);
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();

        stack.push(0);
        seen.add(0);

        while (!stack.isEmpty()) {
            int currentEdge = stack.pop();

            for (int neighbor : adjacencyList.get(currentEdge)) {
                if (!seen.contains(neighbor)) {
                    stack.push(neighbor);
                    seen.add(neighbor);
                }
            }
        }

        return seen.size() == n;
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

        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(solution.validTree(5, edges)); // true

        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(solution.validTree(5, edges)); // false
    }
}
