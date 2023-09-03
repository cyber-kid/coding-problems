package com.home.topic_007_trees.binary_tree_right_side_view;

import com.home.topic_007_trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (Objects.isNull(root)) {
            return result;
        }

        LinkedList<TreeNode> store = new LinkedList<>();
        store.offer(root);

        while (!store.isEmpty()) {
            int levelSize = store.size();
            TreeNode rightNode = store.peekLast();

            result.add(rightNode.val);
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = store.poll();

                if (Objects.nonNull(node.left)) {
                    store.offer(node.left);
                }

                if (Objects.nonNull(node.right)) {
                    store.offer(node.right);
                }
            }
        }

        return result;
    }
}
