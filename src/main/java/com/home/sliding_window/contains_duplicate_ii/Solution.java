package com.home.sliding_window.contains_duplicate_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        Set<Integer> store = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            if (Math.abs(left - right) > k) {
                store.remove(nums[left]);
                left++;
            }
            if (store.contains(nums[right])) {
                return true;
            } else {
                store.add(nums[right]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,2,3,1}; //true
        boolean result = solution.containsNearbyDuplicate(nums, 3);
        System.out.println(result);

        int[] nums2 = {1,0,1,1}; //true
        result = solution.containsNearbyDuplicate(nums2, 1);
        System.out.println(result);

        int[] nums3 = {1,2,3,1,2,3}; //false
        result = solution.containsNearbyDuplicate(nums3, 2);
        System.out.println(result);

        int[] nums4 = {1,2}; //false
        result = solution.containsNearbyDuplicate(nums4, 2);
        System.out.println(result);

        int[] nums5 = {0,1,2,3,2,5}; //true
        result = solution.containsNearbyDuplicate(nums5, 3);
        System.out.println(result);
    }
}
