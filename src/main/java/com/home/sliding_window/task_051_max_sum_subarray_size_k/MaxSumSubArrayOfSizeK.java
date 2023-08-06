package com.home.sliding_window.task_051_max_sum_subarray_size_k;

public class MaxSumSubArrayOfSizeK {
    public int findMaxSumSubArray(int k, int[] arr) {
        int start = 0;
        int end = 0;
        int result = -1;
        int sum = 0;

        while (end < arr.length) {
            sum += arr[end];

            if ((end - start + 1) >= k) {
                result = Math.max(result, sum);
                sum -= arr[start];
                start++;
            }

            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSumSubArrayOfSizeK solution = new MaxSumSubArrayOfSizeK();

//        int[] arr = new int[]{2, 1, 5, 1, 3, 2}; // k = 3 result = 9
//        int[] arr = new int[]{2, 3, 4, 1, 5}; // k = 2 result = 7
        int[] arr = new int[]{2}; // k = 1 result = 2
        System.out.println(solution.findMaxSumSubArray(1, arr));
    }
}
