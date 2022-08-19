package com.home.data_structures.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    private TreeNode root = null;

    public void add(Integer data) {
        if (Objects.isNull(root)) {
            root = new TreeNode(data);

            return;
        }

        TreeNode tempRoot = root;
        while (true) {
            if (data >= tempRoot.getData()) {
                TreeNode rightNode = tempRoot.getRight();
                if (Objects.isNull(rightNode)) {
                    tempRoot.setRight(new TreeNode(data));
                    return;
                } else {
                    tempRoot = rightNode;
                }
            } else {
                TreeNode leftNode = tempRoot.getLeft();
                if (Objects.isNull(leftNode)) {
                    tempRoot.setLeft(new TreeNode(data));
                    return;
                } else {
                    tempRoot = leftNode;
                }
            }
        }
    }

    public void addRecursive(Integer data) {
        if (Objects.isNull(root)) {
            root = new TreeNode(data);

            return;
        }

        addRecursiveInternal(root, data);
    }

    private void addRecursiveInternal(TreeNode root, Integer data) {
        if (root.getData() > data) {
            if (Objects.isNull(root.getLeft())) {
                root.setLeft(new TreeNode(data));
                return;
            }
            addRecursiveInternal(root.getLeft(), data);
        } else {
            if (Objects.isNull(root.getRight())) {
                root.setRight(new TreeNode(data));
                return;
            }
            addRecursiveInternal(root.getRight(), data);
        }
    }

    public void inOrderTraversal() {
        if (Objects.isNull(root)) {
            System.out.println("The tree is empty!");
            return;
        }

        Stack<TreeNode> store = new Stack<>();
        store.push(root);

        // stack of nodes that we should process
        while (!store.isEmpty()) {
            TreeNode node = store.peek();

            // we reached the left most leaf node (with the smallest value)
            if (Objects.isNull(node.getLeft())) {
                // we remove it from pur processing stack
                node = store.pop();
                // we process it
                System.out.println(node.getData());

                // we check the nodes on the right
                if (Objects.nonNull(node.getRight())) {
                    store.push(node.getRight());
                }
                // there are more nodes on the left push them to processing stack
            } else {
                store.push(node.getLeft());
            }
        }
    }

    public void inOrderTraversalRecursive() {
        if (Objects.isNull(root)) {
            System.out.println("The tree is empty!");
            return;
        }

        inOrderTraversalRecursiveInternal(root.getLeft());

        System.out.print(root.getData());

        inOrderTraversalRecursiveInternal(root.getRight());
    }

    private void inOrderTraversalRecursiveInternal(TreeNode root) {
        if (Objects.nonNull(root.getLeft())) {
            inOrderTraversalRecursiveInternal(root.getLeft());
        }

        System.out.print(root.getData());

        if (Objects.nonNull(root.getRight())) {
            inOrderTraversalRecursiveInternal(root.getRight());
        }
    }
}
