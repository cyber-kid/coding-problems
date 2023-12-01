package com.home.topic_011_graphs.max_area_of_island;

import com.sun.tools.javac.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int area = calculateArea(grid, r, c, visited);

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private int calculateArea(int[][] grid, int r, int c, Set<Pair<Integer, Integer>> visited) {
        int area = 0;
        int columns = grid[0].length;
        int rows = grid.length;
        Pair<Integer, Integer> cell = new Pair<>(r, c);

        if (Math.min(r, c) < 0 || c == columns || r == rows || grid[r][c] == 0 || visited.contains(cell)) {
            return area;
        }

        area += 1;
        visited.add(cell);

        area += calculateArea(grid, r - 1, c, visited);
        area += calculateArea(grid, r + 1, c, visited);
        area += calculateArea(grid, r, c - 1, visited);
        area += calculateArea(grid, r, c + 1, visited);

        return area;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int result = solution.maxAreaOfIsland(grid); // 6

        System.out.println(result);

        int[][] grid2 = new int[][]{{0,0,0,0,0,0,0,0,0,0,0,0,0}};
        result = solution.maxAreaOfIsland(grid2); // 0

        System.out.println(result);
    }
}
