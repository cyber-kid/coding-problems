package com.home.topic_003_sliding_window.maximum_size_subarray_sum_equals_k;

public class Solution {
    public int findMaxSumSubArray(int k, int[] arr) {
        int result = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            if (right - left + 1 == k) {
                result = Math.max(result, sum);

                sum -= arr[left];
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{2, 1, 5, 1, 3, 2}; // k = 3 result = 9
        System.out.println(solution.findMaxSumSubArray(3, arr));

        int[] arr2 = new int[]{2, 3, 4, 1, 5}; // k = 2 result = 7
        System.out.println(solution.findMaxSumSubArray(2, arr2));

        int[] arr3 = new int[]{2}; // k = 1 result = 2
        System.out.println(solution.findMaxSumSubArray(1, arr3));
    }
}
