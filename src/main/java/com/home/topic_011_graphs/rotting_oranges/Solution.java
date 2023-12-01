package com.home.topic_011_graphs.rotting_oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> queue = new LinkedList<>();
        int freshOrangesCount = 0;
        int daysElapsed = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] neighbours = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] == 1) {
                    freshOrangesCount++;
                } else if (grid[r][c] == 2) {
                    Integer[] rottenOrange = new Integer[] {r, c};

                    queue.offer(rottenOrange);
                }
            }
        }

        while (!queue.isEmpty() && freshOrangesCount > 0) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                Integer[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];

                for (int[] directions: neighbours) {
                    int newRow = r + directions[0];
                    int newCol = c + directions[1];
                    Integer[] newOrange = new Integer[] {newRow, newCol};

                    if (Math.min(newRow, newCol) < 0 || newRow == rows || newCol == columns || grid[newRow][newCol] != 1) {
                        continue;
                    }

                    queue.offer(newOrange);
                    freshOrangesCount--;
                    grid[newRow][newCol] = 2;
                }
            }

            daysElapsed++;
        }

        if (freshOrangesCount == 0) {
            return daysElapsed;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        int result = solution.orangesRotting(grid);

        System.out.println(result); // 4

        int[][] grid2 = new int[][] {{2,1,1},{0,1,1},{1,0,1}};
        result = solution.orangesRotting(grid2);

        System.out.println(result); // -1

        int[][] grid3 = new int[][] {{0,2}};
        result = solution.orangesRotting(grid3);

        System.out.println(result); // 0
    }
}
