package com.home.topic_002_two_pointers.remove_duplicates_from_sorted_array_ii;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            int count = 1;

            while (right + 1 < nums.length && nums[right] == nums[right + 1]) {
                count++;
                right++;
            }

            for (int i = 0; i < Math.min(2, count); i++) {
                nums[left] = nums[right];
                left++;
            }

            right++;
        }

        System.out.println(Arrays.toString(nums));

        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,1,1,2,2,3}; // 5
        System.out.println(solution.removeDuplicates(nums));

        int[] nums2 = {0,0,1,1,1,1,2,3,3}; // 7
        System.out.println(solution.removeDuplicates(nums2));
    }
}
