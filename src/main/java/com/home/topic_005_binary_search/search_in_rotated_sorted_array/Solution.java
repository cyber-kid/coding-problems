package com.home.topic_005_binary_search.search_in_rotated_sorted_array;

public class Solution {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[leftIndex] <= nums[mid]) {
                if (target >= nums[leftIndex] && target < nums[mid]) {
                    rightIndex = mid - 1;
                } else {
                    leftIndex = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[rightIndex]) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid - 1;
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
