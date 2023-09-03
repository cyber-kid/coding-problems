package com.home.topic_015_greedy.maximum_sum_circular_subarray;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int currentMinSum = 0;
        int currentMaxSum = 0;
        int globalMin = nums[0];
        int globalMax = nums[0];

        for (int num: nums) {
            total += num;

            currentMinSum = Math.min(currentMinSum + num, num);
            globalMin = Math.min(globalMin, currentMinSum);

            currentMaxSum = Math.max(currentMaxSum + num, num);
            globalMax = Math.max(globalMax, currentMaxSum);
        }

        if (globalMax < 0) {
            return globalMax;
        } else {
            return Math.max(globalMax, total - globalMin);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,-2,3,-2}; //3
        int result = solution.maxSubarraySumCircular(nums);
        System.out.println(result);

        int[] nums2 = {5,-3,5}; //10
        result = solution.maxSubarraySumCircular(nums2);
        System.out.println(result);

        int[] nums3 = {-3,-2,-3}; //-2
        result = solution.maxSubarraySumCircular(nums3);
        System.out.println(result);
    }
}
