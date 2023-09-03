package com.home.topic_007_trees.delete_node_in_a_bst;

import java.util.Objects;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return null;
        }

        // Search for the node to be deleted
        if (key > root.val) {
            // it is in a right subtree
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            // it is in a left subtree
            root.left = deleteNode(root.left, key);
        } else {
            // we should delete the current node (root)
            if (Objects.isNull(root.left)) {
                // if the left child is null, the right child will be a new root
                return root.right;
            } if (Objects.isNull(root.right)) {
                // if the right child is null, the left child will be a new root
                return root.left;
            } else {
                // current node has both children
                // so we find min value in a right subtree
                TreeNode minNode = findMinValueNode(root.right);
                // and it will be our new root
                root.val = minNode.val;
                // delete the node with min value from its original position
                root.right = deleteNode(root.right, minNode.val);
            }
        }

        return root;
    }

    private TreeNode findMinValueNode(TreeNode root) {
        TreeNode current = root;

        while (Objects.nonNull(current) && Objects.nonNull(current.left)) {
            current = current.left;
        }

        return current;
    }

    private void inOrderPrint(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        inOrderPrint(root.left);

        System.out.println(root.val);

        inOrderPrint(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        node3.left = node2;
        node3.right = node4;

        node6.right = node7;

        root.left = node3;
        root.right = node6;

        Solution solution = new Solution();
        System.out.println("Tree: ");
        solution.inOrderPrint(root);
        TreeNode modifiedRoot = solution.deleteNode(root, 3);
        System.out.println("Tree after deletion: ");
        solution.inOrderPrint(modifiedRoot);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
