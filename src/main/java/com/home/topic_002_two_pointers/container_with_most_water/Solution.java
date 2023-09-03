package com.home.topic_002_two_pointers.container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int side1 = Math.min(height[left], height[right]);
            int side2 = right - left;
            maxArea = Math.max(maxArea, side1 * side2);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.printf("A: %d, E: %d\n", solution.maxArea(height), 49);

        height = new int[]{1, 1};
        System.out.printf("A: %d, E: %d\n", solution.maxArea(height), 1);
    }

}
