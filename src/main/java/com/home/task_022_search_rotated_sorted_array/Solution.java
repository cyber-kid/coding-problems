package com.home.task_022_search_rotated_sorted_array;

public class Solution {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int middle = (rightIndex + leftIndex) / 2;

            if (target == nums[middle]) {
                return middle;
            }

            if (nums[leftIndex] <= nums[middle]) {
                if (target > nums[middle] || target < nums[leftIndex]) {
                    leftIndex = middle + 1;
                } else {
                    rightIndex = middle - 1;
                }
            } else {
                if (target < nums[middle] || target > nums[rightIndex]) {
                    rightIndex = middle - 1;
                } else {
                    leftIndex = middle + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{5, 1, 3};
        System.out.printf("A: %d, E: %d\n", solution.search(nums, 5), 0);

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.printf("A: %d, E: %d\n", solution.search(nums, 3), -1);

        nums = new int[]{2, 4, 5, 6, 7, 0, 1};
        System.out.printf("A: %d, E: %d\n", solution.search(nums, 0), 5);

        nums = new int[]{1};
        System.out.printf("A: %d, E: %d\n", solution.search(nums, 0), -1);
    }
}
