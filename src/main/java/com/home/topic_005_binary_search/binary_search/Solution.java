package com.home.topic_005_binary_search.binary_search;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-1,0,3,5,9,12}; // 4
        System.out.println(solution.search(nums, 9));

        // -1
        System.out.println(solution.search(nums, 2));
    }
}
