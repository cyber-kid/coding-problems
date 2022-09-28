package com.home.task_062_path_sum_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();

        if (Objects.isNull(root)) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        int neededSum = targetSum - root.val;

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            if (neededSum == 0) {
                result.add(path);
            }
            return result;
        }

        if (Objects.nonNull(root.left)) {
            helper(root.left, neededSum, result, new ArrayList<>(path));
        }

        if (Objects.nonNull(root.right)) {
            helper(root.right, neededSum, result, new ArrayList<>(path));
        }

        return result;
    }

    private void helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        int neededSum = targetSum - root.val;
        path.add(root.val);

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            if (neededSum == 0) {
                result.add(path);
            }
            return;
        }

        if (Objects.nonNull(root.left)) {
            helper(root.left, neededSum, result, new ArrayList<>(path));
        }

        if (Objects.nonNull(root.right)) {
            helper(root.right, neededSum, result, new ArrayList<>(path));
        }
    }
}
