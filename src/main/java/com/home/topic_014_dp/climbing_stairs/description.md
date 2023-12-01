# Climbing Stairs

https://leetcode.com/problems/climbing-stairs/

https://youtu.be/Y0lT9Fck7qI

## Approach 1: Recursion with Memoization
### Algorithm

We are redundantly calculating the result for every step. Instead, we can store the result at each step in memo array and directly returning the result from the memo array whenever that function is called again.

In this way we are pruning recursion tree with the help of memo array and reducing the size of recursion tree up to n.

## Approach 3: Dynamic Programming
### Algorithm

1) Bottom-up approach. We are going from our target stair to the beginning.
2) We init 2 variables with 1. The first variable represents how many steps we need to get to the last stair (always 1) and the second variable represents how many steps we need to get to the last stair from the before last one (also 1).
3) The new value is calculated by summing those 2 and saved into a temp variable.
4) Shift the variable n-1 times and the first variable will be the final result.