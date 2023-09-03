# Kth Smallest Element in a BST

https://leetcode.com/problems/kth-smallest-element-in-a-bst/

https://youtu.be/5LUXSvjmGCw

### Algorithm
Approach: Iterative (stack)

1) Use stack to implement inorder traversal 
2) Every time we pop from the stack, we reduce the k value
3) When k is 0, it means we just pooped our result and we can return it