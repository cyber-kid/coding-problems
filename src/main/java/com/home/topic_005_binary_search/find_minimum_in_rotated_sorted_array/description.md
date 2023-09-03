# Find Minimum in Rotated Sorted Array

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

https://youtu.be/nIVW4P8b1VA

### Algorithm
Approach: binary search
The first element in the rotated array becomes greater than the last element because the array is sorted in ascending order.

So in the rotated array the minimum will be on the right side of the pivot.

1. Set the left pointer to the beginning **l = 0** and the right pointer to the end **r = nums.length - 1**
2. Set interim result to a random value **res = nums[0]**
3. In a while loop until we have elements that are not visited yet **while (l <= r)** do:
   1. If current subarray is sorted **nums[l] <= nums[r]** the first item might be the minimum, so compare it with interim result **Math.min(res, nums[l])** and stop the loop
   2. Find a middle point **m = (l + r) / 2** and set it as interim result **Math.min(res, nums[m])**
   3. Check if middle point is in a sorted portion of the array and is bigger than the first element **nums[m] >= nums[l]**
      1. If true that means that this subarray is before pivot, so we should search the other subarray to the right **l = m + 1** 
      2. If false that means that subarray to the left contains pivot and the minimum, so we should narrow down the search and search the left part **r = m - 1**
   4. Return the result

### Time complexity
O(log(n)). Every iteration we cut half of the elements.

### Space complexity
O(1). We just need few additional variables.