package com.home.topic_003_sliding_window.minimum_size_subarray_sum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target && left <= right) {
                result = Math.min(result, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{2, 1, 5, 2, 3, 2}; // result = 2
        System.out.println(solution.minSubArrayLen(7, arr));

        int[] arr2 = new int[]{1,4,4}; // result = 1
        System.out.println(solution.minSubArrayLen(4, arr2));

        int[] arr3 = new int[]{1,1,1,1,1,1,1,1}; // result = 0
        System.out.println(solution.minSubArrayLen(11, arr3));
    }
}
