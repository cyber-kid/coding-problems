package com.home.topic_002_two_pointers.remove_duplicates_from_sorted_array;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1;

        for (int right = 1; right < nums.length; right++) {
            if (nums[right] > nums[left - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // 5
        int k = solution.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {1,1,2}; // 2
        k = solution.removeDuplicates(nums2);
        System.out.println(k);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1,1}; // 1
        k = solution.removeDuplicates(nums3);
        System.out.println(k);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {1,2}; // 2
        k = solution.removeDuplicates(nums4);
        System.out.println(k);
        System.out.println(Arrays.toString(nums4));
    }
}
