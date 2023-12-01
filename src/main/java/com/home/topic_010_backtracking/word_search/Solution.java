package com.home.topic_010_backtracking.word_search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row < board.length; row++) {
                boolean result = backtrackingRecursive(0, new Integer[]{col, row}, board, word);

                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrackingRecursive(int positionInWord, Integer[] boardCoordinates, char[][] board, String word) {
        // we found the solution
        if (positionInWord == word.length()) {
            return true;
        }

        Integer col = boardCoordinates[0];
        Integer row = boardCoordinates[1];

        // check the boundaries and if current cell matches the letter in the search word
        if ((col < 0) || (row < 0) ||
                (col >= board[0].length) || (row >= board.length) ||
                (word.charAt(positionInWord) != board[row][col])) {
            return false;
        }

        // if current cell matches the letter in the search word
        // we mark it as visited to avoid duplicates
        board[row][col] = '#';
        // continue exploration to all possible neighbours
        boolean result = (backtrackingRecursive(positionInWord + 1, new Integer[]{col + 1, row}, board, word) ||
                backtrackingRecursive(positionInWord + 1, new Integer[]{col - 1, row}, board, word) ||
                backtrackingRecursive(positionInWord + 1, new Integer[]{col, row + 1}, board, word) ||
                backtrackingRecursive(positionInWord + 1, new Integer[]{col, row - 1}, board, word));

        // we revert the cell
        board[row][col] = word.charAt(positionInWord);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        System.out.println(solution.exist(board, "ABCCED"));
        System.out.println(solution.exist(board, "SEE"));
        System.out.println(solution.exist(board, "ABCB"));
    }
}
