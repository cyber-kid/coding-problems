package com.home.arrays.remove_dups_from_sorted_array;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int currIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i -1] < nums[i]) {
                nums[currIndex] = nums[i];
                currIndex++;
            }
        }

        return currIndex;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2};
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        Solution solution = new Solution();
        int k = solution.removeDuplicates(nums);

        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
