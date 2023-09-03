# Word Search

https://leetcode.com/problems/word-search/

https://youtu.be/pfiQ_PS1g8E

### Intuition
As the general idea for the solution, we would walk around the 2D grid, and at each step, we mark our choice before jumping into the next step. And at the end of each step, we would also revert our mark so that we will have a clean slate to try another direction. In addition, the exploration is done via the DFS strategy, where we go as far as possible before we try the next direction.

### Algorithm
The skeleton of the algorithm is a loop that iterates through each cell in the grid. For each cell, we invoke the backtracking function to check if we would obtain a solution, starting from this very cell.

For the backtracking function backtrack(row, col, suffix), as a DFS algorithm, it is often implemented as a recursive function. The function can be broke down into the following four steps:

1. At the beginning, first we check if we reach the bottom case of the recursion, where the word to be matched is empty, i.e. we have already found the match for each prefix of the word.
2. We then check if the current state is invalid, either the position of the cell is out of the boundary of the board or the letter in the current cell does not match with the first letter of the word.
3. If the current step is valid, we then start the exploration of backtracking with the strategy of DFS. First, we mark the current cell as visited, e.g. any non-alphabetic letter will do. Then we iterate through the four possible directions, namely up, right, down and left. The order of the directions can be altered, to one's preference.
4. At the end of the exploration, we revert the cell back to its original state. Finally we return the result of the exploration.