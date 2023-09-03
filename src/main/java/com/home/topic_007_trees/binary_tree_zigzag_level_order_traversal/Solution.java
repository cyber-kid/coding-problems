package com.home.topic_007_trees.binary_tree_zigzag_level_order_traversal;

import com.home.topic_007_trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (Objects.isNull(root)) {
            return result;
        }

        Queue<TreeNode> store = new LinkedList<>();
        store.offer(root);
        int level = 0;

        while (!store.isEmpty()) {
            List<Integer> levelResult = new LinkedList<>();
            int levelSize = store.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = store.poll();
                // reverse the order how we add results
                if (level % 2 == 0) {
                    levelResult.add(node.val);
                } else {
                    levelResult.add(0, node.val);
                }

                if (Objects.nonNull(node.left)) {
                    store.offer(node.left);
                }

                if (Objects.nonNull(node.right)) {
                    store.offer(node.right);
                }
            }

            result.add(levelResult);
            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
