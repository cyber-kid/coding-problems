# Contains Duplicate

https://leetcode.com/problems/contains-duplicate/

### Algorithm
Approach: look up table

Use a hash table to store visited elements, if the element is already in the hash table return true.

### Time complexity
O(n). We need to visit all the elements in the worst case.

### Space complexity
O(n). In the worst case we will have to store all elements in the hash table.

### Option 2
Sort the array (O(n*log(n))). Than iterate over the elements if there are any duplicate integers, they will be consecutive after sorting.
