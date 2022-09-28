package com.home.task_059_level_order_successor;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return null;
        }

        Queue<TreeNode> store = new LinkedList<>();
        store.offer(root);

        while (!store.isEmpty()) {
            int levelSize = store.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = store.poll();

                if (Objects.nonNull(node.left)) {
                    store.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    store.offer(node.right);
                }

                if (node.val == key) {
                    return store.peek();
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 3);
        if (result != null)
            System.out.println(result.val + " ");

        root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");

        result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
    }

}
