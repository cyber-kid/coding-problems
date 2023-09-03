package com.home.topic_002_two_pointers.move_zeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        for (; left < nums.length; left++) {
            nums[left] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);

        int[] nums2 = {0};
        solution.moveZeroes(nums2);

        int[] nums3 = {0,1,0,3,12,0};
        solution.moveZeroes(nums3);

        int[] nums4 = {1,3,12};
        solution.moveZeroes(nums4);
    }
}
