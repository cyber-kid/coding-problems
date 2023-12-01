# Number of Connected Components in an Undirected Graph

https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

https://youtu.be/8f1XPm4WOUc

### Algorithm
graph, union find

1) We perform a DFS traversal for each node and keep track of visited nodes
2) If the next node that we are checking is not in the visited set we increment the count of connected components


1) We create an array of parent nodes where the the index represents the node and the value its parent