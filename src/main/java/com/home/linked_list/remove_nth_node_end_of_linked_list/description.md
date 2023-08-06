# Remove Nth Node From End of List

https://leetcode.com/problems/remove-nth-node-from-end-of-list/

https://youtu.be/XVuQxVej6y8

### Algorithm
Approach: two pointers

The first pointer advances the list by n+1 steps from the beginning, while the second pointer starts from the beginning of the list. Now, both pointers are exactly separated by n nodes apart. We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node. The second pointer will be pointing at the nth node counting from the last. We relink the next pointer of the node referenced by the second pointer to point to the node's next node.

### Time complexity
O(n)

![](19_Remove_nth_node_from_end_of_listB.png)