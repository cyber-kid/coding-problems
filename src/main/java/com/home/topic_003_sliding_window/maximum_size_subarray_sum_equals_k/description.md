# Maximum Sum Subarray of Size K

https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/

Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:

Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:

Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].

### Algorithm
Approach: sliding window (fixed size)


1) We iterate over all elements using right pointer and sum them together
2) If the size of the window is k we take the max between the current sum and previous result and shrink the window (deduct the element at the left pointer from the current sum, move left pointer forward)