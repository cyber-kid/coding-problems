package com.home.levelordertraversal;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {
        StringJoiner result = new StringJoiner(" ");
        Queue<Node> unvisitedNodes = new LinkedList<>();

        visitNode(root, result, unvisitedNodes);

        while (!unvisitedNodes.isEmpty()) {
            Node node = unvisitedNodes.poll();

            visitNode(node, result, unvisitedNodes);
        }

        System.out.println(result.toString());
    }

    private static void visitNode(Node root, StringJoiner result, Queue<Node> unvisitedNodes) {
        result.add(Integer.toString(root.data));

        Node left = root.left;
        if (Objects.nonNull(left)) {
            unvisitedNodes.offer(left);
        }

        Node right = root.right;
        if (Objects.nonNull(right)) {
            unvisitedNodes.offer(right);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}