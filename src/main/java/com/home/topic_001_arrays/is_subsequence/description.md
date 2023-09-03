# Is Subsequence

https://leetcode.com/problems/is-subsequence/description/

https://youtu.be/99RVfqklbCE

### Algorithm
Approach: 2 pointers

1) We iterate over both strings (2 pointers).
2) For the target string we move the pointer by 1 on every step. While loop until both pointers are inbound
3) For the source string we move the pointer only when the chars at the 2 pointers match
4) If we exit the loop and not all chars from the source string were matched to the target string we return false, otherwise we return true.
