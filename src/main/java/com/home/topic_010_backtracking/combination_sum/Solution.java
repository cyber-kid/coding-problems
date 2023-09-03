package com.home.topic_010_backtracking.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    protected void backtrack(
            int remain,
            LinkedList<Integer> comb,
            int start,
            int[] candidates,
            List<List<Integer>> results) {

        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        // 2. when candidate larger than remain value, exit the loop
        for (int i = start; i < candidates.length && candidates[i] <= remain; ++i) {
            // add the number into the combination
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        Arrays.sort(candidates); // 1. sort the array first so we know the next element in the loop will be larger
        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates = new int[] {2,3,6,7};
        System.out.println(solution.combinationSum(candidates, 7));

    }
}
