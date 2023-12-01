# Coin Change

https://leetcode.com/problems/coin-change/

https://youtu.be/H9bfqozjoqs

### Algorithm
Dynamic programming (1D)

### Tip
1) Check all possible combinations with recursion and save the result for subproblems in the lookup table;
2) Use BFS and return the level at which the amount is 0;
3) Build a dp table from bottom (0) to up (amount) with step 1;