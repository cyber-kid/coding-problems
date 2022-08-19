package com.home.task_051_smallest_subarray_with_greater_sum;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        // we increase the window with one element at a time
        while (end < arr.length) {
            sum += arr[end];

            // while the condition is true
            // we save the result
            // and shrink the wimdow by one element at a time
            while (sum >= S) {
                result = Math.min(result, end - start + 1);
                sum -= arr[start++];
            }

            // when the condition is not met anymore we increase the window
            end++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 2, 3, 2}; // S = 7 result = 2
//        int[] arr = new int[]{2, 1, 5, 2, 8}; // S = 7 result = 1
        System.out.println(findMinSubArray(7, arr));
    }
}
