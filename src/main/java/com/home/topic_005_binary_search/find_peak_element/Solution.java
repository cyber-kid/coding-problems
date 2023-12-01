package com.home.topic_005_binary_search.find_peak_element;

public class Solution {
    public int findPeakElement(int[] nums) {
        int peak = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
                peak = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return peak;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1};
        int result = solution.findPeakElement(nums);
        System.out.println(result);
    }
}
