package com.home.two_pointers.container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int result = 0;

        while (leftIndex < rightIndex) {
            int area = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            result = Math.max(result, area);

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.printf("A: %d, E: %d\n", solution.maxArea(height), 49);

        height = new int[]{1, 1};
        System.out.printf("A: %d, E: %d\n", solution.maxArea(height), 1);
    }

}
