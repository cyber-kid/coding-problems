# Construct Binary Tree from Preorder and Inorder Traversal

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

https://youtu.be/ihj4IQGZ2zc

### Algorithm
Approach: recursion

1. Build a hashmap to record the relation of value -> index for inorder, so that we can find the position of root in constant time.
2. Initialize an integer variable preorderIndex to keep track of the element that will be used to construct the root.
3. Implement the recursion function arrayToTree which takes a range of inorder and returns the constructed binary tree:
   1. if the range is empty, return null;
   2. initialize the root with preorder[preorderIndex] and then increment preorderIndex;
   3. recursively use the left and right (they help us to understand that we do not have any elements to process (base case in recursion)) portions of inorder to construct the left and right subtrees.
4. Simply call the recursion function with the entire range of inorder.