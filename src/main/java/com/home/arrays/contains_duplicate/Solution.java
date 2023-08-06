package com.home.arrays.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private boolean containsDuplicate(int[] nums) {
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            if (store.contains(num)) {
                return true;
            }

            store.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,2,3,1};
        System.out.printf("A: %s, E: %s \n", solution.containsDuplicate(nums), true);

        nums = new int[]{1,2,3,4};
        System.out.printf("A: %s, E: %s \n", solution.containsDuplicate(nums), false);

        nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.printf("A: %s, E: %s \n", solution.containsDuplicate(nums), true);

        nums = new int[]{1};
        System.out.printf("A: %s, E: %s \n", solution.containsDuplicate(nums), false);

        nums = new int[]{};
        System.out.printf("A: %s, E: %s \n", solution.containsDuplicate(nums), false);
    }
}
