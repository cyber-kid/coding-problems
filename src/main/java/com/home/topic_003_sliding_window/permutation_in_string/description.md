# Permutation in String

https://leetcode.com/problems/permutation-in-string/

https://youtu.be/UbyhOgBN834

### Algorithm
We should use a sliding window approach with fixed size (the size of the window is the length of s1). 

1) We fill the look up table with the characters from s1 and the count of their occurrences. 
2) We iterate over the characters of s2 (in the loop using the right pointer) and add them to the window until we reach the size of the window also adding the occurrences to the look up window (decreasing the occurrences). 
3) We check the look up table, if occurrences for each character == 0 we return true
4) Otherwise, we slide the window (left++) and remove the character at the left position from the look up table (increasing the occurrences) (next iteration in the loop for right pointer) 