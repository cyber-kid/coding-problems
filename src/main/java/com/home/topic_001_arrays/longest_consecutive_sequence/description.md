# Longest Consecutive Sequence

https://leetcode.com/problems/longest-consecutive-sequence/description/

https://youtu.be/B1k_sxOSgv8

### Algorithm
Approach: look up table

1) Store all items in the hash set (to have O(1) search time)
2) We iterate over all elements in the array
3) For each element num we check if the has set has a num - 1 value. If num - 1 is not present in the hash set it means that the element num can be the beginning of the consecutive sequence.
4) When we found an element that is a beginning of the sequence than we initiate the counter to 1
5) In a while loop we start checking if the consecutive elements are present in the hash set.
6) For each found element we increment the counter.
7) When the loop is over we take the max of previous answers and the current counter and save to the answer.
8) We go back to step 3
9) Return the answer