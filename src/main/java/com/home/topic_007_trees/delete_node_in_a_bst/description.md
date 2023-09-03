# Delete Node in a BST

https://leetcode.com/problems/delete-node-in-a-bst/

https://youtu.be/LFzAoJJt92M

There are 2 cases:
* **The node to be deleted has 0 or 1 child** - in this case the deleted node is replaced with a child or no action is needed;
* **The node to be deleted has both children** - int his case we should find a minimum node in right subtree (or maximum in left) and use it instead of the deleted node. After that we should delete the minimum node from its original position using the same approach;