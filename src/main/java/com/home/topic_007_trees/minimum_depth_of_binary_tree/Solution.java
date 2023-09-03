package com.home.topic_007_trees.minimum_depth_of_binary_tree;

import com.home.topic_007_trees.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        Queue<TreeNode> store = new LinkedList<>();
        store.offer(root);
        int level = 1;

        while (!store.isEmpty()) {
            int levelSize = store.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = store.poll();

                if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                    return level;
                }

                if (Objects.nonNull(node.left)) {
                    store.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    store.offer(node.right);
                }
            }

            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        System.out.println(solution.minDepth(root));
    }
}
