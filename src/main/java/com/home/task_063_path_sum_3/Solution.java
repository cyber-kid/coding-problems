package com.home.task_063_path_sum_3;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> currentPath = new LinkedList<>();

        return helperRecursion(root, targetSum, currentPath);
    }

    private int helperRecursion(TreeNode root, int targetSum, List<Integer> currentPath) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int pathCount = 0;
        int pathSum = 0;
        currentPath.add(root.val);

        ListIterator<Integer> listIterator = currentPath.listIterator(currentPath.size());
        while (listIterator.hasPrevious()) {
            pathSum += listIterator.previous();

            if (pathSum == targetSum) {
                pathCount++;
            }
        }

        pathCount += helperRecursion(root.left, targetSum, currentPath);
        pathCount += helperRecursion(root.right, targetSum, currentPath);

        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + solution.pathSum(root, 11));
    }
}
