package com.home.task_014_two_sum_ii;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];

            if (sum == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            }

            if (sum > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));

        nums = new int[]{2,3,4};
        System.out.println(Arrays.toString(solution.twoSum(nums, 6)));

        nums = new int[]{-1,0};
        System.out.println(Arrays.toString(solution.twoSum(nums, -1)));
    }
}
