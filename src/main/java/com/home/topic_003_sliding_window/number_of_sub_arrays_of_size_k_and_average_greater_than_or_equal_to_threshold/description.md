# Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

https://youtu.be/D8B4tKxMTnY

### Algorithm
Approach: sliding window (fixed size)

1) Iterate over all elements in the array and sum them
2) If the size of the window is equal to k we check if the average is greater than or equal to threshold if wes we increase the result counter
3) We shrink the window. We deduct the element at left pointer from the sum and move it forward by 1