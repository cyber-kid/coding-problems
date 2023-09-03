package com.home.topic_011_graphs.task_071_clone_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }

        Map<Node, Node> oldToNewNodes = new HashMap<>();

        cloneGraphDfs(node, oldToNewNodes);

        return cloneGraphDfs(node, oldToNewNodes);
    }

    private Node cloneGraphDfs(Node node, Map<Node, Node> oldToNewNodes) {
        if (oldToNewNodes.containsKey(node)) {
            return oldToNewNodes.get(node);
        }

        Node clone = new Node(node.val);
        oldToNewNodes.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraphDfs(neighbor, oldToNewNodes));
        }

        return clone;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        Solution solution = new Solution();
        System.out.println(solution.cloneGraph(node1));
        System.out.println(node1);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}