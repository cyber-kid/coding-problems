# Sliding Window Maximum

https://leetcode.com/problems/sliding-window-maximum/

https://youtu.be/DfljaUwZsOk

### Algorithm
Approach: sliding window, look up table

1. We create a double ended queue to store the indices of the elements.
2. We create 2 pointers for start and end of the window (initiate both to 0).
3. While the end pointer reaches the end of the input array.
   1. Remove all elements from the store that are smaller than the current element (at index end). We are iterating through the store from right to left.
   2. Add the index of the current element to store from the right (the biggest element will be the left most element).
   3. Check if the most right index in the store is still in the window, if not remove it.
   4. If the window is of correct size k, get the left most index from the store and add the value by this index to the result and move the window forward (end++).
   5. start++