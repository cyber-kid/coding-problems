package com.home.topic_010_backtracking.combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int n;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> currentCombination = new LinkedList<>();

        helper(1, result, currentCombination);

        return result;
    }

    private void helper(int digit, List<List<Integer>> result, LinkedList<Integer> currentCombination) {
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        while (digit <= n) {
            currentCombination.push(digit);
            helper(digit + 1, result, currentCombination);
            currentCombination.pop();

            digit++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.combine(4, 2));
    }
}
