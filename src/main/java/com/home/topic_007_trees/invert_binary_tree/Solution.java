package com.home.topic_007_trees.invert_binary_tree;

import com.home.topic_007_trees.TreeNode;

import java.util.Objects;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
