package com.home.data_structures.tree;

public class Solution {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(6);
        tree.add(7);
        tree.add(5);
        tree.add(3);
        tree.addRecursive(8);
        tree.addRecursive(2);
        tree.addRecursive(4);

        tree.inOrderTraversal();
        System.out.println();
//        tree.inOrderTraversalRecursive();
    }
}
