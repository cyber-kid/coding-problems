package com.home.task_065_find_subarray_equal_sum;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean findSubarrays(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }

        Set<Integer> store = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (store.contains(sum)) {
                return true;
            } else {
                store.add(sum);
            }
        }

        return false;
    }
}
