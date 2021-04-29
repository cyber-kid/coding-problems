package com.home.common.trees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinarySearchTree {
    private TreeNode root = null;

    public TreeNode getRoot() {
        return root;
    }

    public void add(int data) {
        if (Objects.isNull(root)) {
            root = new TreeNode(data);
        } else {
            addInternal(root, data);
        }
    }

    private void addInternal(TreeNode parent, int data) {
        TreeNode newNode = new TreeNode(data);
        if (data >= parent.data) {
            if (Objects.isNull(parent.right)) {
                parent.right = newNode;
            } else {
                addInternal(parent.right, data);
            }
        } else {
            if (Objects.isNull(parent.left)) {
                parent.left = newNode;
            } else {
                addInternal(parent.left, data);
            }
        }
    }

    public void inOrderTraversal() {
        inOrderTraversalInternal(root);
    }

    private void inOrderTraversalInternal(TreeNode root) {
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            System.out.println(root.data);
        } else {
            if (Objects.nonNull(root.left)) {
                inOrderTraversalInternal(root.left);
            }

            System.out.println(root.data);

            if (Objects.nonNull(root.right)) {
                inOrderTraversalInternal(root.right);
            }
        }
    }

    public boolean isBST(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;

            if (Objects.nonNull(left)) {
                if (left.data >= node.data) {
                    return false;
                }

                nodes.offer(left);
            }

            if (Objects.nonNull(right)) {
                if (right.data < node.data) {
                    return false;
                }

                nodes.offer(right);
            }
        }

        return true;
    }

    private class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
