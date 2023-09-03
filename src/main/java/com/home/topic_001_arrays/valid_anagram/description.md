# Valid Anagram

https://leetcode.com/problems/valid-anagram/

### Algorithm
Approach: look up table

1) We create a look up table from one of the strings by using all chars as keys and occurrences of that char as values
2) We iterate over the second string and find each char in the look up table and decrease the occurrence of that char. If the occurrence is 0 we delete the char from the look up table
3) If in the end the look up table is empty that means that 2 strings are valid anagrams

### Time complexity
O(n). We need to increment/decrement counter for each element in s and t (s and t are of the same length).

### Space complexity
O(1). We use extra space but its size does not depend on the input (it will be always array of size 26)