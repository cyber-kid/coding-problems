# Frequency of the Most Frequent Element

https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

https://youtu.be/vgBrQ0NM5vE

### Algorithm
Approach: sliding window (flexible size)

The condition to validate the window size: We want to know that if we apply k operations all elements in a current window are the same. To do that we need:
1) We calculate the sum of all elements in the window.
2) We take the current element (at the right pointer) and multiply it by the number of the elements in the window. By doing so we assume that all the elements are equal to current one (it is the most frequent)
3) We take the value from step 2 and compare it to the value from step 1 if the difference is greater than k - we need to shrink the window (remove the element at the left pointer from the sum calculated in step 1)
