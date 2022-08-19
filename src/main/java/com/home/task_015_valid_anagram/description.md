# Valid Anagram

https://leetcode.com/problems/valid-anagram/

### Algorithm
Approach: look up table
To examine if t is a rearrangement of s, we can count occurrences of each letter in the two strings and compare them. We could use a hash table to count the frequency of each letter, however, since both s and t only contain letters from a to z, a simple array of size 26 will suffice.

Do we need two counters for comparison? Actually no, because we can increment the count for each letter in s and decrement the count for each letter in t, and then check if the count for every character is zero.

### Time complexity
O(n). We need to increment/decrement counter for each element in s and t (s and t are of the same length).

### Space complexity
O(1). We use extra space but its size does not depend on the input (it will be always array of size 26)