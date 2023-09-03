package com.home.topic_002_two_pointers.number_of_subsequences_that_satisfy_the_given_sum_condition;

import java.util.Arrays;

public class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = (int) (1e9 + 7);
        Arrays.sort(nums);

        int[] powersOfTwo = new int[nums.length];
        powersOfTwo[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            powersOfTwo[i] = (powersOfTwo[i - 1] * 2) % mod;
        }

        int result = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                result = (result + powersOfTwo[right - left]) % mod;
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3,5,6,7}; // 4
        System.out.println(solution.numSubseq(nums, 9));

        int[] nums2 = {3,3,6,8}; // 6
        System.out.println(solution.numSubseq(nums2, 10));

        int[] nums3 = {2,3,3,4,6,7}; // 61
        System.out.println(solution.numSubseq(nums3, 12));

        int[] nums4 = {1}; // 1
        System.out.println(solution.numSubseq(nums4, 1));
    }
}
