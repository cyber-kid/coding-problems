package com.home.topic_015_greedy.maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            currentSum = Math.max(currentSum + num, num);
            result = Math.max(result, currentSum);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // 6
        int result = solution.maxSubArray(nums);
        System.out.println(result);

        int[] nums2 = {1}; // 1
        result = solution.maxSubArray(nums2);
        System.out.println(result);

        int[] nums3 = {5,4,-1,7,8}; // 23
        result = solution.maxSubArray(nums3);
        System.out.println(result);
    }
}
