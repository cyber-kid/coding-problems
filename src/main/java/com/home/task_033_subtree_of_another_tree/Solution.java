package com.home.task_033_subtree_of_another_tree;

import java.util.Objects;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (Objects.isNull(root)) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSameTree(TreeNode l, TreeNode r) {
        if (Objects.isNull(l) && Objects.isNull(r)) {
            return true;
        }
        if (Objects.isNull(l) || Objects.isNull(r) || l.val != r.val) {
            return false;
        }

        return isSameTree(l.left, r.left) && isSameTree(l.right, r.right);
    }
}
