# Pacific Atlantic Water Flow

https://leetcode.com/problems/pacific-atlantic-water-flow/

https://youtu.be/s-VkcjHqkGI

### Algorithm
1) We can invert the requirements and check where the water can flow from each ocean (the next cell should be greater or equal)
2) To do that, we use dfs and keep track of visited cells in 2 arrays (from the Pacific and from the Atlantic)
3) We go through each cell in the original matrix and check if it is present in both arrays of visited cells