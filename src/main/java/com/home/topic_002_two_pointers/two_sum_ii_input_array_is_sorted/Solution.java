package com.home.topic_002_two_pointers.two_sum_ii_input_array_is_sorted;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
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
