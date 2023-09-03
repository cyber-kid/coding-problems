package com.home.topic_014_dp.task_045_house_robber;

public class Solution {
    public int rob(int[] nums) {
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
        nums = new int[]{2,7,9,3,1};
        System.out.printf("A: %d, E: %d\n", solution.rob(nums), 12);
    }
}
