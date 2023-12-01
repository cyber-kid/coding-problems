package com.home.topic_010_backtracking.subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> currentSubset = new LinkedList<>();

        Arrays.sort(nums);

        helper(0, nums, result, currentSubset);

        return result;
    }

    private void helper(int index, int[] nums, List<List<Integer>> result, LinkedList<Integer> currentSubset) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        currentSubset.push(nums[index]);
        helper(index + 1, nums, result, currentSubset);

        currentSubset.pop();
        while ((index + 1) < nums.length && nums[index] == nums[index + 1]) {
            index += 1;
        }

        helper(index + 1, nums, result, currentSubset);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};

        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(nums));
    }
}
