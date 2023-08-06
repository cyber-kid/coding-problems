package com.home.searching.task_023_min_in_rotated_sorted_array;

public class Solution {
    public int findMin(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int result = nums[0];

        while (leftIndex <= rightIndex) {
            if (nums[leftIndex] < nums[rightIndex]) {
                result = Math.min(result, nums[leftIndex]);
                break;
            }

            int middleIndex = (leftIndex + rightIndex) / 2;

            result = Math.min(result, nums[middleIndex]);

            if (nums[middleIndex] >= nums[leftIndex]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{5, 1, 3};
        System.out.printf("A: %d, E: %d\n", solution.findMin(nums), 1);

        nums = new int[]{4,5,6,7,0,1,2};
        System.out.printf("A: %d, E: %d\n", solution.findMin(nums), 0);

        nums = new int[]{3,4,5,1,2};
        System.out.printf("A: %d, E: %d\n", solution.findMin(nums), 1);
    }
}
