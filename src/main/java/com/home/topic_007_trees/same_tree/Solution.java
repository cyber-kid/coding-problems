package com.home.topic_007_trees.same_tree;

import com.home.topic_007_trees.TreeNode;

import java.util.Objects;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }

        if (Objects.isNull(p) || Objects.isNull(q) || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, p.right);
    }
}
