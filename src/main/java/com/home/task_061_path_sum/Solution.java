package com.home.task_061_path_sum;

import java.util.Objects;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }

        int neededSum = targetSum - root.val;

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return neededSum == 0;
        }

        boolean resultLeft = false;
        boolean resultRight = false;

        if (Objects.nonNull(root.left)) {
            resultLeft = hasPathSum(root.left, neededSum);
        }

        if (Objects.nonNull(root.right)) {
            resultRight = hasPathSum(root.right, neededSum);
        }

        return resultLeft || resultRight;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + solution.hasPathSum(root, 23));
        System.out.println("Tree has path: " + solution.hasPathSum(root, 16));
        System.out.println("Tree has path: " + solution.hasPathSum(root, 12));
    }
}
