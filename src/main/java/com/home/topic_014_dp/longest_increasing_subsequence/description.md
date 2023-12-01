# Longest Increasing Subsequence

https://leetcode.com/problems/longest-increasing-subsequence/

https://youtu.be/cjWnW0hdF1Y

### Algorithm
Dynamic programming (1D)

### Tip
1) Use recursion to check every possible combination. There are 2 branches: we start with the first element if it is smaller than the next one if not we start with the next one. Return the max value of both.
2) Use a dp array to store the results for subproblems. Init the array with 1s. We need to iterate over the array multiple times starting from each position. If the current value is bigger than previous than in dp array, we store: dp[current] = max(dp[current], dp[previous] + 1)  