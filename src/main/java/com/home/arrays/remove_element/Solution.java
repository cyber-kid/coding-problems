package com.home.arrays.remove_element;

import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
//        int[] nums = {2,2,2};
        int[] nums = {3,2,2,3};

        Solution solution = new Solution();

        int k = solution.removeElement(nums, 2);

        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
