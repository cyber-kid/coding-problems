# Longest Palindromic Substring

https://leetcode.com/problems/longest-palindromic-substring/

https://youtu.be/XYQecbcd6_c

### Intuition
We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n - 1 such centers.

You might be asking why there are 2n - 1 but not n centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as "abba") and its center is between the two 'b's.