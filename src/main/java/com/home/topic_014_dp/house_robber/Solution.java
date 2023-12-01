package com.home.topic_014_dp.house_robber;

public class Solution {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        // rob1 and rob2 are placeholders in dp table to handle the case of 2 first houses
        // [rob1, rob2, n, n + 1, ... ]
        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);

            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    public int robRec(int[] nums) {
        return recursion(0, nums);
    }

    private int recursion(int start, int[] nums) {
        if (start == nums.length - 1) {
            return nums[start];
        }

        if (start == nums.length) {
            return 0;
        }

        return Math.max(nums[start] + recursion(start + 2, nums), recursion(start + 1, nums));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,2,3,1};
        System.out.printf("A: %d, E: %d\n", solution.robRec(nums), 4);
        nums = new int[]{2,7,9,3,1};
        System.out.printf("A: %d, E: %d\n", solution.robRec(nums), 12);
    }
}
