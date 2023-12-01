package com.home.topic_011_graphs.pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] toPacific = new boolean[heights.length][heights[0].length];
        boolean[][] toAtlantic = new boolean[heights.length][heights[0].length];

        for (int row = 0; row < heights.length; row++) {
            dfs(heights, row, 0, heights[row][0], toPacific);
            dfs(heights, row, heights[0].length - 1, heights[row][heights[0].length - 1], toAtlantic);
        }

        for (int column = 0; column < heights[0].length; column++) {
            dfs(heights, 0, column, heights[0][column], toPacific);
            dfs(heights, heights.length - 1, column, heights[heights.length - 1][column], toAtlantic);
        }

        for (int row = 0; row < heights.length; row++) {
            for (int column = 0; column < heights[0].length; column++) {
                if (toAtlantic[row][column] && toPacific[row][column]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(row);
                    cell.add(column);

                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int column, int previousHeight, boolean[][] visited) {
        if (row < 0 || row == heights.length || column < 0 || column == heights[0].length || visited[row][column] || heights[row][column] < previousHeight) {
            return;
        }

        visited[row][column] = true;

        dfs(heights, row - 1, column, heights[row][column], visited);
        dfs(heights, row + 1, column, heights[row][column], visited);
        dfs(heights, row, column - 1, heights[row][column], visited);
        dfs(heights, row, column + 1, heights[row][column], visited);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] heights = new int[][]{{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
        System.out.println(solution.pacificAtlantic(heights)); // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]

        heights = new int[][]{{1}};
        System.out.println(solution.pacificAtlantic(heights)); // [[0, 0]]
    }
}
