# Longest Substring with maximum K Distinct Characters

https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

Given a string, find the length of the longest substring in it with no more than K distinct characters.

### Algorithm
Approach: sliding window (fixed size), look up table

1) Look up table will have a char as a key and its occurrences as a value
2) The size of the window will be the amount of the distinct chars (K)
3) We iterate over each element (right pointer) and update the look up table (add a new char or increase the occurrence of already existing char)
4) If the size of the look up table is greater than K we shrink the window (decrease the occurrences of a char at left pointer or remove the char completely)
5) If the size of the look up table is equal or less than K we calculate the size of the window and take the max compared to the previous result

### Time complexity
O(n)

### Space complexity
O(k). Where K is the number of distinct chars that are allowed