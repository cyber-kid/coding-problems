# Graph Valid Tree

https://leetcode.com/problems/graph-valid-tree/

### Algorithm
Approach: graph

A graph, G, is a tree iff the following two conditions are met:
* G is fully connected. In other words, for every pair of nodes in G, there is a path between them.
* G contains no cycles. In other words, there is exactly one path between each pair of nodes in G.

For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't possibly be fully connected. Any more, and it has to contain cycles. Additionally, if the graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, and therefore must be a tree!

So we need to check:
1. that the graph with n verticies has n - 1 edges;
2. that all verticies are connected (dfs/bfs);