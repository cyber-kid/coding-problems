# Two Sum II

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

### Algorithm
Approach: sorting, sliding window

The array is already sorted. We use two indices, initially pointing to the first and the last element, respectively. Compare the sum of these two elements with target. If the sum is equal to target, we found the exactly only solution. If it is less than target, we increase the smaller index by one. If it is greater than target, we decrease the larger index by one. Move the indices and repeat the comparison until the solution is found.

### Time complexity
O(n). The array will be traversed once at most.

### Space complexity
O(1). We store only to variables for two indices.