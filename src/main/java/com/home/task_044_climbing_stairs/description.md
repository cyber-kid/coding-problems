# Climbing Stairs

https://leetcode.com/problems/climbing-stairs/

https://youtu.be/Y0lT9Fck7qI

## Approach 1: Recursion with Memoization
### Algorithm

We are redundantly calculating the result for every step. Instead, we can store the result at each step in memo array and directly returning the result from the memo array whenever that function is called again.

In this way we are pruning recursion tree with the help of memo array and reducing the size of recursion tree up to n.

## Approach 3: Dynamic Programming
### Algorithm

As we can see this problem can be broken into subproblems, and it contains the optimal substructure property i.e. its optimal solution can be constructed efficiently from optimal solutions of its subproblems, we can use dynamic programming to solve this problem.