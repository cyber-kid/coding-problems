package com.home.topic_002_two_pointers.array_with_elements_not_equal_to_average_of_neighbors;

import java.util.Arrays;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 1; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution.rearrangeArray(nums)));

        int[] nums2 = {2,3,4,5};
        System.out.println(Arrays.toString(solution.rearrangeArray(nums2)));
    }
}
