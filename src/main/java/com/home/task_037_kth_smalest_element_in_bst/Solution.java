package com.home.task_037_kth_smalest_element_in_bst;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> store = new Stack<>();

        while (true) {
            while (Objects.nonNull(root)) {
                store.push(root);
                root = root.left;
            }

            root = store.pop();

            if (--k == 0) {
                return root.val;
            }

            root = root.right;
        }
    }

    private void inOrderTraversalRec(TreeNode root, List<Integer> orderedItems) {
        if (Objects.isNull(root)) {
            return;
        }

        inOrderTraversalRec(root.left, orderedItems);

        orderedItems.add(root.val);

        inOrderTraversalRec(root.right, orderedItems);
    }
}
