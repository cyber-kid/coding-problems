package com.home.task_032_same_tree;

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
