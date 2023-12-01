# Word Break

https://leetcode.com/problems/word-break/

https://youtu.be/Sx9NNgInc3A

### Algorithm
Dynamic programming (1D)

### Tip
1) Iterate over all words in the dictionary if the given string stars with one for the words then call the method recursively providing the remainder of the given string. The base case for the recursion is when the given string is empty (we return true). If at least one call returns true, we can stop the execution.
2) We build a dp array. We init the last index with a true flag. We iterate over all chars in the given string starting from the end and check if the substring from the current position to the end matches any of the words. If it does, we mark the index of the current position with: dp[current] = dp[current + match_word_length]. 