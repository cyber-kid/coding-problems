# Longest Repeating Character Replacement

https://leetcode.com/problems/longest-repeating-character-replacement/

https://www.youtube.com/watch?v=gqXU1UyA8pk

### Intuition


### Algorithm
Approach: sliding window (flexible size), look up table

* We need to pointers left and right both start from the beginning of the s.
* We move the right pointer forward in a loop:
  * Store the char in a look up table with its occurrences count.
  * Get the highest occurrences from the look up table into mostOccurrences.
  * If the length of current substring (right - left + 1) minus mostOccurrences is less or equals the amount of substitutions we can make, we move right pointer forward.
  * While the previous condition is not true, we move the left pointer forward and decrease the count of left - 1.
  * We compare the length of the current substring with the result.
* Return the result.

### Time complexity
O(n). We check each element once. Finding the highest occurrences from the look up table does not depend on the input because in a look up table we might have only 26 letters.

### Space complexity
O(1). The size of look up table cannot be more than 26 letters.