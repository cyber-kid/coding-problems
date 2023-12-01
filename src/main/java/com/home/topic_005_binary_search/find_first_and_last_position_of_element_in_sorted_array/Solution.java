package com.home.topic_005_binary_search.find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;

        // searching the right bound
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result[1] = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (result[1] == -1) {
            return result;
        }

        left = 0;
        right = result[1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {5,7,7,8,8,10};
        int[] result = solution.searchRange(nums, 8);
        System.out.println(Arrays.toString(result)); // [3,4]

        int[] nums2 = {5,7,7,8,8,10};
        result = solution.searchRange(nums2, 6);
        System.out.println(Arrays.toString(result)); // [-1,-1]

        int[] nums3 = {};
        result = solution.searchRange(nums3, 0);
        System.out.println(Arrays.toString(result)); // [-1,-1]
    }
}
