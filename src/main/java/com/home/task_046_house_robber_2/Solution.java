package com.home.task_046_house_robber_2;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)), helper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public int helper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);

            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,2,3,1};
        System.out.printf("A: %d, E: %d\n", solution.rob(nums), 4);
        nums = new int[]{2,3,2};
        System.out.printf("A: %d, E: %d\n", solution.rob(nums), 3);
    }
}
