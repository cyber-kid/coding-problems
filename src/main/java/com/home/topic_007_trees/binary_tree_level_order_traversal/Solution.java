package com.home.topic_007_trees.binary_tree_level_order_traversal;

import com.home.topic_007_trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> store = new LinkedList<>();
        store.offer(root);

        while (!store.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = store.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = store.poll();

                if (Objects.nonNull(node)) {
                    level.add(node.val);

                    if (Objects.nonNull(node.left)) {
                        store.offer(node.left);
                    }

                    if (Objects.nonNull(node.right)) {
                        store.offer(node.right);
                    }
                }
            }

            result.add(level);
        }

        return result;
    }

    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(root, 0, result);

        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (Objects.isNull(root)) {
            return;
        }

        if (result.size() == level) {
            List<Integer> values = new ArrayList<>();
            result.add(values);
        }

        result.get(level).add(root.val);

        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }
}
