# 3Sum

https://leetcode.com/problems/3sum/

https://www.youtube.com/watch?v=jzZsG8n2R9A

### Algorithm
Approach: sorting, sliding window

For the main function:

* Sort the input array nums.
* Iterate through the array:
  * If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
  * If the current value is the same as the one before, skip it.
  * Otherwise, call twoSumII for the current position i.
  
For twoSumII function:

* Set the low pointer lo to i + 1, and high pointer hi to the last index.
* While low pointer is smaller than high:
  * If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
  * If sum is greater than zero, decrement hi.
  * Otherwise, we found a triplet:
    * Add it to the result res.
    * Decrement hi and increment lo.
    * Increment lo while the next value is the same as before to avoid duplicates in the result.

Return the result res.

### Time complexity
O(n^2). To find 2 items that sum to a specific value is O(n) and we do that for each element in the array. Initial sorting of the array is O(n*log(n)), but we skip it because it is faster than O(n^2).

### Space complexity
O(n*log(n)) or O(n). Depends on how sorting is done.