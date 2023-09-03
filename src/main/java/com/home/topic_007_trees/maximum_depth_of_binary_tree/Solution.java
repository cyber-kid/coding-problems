package com.home.topic_007_trees.maximum_depth_of_binary_tree;

import com.home.topic_007_trees.TreeNode;

import java.util.Objects;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
