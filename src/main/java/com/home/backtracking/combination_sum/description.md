# Combination Sum

https://leetcode.com/problems/combination-sum/

https://youtu.be/GBKI9VSKdGg

### Algorithm

As one can see, the above backtracking algorithm is unfolded as a DFS (Depth-First Search) tree traversal, which is often implemented with recursion.

Here we define a recursive function of backtrack(remain, comb, start) (in Python), which populates the combinations, starting from the current combination (comb), the remaining sum to fulfill (remain) and the current cursor (start) to the list of candidates. Note that, the signature of the recursive function is slightly different in Java. But the idea remains the same.

1. For the first base case of the recursive function, if the remain==0, i.e. we fulfill the desired target sum, therefore we can add the current combination to the final list.
2. As another base case, if remain < 0, i.e. we exceed the target value, we will cease the exploration here.
3. Other than the above two base cases, we would then continue to explore the sublist of candidates as [start ... n]. For each of the candidate, we invoke the recursive function itself with updated parameters.
   1. Specifically, we add the current candidate into the combination.
   2. With the added candidate, we now have less sum to fulfill, i.e. remain - candidate.
   3. For the next exploration, still we start from the current cursor start.
   4. At the end of each exploration, we backtrack by popping out the candidate out of the combination.