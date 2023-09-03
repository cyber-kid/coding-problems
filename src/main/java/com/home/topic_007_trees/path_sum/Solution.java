package com.home.topic_007_trees.path_sum;

import java.util.Objects;
import java.util.Stack;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }

        Stack<TreeNode> store = new Stack<>();

        while (!store.empty() || Objects.nonNull(root)) {
            if (Objects.nonNull(root)) {
                store.push(root);

                targetSum -= root.val;

                root = root.left;
            } else {
                root = store.pop();

                if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
                    if (targetSum == 0) {
                        return true;
                    }
                }

                if (Objects.isNull(root.right)) {
                    targetSum += root.val;
                }

                root = root.right;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
//        System.out.println("Tree has path: " + solution.hasPathSum(root, 23)); //true
//        System.out.println("Tree has path: " + solution.hasPathSum(root, 18)); //true
        System.out.println("Tree has path: " + solution.hasPathSum(root, 12)); //false
    }
}
