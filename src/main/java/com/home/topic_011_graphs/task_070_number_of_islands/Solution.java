package com.home.topic_011_graphs.task_070_number_of_islands;

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    count++;
                    exploreIsland(grid, row, column);
                }
            }
        }

        return count;
    }

    private void exploreIsland(char[][] grid, int row, int column) {
        if (!isInbound(grid, row, column)) {
            return;
        }

        if (grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';

        exploreIsland(grid, row, column + 1);
        exploreIsland(grid, row, column - 1);
        exploreIsland(grid, row + 1, column);
        exploreIsland(grid, row - 1, column);
    }

    private boolean isInbound(char[][] grid, int row, int column) {
        return (0 <= row && row < grid.length) && (0 <= column && column < grid[0].length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] grid = new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(solution.numIslands(grid)); //1

        grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(solution.numIslands(grid)); //3
    }
}
