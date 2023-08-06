package com.home.sliding_window.frequency_of_the_most_frequent_element;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        int windowSize = 0;
        int left = 0;
        long total = 0;

        Arrays.sort(nums);

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            while (nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }

            windowSize = Math.max(windowSize, right - left + 1);
        }

        return windowSize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,2,4}; //3
        int result = solution.maxFrequency(nums, 5);
        System.out.println(result);

        int[] nums2 = {1,4,8,13}; //2
        result = solution.maxFrequency(nums2, 5);
        System.out.println(result);

        int[] nums3 = {3,9,6}; //1
        result = solution.maxFrequency(nums3, 2);
        System.out.println(result);
    }
}
