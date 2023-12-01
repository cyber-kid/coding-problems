package com.home.topic_011_graphs.surrounded_regions;

import java.util.Arrays;

public class Solution {
    public void solve(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            dfs(board, r, 0);
        }

        for (int r = 0; r < board.length; r++) {
            dfs(board, r,board[0].length - 1);
        }

        for (int c = 0; c < board[0].length; c++) {
            dfs(board, 0, c);
        }

        for (int c = 0; c < board[0].length; c++) {
            dfs(board, board.length - 1, c);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char sign = board[r][c];
                if (sign == 'T') {
                    board[r][c] = 'O';
                } else if (sign == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r == board.length || c == board[0].length || Math.min(r, c) < 0 || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solution.solve(board);

        for (char[] row: board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
