package com.home.task_030_invert_binary_tree;

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
