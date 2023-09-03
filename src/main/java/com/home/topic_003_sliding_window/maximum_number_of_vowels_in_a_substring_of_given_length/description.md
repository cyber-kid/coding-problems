# Maximum Number of Vowels in a Substring of Given Length

https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

https://youtu.be/kEfPSzgL-Ss

### Algorithm
Approach: sliding window (fixed size), look up table

1) We store all vowels in a look up table
2) We iterate over all elements using right pointer
3) We check if the element at right pointer is a vowel and if yes increase the count
4) If the size of the window is k we take the max between count and previous result and shrink the window (check if the char at left is a vowel and if yes we decrease the count, move left pointer forward)