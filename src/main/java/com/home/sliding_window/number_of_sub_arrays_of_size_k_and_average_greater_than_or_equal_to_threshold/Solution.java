package com.home.sliding_window.number_of_sub_arrays_of_size_k_and_average_greater_than_or_equal_to_threshold;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            if (right - left + 1 == k) {
                if (sum / k >= threshold) {
                    result++;
                }

                sum -= arr[left];
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {2,2,2,2,5,5,5,8}; //3
        int result = solution.numOfSubarrays(arr, 3, 4);
        System.out.println(result);

        int[] arr2 = {11,13,17,23,29,31,7,5,2,3}; //6
        result = solution.numOfSubarrays(arr2, 3, 5);
        System.out.println(result);
    }
}
