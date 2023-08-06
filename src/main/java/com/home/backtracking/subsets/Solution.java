package com.home.backtracking.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, nums);

        return result;
    }

    private void backtracking(int index, int[] nums) {
        if (index >= nums.length) {
            List<Integer> subsetCopy = new ArrayList<>(subset);
            result.add(subsetCopy);

            return;
        }

        subset.add(nums[index]);
        backtracking(index + 1, nums);

        subset.remove((Integer) nums[index]);
        backtracking(index + 1, nums);
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3};
        int[] nums = {0};

        Solution solution = new Solution();

        System.out.println(solution.subsets(nums));
    }
}
