# Contains Duplicate II

https://leetcode.com/problems/contains-duplicate-ii/description/

https://youtu.be/ypn0aZ0nrL4

### Algorithm
Approach: look up table, sliding window (fixed size)

1) We initialise the left index with 0 (the left side of the window) 
2) We iterate over all elements in the array using a right pointer (the right side of the window)
3) While the condition for the size of the window is still valid (abs(i - j) <= k) we check if the element at the right index is present in the look up table
4) If present we return true otherwise we put the element into the look up table
5) If the condition for the size of the window is not met we remove the element at left index from the look up table and increase the left index