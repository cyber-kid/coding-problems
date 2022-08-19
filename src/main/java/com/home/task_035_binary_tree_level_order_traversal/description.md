# Binary Tree Level Order Traversal

https://leetcode.com/problems/binary-tree-level-order-traversal/

https://youtu.be/6ZnyEApgFYg

Recursion

The simplest way to solve the problem is to use a recursion. Let's first ensure that the tree is not empty, and then call recursively the function helper(node, level), which takes the current node and its level as the arguments.

This function does the following :
1. The output list here is called levels, and hence the current level is just a length of this list. Compare the number of a current level len(levels) with a node level level. If you're still on the previous level - add the new one by adding a new list into levels.
2. Append the node value to the last list in levels.
3. Process recursively child nodes if they are not None : helper(node.left / node.right, level + 1).

Iteration

The zero level contains only one node root. The algorithm is simple :

1. Initiate queue with a root and start from the level number 0 : level = 0.
2. While queue is not empty :
   1. Start the current level by adding an empty list into output structure levels.
   2. Compute how many elements should be on the current level : it's a queue length.
   3. Pop out all these elements from the queue and add them into the current level.
   4. Push their child nodes into the queue for the next level.
   5. Go to the next level level++.

