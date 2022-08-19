package com.home.task_008_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer result = store.get(nums[i]);

            if (Objects.nonNull(result)) {
                return new int[]{result, i};
            } else {
                store.put(target - nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2,3,6,1,4};
        int target = 5;

        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
