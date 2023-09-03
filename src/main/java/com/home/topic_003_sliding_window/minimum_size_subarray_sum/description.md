# Minimum Size Subarray Sum

https://leetcode.com/problems/minimum-size-subarray-sum/description/

https://youtu.be/aYqYMIqZx5s

### Algorithm
Approach: sliding window (flexible size)

1) We iterate over all elements in the array and sum them
2) While the current sum is greater or equal to target we shrink the window to check if it is possible to have a smaller window that satisfies the requirement (we move left pointer until it is smaller or equal to the right pointer)
3) We calculate the size of the window and take the min compared to previous results