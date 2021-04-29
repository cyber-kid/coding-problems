package com.home.distancebetweentreenodes;

import java.util.List;
import java.util.Objects;

public class Solution {
    private int d1 = -1;
    private int d2 = -1;
    private int dist = 0;

    public int bstDistance(int num, List<Integer> values, int node1, int node2) {
        Node root = new Node(values.get(0));
        int searchNodesCount = 0;

        for (int i = 1; i < values.size(); i++) {
            insertNode(root, values.get(i));
        }

        return findDistance(root, node1, node2);
    }

    private int findLevel(Node root, int k, int level)
    {
        if (root == null)
            return -1;

        if (root.key == k)
            return level;

        int l = findLevel(root.left, k, level + 1);
        return (l != -1)? l : findLevel(root.right, k, level + 1);
    }

    private Node findLca(Node root, int n1, int n2, int lvl){

        if (root == null)
            return null;

        if (root.key == n1){
            d1 = lvl;
            return root;
        }
        if (root.key == n2)
        {
            d2 = lvl;
            return root;
        }

        Node left_lca = findLca(root.left, n1, n2,  lvl + 1);
        Node right_lca = findLca(root.right, n1, n2,  lvl + 1);

        if (left_lca != null && right_lca != null)
        {
            dist = (d1 + d2) - 2*lvl;
            return root;
        }

        return (left_lca != null)? left_lca : right_lca;
    }

    private int findDistance(Node root, int n1, int n2){
        d1 = -1;
        d2 = -1;
        dist = 0;
        Node lca = findLca(root, n1, n2, 1);

        if (d1 != -1 && d2 != -1)
            return dist;

        if (d1 != -1)
        {
            dist = findLevel(lca, n2, 0);
            return dist;
        }

        if (d2 != -1)
        {
            dist = findLevel(lca, n1, 0);
            return dist;
        }

        return -1;
    }

    private void insertNode(Node root, int key) {
        Node newNode = new Node(key);


        if (key < root.key) {
            if (Objects.nonNull(root.left)) {
                insertNode(root.left, key);
            } else {
                root.left = newNode;
            }
        } else {
            if (Objects.nonNull(root.right)) {
                insertNode(root.right, key);
            } else {
                root.right = newNode;
            }
        }
    }
}

class Node{
    Node left, right;
    int key;

    Node(int key){
        this.key = key;
    }
}
