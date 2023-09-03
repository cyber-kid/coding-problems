# Lowest Common Ancestor of a Binary Search Tree

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

https://youtu.be/gs2LMfuOR9k

### Algorithm
Approach: recursion

1) The node is lca for two other nodes when those nodes are in different subtrees (or one of the nodes is lca itself)
2) If the root node is greater than both nodes that means that the lca is in the left subtree if the root node (if smaller than both nodes -> right subtree)
3) If both cases are false, then the current root node is the lca
4) Recursively perform the check from step 2
