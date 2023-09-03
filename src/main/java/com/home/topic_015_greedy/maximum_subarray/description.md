# Maximum Subarray

https://leetcode.com/problems/maximum-subarray/

https://youtu.be/5WZl3MMT0Eg

### Algorithm
Approach: greedy

1) We iterate over all elements in the array and sum them
2) If at some point current sum gets negative we discard it (set it to 0) because negative values will not contribute to the maximum
3) At each step we take the max between the current sum and the previous result