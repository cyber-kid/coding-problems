# Longest Substring Without Repeating Characters

https://leetcode.com/problems/longest-substring-without-repeating-characters/

https://youtu.be/wiGpQwVHdE0

### Algorithm
Approach: sliding window (flexible size), look up table

1) Iterate over all elements using a right index and store that element in the look up table (set)
2) While the element at right index is present in the list then shrink the window (delete the element at left index and increase the left index)
3) Calculate the size of the window and take the max compared to the previous result