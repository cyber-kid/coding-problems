# Number of Islands

https://leetcode.com/problems/number-of-islands/

https://youtu.be/pV2kpPD66nE

### Algorithm
Graph DFS (matrix)

1) We check every cell of the matrix
2) If it is water (we increment the count of islands) we continue with the neighbors (mark all visited nodes with 0)
3) Return the count