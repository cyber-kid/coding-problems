package com.home.topic_002_two_pointers.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(nums[i])) {
                return new int[]{store.get(nums[i]), i};
            } else {
                int remainder = target - nums[i];
                store.put(remainder, i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {2,3,6,1,4}; // {0,1}
        System.out.println(Arrays.toString(solution.twoSum(nums, 5)));

        int[] nums2 = {3,2,4}; // {1,2}
        System.out.println(Arrays.toString(solution.twoSum(nums2, 6)));

        int[] nums3 = {3,3}; // {0,1}
        System.out.println(Arrays.toString(solution.twoSum(nums3, 6)));
    }
}
