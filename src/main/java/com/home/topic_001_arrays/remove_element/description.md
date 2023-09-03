# Remove Element

https://leetcode.com/problems/remove-element/

https://youtu.be/Pcd1ii9P9ZI

### Algorithm
Approach: two pointers

1) We use 2 pointers. One to iterate over all elements and the second to track the position where the next element that does not equal to val should go.
2) We iterate over all elements in a loop (using the first pointer)
3) If the element at the firs pointer is not equal to val than put it at the location of the second pointer
4) Increment the second pointer
5) Return the second pointer

### Time complexity
O(n). We need to visit all the elements in the array.

### Space complexity
O(1). We are modifying the array in-place