package com.home.topic_011_graphs.shortest_path_in_binary_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0, 1}); // row, col, length

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        while (!q.isEmpty()) {
            Integer[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int length = curr[2];

            // out of bounds or no way further
            if (Math.min(r, c) < 0 || Math.max(r, c) == n || grid[r][c] == 1) continue;

            if (r == n - 1 && c == n - 1) return length;

            for (int[] d : direct) {
                int newRow = r + d[0];
                int newCol = c + d[1];
                if (Math.min(newRow, newCol) >= 0 && Math.max(newRow, newCol) < n && !visited[newRow][newCol]) {
                    q.add(new Integer[]{newRow, newCol, 1 + length});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = new int[][] {{0,1},{1,0}};
        int result = solution.shortestPathBinaryMatrix(grid);

        System.out.println(result); // 2

        int[][] grid2 = new int[][] {{0,0,0},{1,1,0},{1,1,0}};
        result = solution.shortestPathBinaryMatrix(grid2);

        System.out.println(result); // 4

        int[][] grid3 = new int[][] {{1,0,0},{1,1,0},{1,1,0}};
        result = solution.shortestPathBinaryMatrix(grid3);

        System.out.println(result); // -1
    }
}
