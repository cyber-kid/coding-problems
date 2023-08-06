package com.home.searching.search_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        // binary search to find a row in the matrix
        while (top <= bottom) {
            int row = (top + bottom) / 2;

            // if target is smaller than the smallest element in the row, so we continue with rows above
            if (target < matrix[row][0]) {
                bottom = row - 1;
            // if target is greater than the biggest element in the row, so we continue with rows below
            } else if (target > matrix[row][matrix[0].length - 1]) {
                top = row + 1;
            } else {
                // this is our row
                break;
            }
        }

        // if we did not hit break we know that the item is not in the matrix
        if (top <= bottom) {
            return false;
        }

        int row = (top + bottom) / 2;
        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int middle = (right + left) / 2;

            if (matrix[row][middle] > target) {
                right = middle - 1;
            } else if (matrix[row][middle] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[][] matrix = {{1}};
        int[][] matrix = {{1,1}};

        Solution solution = new Solution();

        System.out.println(solution.searchMatrix(matrix, 2));
    }
}
